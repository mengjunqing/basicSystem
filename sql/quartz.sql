DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;

-- ----------------------------
-- 1、設定された各 "jobDetail "の詳細を格納する。
-- ----------------------------
create table QRTZ_JOB_DETAILS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    job_name             varchar(200)    not null            comment 'ミッション名',
    job_group            varchar(200)    not null            comment 'タスクグループ名',
    description          varchar(250)    null                comment '関連紹介',
    job_class_name       varchar(250)    not null            comment 'エグゼクティブタスククラス名',
    is_durable           varchar(1)      not null            comment 'かどうか',
    is_nonconcurrent     varchar(1)      not null            comment '同時かどうか',
    is_update_data       varchar(1)      not null            comment 'データを更新するかどうか',
    requests_recovery    varchar(1)      not null            comment '回復の実行を受け入れるかどうか',
    job_data             blob            null                comment '永続的な保存job物体',
    primary key (sched_name, job_name, job_group)
) engine=innodb comment = 'タスクの詳細';

-- ----------------------------
-- 2、 ストレージ Trigger 情報
-- ----------------------------
create table QRTZ_TRIGGERS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    trigger_name         varchar(200)    not null            comment 'トリガーの名前',
    trigger_group        varchar(200)    not null            comment 'トリガーグループの名前',
    job_name             varchar(200)    not null            comment 'qrtz_job_detailsテーブルjob_name外側のキー',
    job_group            varchar(200)    not null            comment 'qrtz_job_detailsテーブルjob_group外側のキー',
    description          varchar(250)    null                comment '関連紹介',
    next_fire_time       bigint(13)      null                comment '最後のトリガー時間（ミリ秒）',
    prev_fire_time       bigint(13)      null                comment '次のトリガー時間（デフォルトは-1、実行しない）',
    priority             integer         null                comment '優先度',
    trigger_state        varchar(16)     not null            comment 'トリガー状態',
    trigger_type         varchar(8)      not null            comment 'トリガーのタイプ',
    start_time           bigint(13)      not null            comment '開始時間',
    end_time             bigint(13)      null                comment '終了時間',
    calendar_name        varchar(200)    null                comment 'スケジュール名前',
    misfire_instr        smallint(2)     null                comment '補償実行戦略',
    job_data             blob            null                comment '永続Jobオブジェクトを保存する',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, job_name, job_group) references QRTZ_JOB_DETAILS(sched_name, job_name, job_group)
) engine=innodb comment = 'トリガー詳細情報フォーム';

-- ----------------------------
-- 3、 繰り返し回数、間隔、トリガーされた回数など、シンプルなトリガーを保存し
-- ----------------------------
create table QRTZ_SIMPLE_TRIGGERS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    trigger_name         varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_name外側のキー',
    trigger_group        varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_group外側のキー',
    repeat_count         bigint(7)       not null            comment '繰り返し番号統計',
    repeat_interval      bigint(12)      not null            comment '重复的間隔时间',
    times_triggered      bigint(10)      not null            comment 'トリガーの数',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) engine=innodb comment = '简单触发器情報テーブルの';

-- ----------------------------
-- 4、 ストレージ Cron Trigger，含む Cron テーブルの达式和タイムゾーン信息
-- ---------------------------- 
create table QRTZ_CRON_TRIGGERS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    trigger_name         varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_name外側のキー',
    trigger_group        varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_group外側のキー',
    cron_expression      varchar(200)    not null            comment 'cronクーロン式',
    time_zone_id         varchar(80)                         comment 'タイムゾーン',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) engine=innodb comment = 'Cronタイプ - トリガーテーブル';

-- ----------------------------
-- 5、 トリガーはBlob型として保存される（QuartzユーザーがJDBCを使用して独自のカスタマイズされたトリガー型を作成し、JobStoreがインスタンスを保存する方法を知らない場合）。
-- ---------------------------- 
create table QRTZ_BLOB_TRIGGERS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    trigger_name         varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_name外側のキー',
    trigger_group        varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_group外側のキー',
    blob_data            blob            null                comment '永続的な保存Trigger物体',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) engine=innodb comment = 'Blobタイプ - トリガーのテーブル';

-- ----------------------------
-- 6、 カレンダー情報をBlobとして保存するには、クォーツは時間範囲を指定するようにカレンダーを構成できます。
-- ---------------------------- 
create table QRTZ_CALENDARS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    calendar_name        varchar(200)    not null            comment 'カレンダー名',
    calendar             blob            not null            comment '永続的な保存calendar物体',
    primary key (sched_name, calendar_name)
) engine=innodb comment = 'カレンダー情報テーブル';

-- ----------------------------
-- 7、 中断されたトリガーグループの情報を保存する
-- ---------------------------- 
create table QRTZ_PAUSED_TRIGGER_GRPS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    trigger_group        varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_group外側のキー',
    primary key (sched_name, trigger_group)
) engine=innodb comment = '一時停止トリガーのテーブル';

-- ----------------------------
-- 8、 トリガーされたトリガーに関連するステータス情報と、関連するジョブの実行情報を保存します。
-- ---------------------------- 
create table QRTZ_FIRED_TRIGGERS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    entry_id             varchar(95)     not null            comment 'スケジューラインスタンスid',
    trigger_name         varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_name外側のキー',
    trigger_group        varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_group外側のキー',
    instance_name        varchar(200)    not null            comment 'スケジューラインスタンス名',
    fired_time           bigint(13)      not null            comment 'トリガー時間',
    sched_time           bigint(13)      not null            comment 'タイマーの時間',
    priority             integer         not null            comment '優先度',
    state                varchar(16)     not null            comment 'ステータス',
    job_name             varchar(200)    null                comment 'ミッション名',
    job_group            varchar(200)    null                comment 'タスクグループ名',
    is_nonconcurrent     varchar(1)      null                comment 'コンカレンシー',
    requests_recovery    varchar(1)      null                comment '実施再開の受け入れ',
    primary key (sched_name, entry_id)
) engine=innodb comment = 'トリガー済・テーブル';

-- ----------------------------
-- 9、 スケジューラのステータスに関する少量の情報を保存し、クラスタ内で使用されている場合は、他のスケジューラ・インスタンスを見ることができる。
-- ---------------------------- 
create table QRTZ_SCHEDULER_STATE (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    instance_name        varchar(200)    not null            comment '実例名称',
    last_checkin_time    bigint(13)      not null            comment '最後の検査時間',
    checkin_interval     bigint(13)      not null            comment '检查間隔时间',
    primary key (sched_name, instance_name)
) engine=innodb comment = '调度器州テーブルの';

-- ----------------------------
-- 10、 ストレージ程序的悲观锁情報(悲観的なロックを使用する場合)
-- ---------------------------- 
create table QRTZ_LOCKS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    lock_name            varchar(40)     not null            comment '悲観的なロック名',
    primary key (sched_name, lock_name)
) engine=innodb comment = 'ストレージ的悲观锁信息テーブルの';

-- ----------------------------
-- 11、 同期メカニズムのQuartzクラスタ実装のための行ロックテーブル
-- ---------------------------- 
create table QRTZ_SIMPROP_TRIGGERS (
    sched_name           varchar(120)    not null            comment 'スケジューリング名',
    trigger_name         varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_name外側のキー',
    trigger_group        varchar(200)    not null            comment 'qrtz_triggersテーブルのtrigger_group外側のキー',
    str_prop_1           varchar(512)    null                comment 'Stringタイプ的trigger最初のパラメーター',
    str_prop_2           varchar(512)    null                comment 'Stringタイプ的trigger2番目のパラメーター',
    str_prop_3           varchar(512)    null                comment 'Stringタイプ的trigger3番目のパラメーター',
    int_prop_1           int             null                comment 'intタイプ的trigger最初のパラメーター',
    int_prop_2           int             null                comment 'intタイプ的trigger2番目のパラメーター',
    long_prop_1          bigint          null                comment 'longタイプ的trigger最初のパラメーター',
    long_prop_2          bigint          null                comment 'longタイプ的trigger2番目のパラメーター',
    dec_prop_1           numeric(13,4)   null                comment 'decimalタイプ的trigger最初のパラメーター',
    dec_prop_2           numeric(13,4)   null                comment 'decimalタイプ的trigger2番目のパラメーター',
    bool_prop_1          varchar(1)      null                comment 'Booleanタイプ的trigger最初のパラメーター',
    bool_prop_2          varchar(1)      null                comment 'Booleanタイプ的trigger2番目のパラメーター',
    primary key (sched_name, trigger_name, trigger_group),
    foreign key (sched_name, trigger_name, trigger_group) references QRTZ_TRIGGERS(sched_name, trigger_name, trigger_group)
) engine=innodb comment = '同期メカニズムのための行ロックテーブル';

commit;
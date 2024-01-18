-- ----------------------------
-- 1、部門テーブル
-- ----------------------------
drop table if exists sys_dept;
create table sys_dept (
  dept_id           bigint(20)      not null auto_increment    comment '部門id',
  parent_id         bigint(20)      default 0                  comment '親部門id',
  ancestors         varchar(50)     default ''                 comment '先祖のリスト',
  dept_name         varchar(30)     default ''                 comment '部門名',
  order_num         int(4)          default 0                  comment '表示順',
  leader            varchar(20)     default null               comment '主要',
  phone             varchar(11)     default null               comment '連絡先番号',
  email             varchar(50)     default null               comment '郵便',
  status            char(1)         default '0'                comment '部門ステータス（0普通 1停止）',
  del_flag          char(1)         default '0'                comment '消去ステータス（0代表する 2消去）',
  create_by         varchar(64)     default ''                 comment '作成者',
  create_time 	    datetime                                   comment '作成時間',
  update_by         varchar(64)     default ''                 comment 'アップデーター',
  update_time       datetime                                   comment '更新時間',
  primary key (dept_id)
) engine=innodb auto_increment=200 comment = '部門テーブル';

-- ----------------------------
-- 初期化 - 部門テーブルデータ
-- ----------------------------
insert into sys_dept values(100,  0,   '0',          'DXCompass',   0, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(101,  100, '0,100',      '東京', 1, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(102,  100, '0,100',      '大阪', 2, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(103,  101, '0,100,101',  '開発部',   1, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(104,  101, '0,100,101',  '市場部',   2, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(105,  101, '0,100,101',  '情報部',   3, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(106,  101, '0,100,101',  '会計部',   4, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(107,  101, '0,100,101',  'IT部',   5, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(108,  102, '0,100,102',  '人事部',   1, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(109,  102, '0,100,102',  '戦略部',   2, 'DXC', '07022224444', 'dx@dxcompass.co.jp', '0', '0', 'admin', sysdate(), '', null);


-- ----------------------------
-- 2、ユーザー情報テーブル
-- ----------------------------
drop table if exists sys_user;
create table sys_user (
  user_id           bigint(20)      not null auto_increment    comment 'ユーザーID',
  dept_id           bigint(20)      default null               comment '部門ID',
  user_name         varchar(30)     not null                   comment '名前',
  nick_name         varchar(30)     not null                   comment 'ニックネーム',
  user_type         varchar(2)      default '00'               comment 'ユーザータイプ（00システムユーザー）',
  email             varchar(50)     default ''                 comment 'メール',
  phonenumber       varchar(11)     default ''                 comment '携帯番号',
  sex               char(1)         default '0'                comment '性別（0男 1女性 2知らない）',
  avatar            varchar(100)    default ''                 comment 'アバターアドレス',
  password          varchar(100)    default ''                 comment 'パスワード',
  status            char(1)         default '0'                comment 'アカウントのステータス（0普通 1停止）',
  del_flag          char(1)         default '0'                comment '消去（0代表する 2消去）',
  login_ip          varchar(128)    default ''                 comment '前回のログインIP',
  login_date        datetime                                   comment '前回のログイン時間',
  create_by         varchar(64)     default ''                 comment '作成者',
  create_time       datetime                                   comment '作成時間',
  update_by         varchar(64)     default ''                 comment 'アップデーター',
  update_time       datetime                                   comment '更新時間',
  remark            varchar(500)    default null               comment '備考',
  primary key (user_id)
) engine=innodb auto_increment=100 comment = 'ユーザー情報テーブル';

-- ----------------------------
-- 初期化-ユーザー情報表データ
-- ----------------------------
insert into sys_user values(1,  103, 'admin', 'DXC', '00', 'dx@dxcompass.co.jp', '07022224444', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '管理者');
insert into sys_user values(2,  105, 'ry',    'DXC', '00', 'dx@dxcompass.co.jp',  '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, 'テスター');


-- ----------------------------
-- 3、ジョブ情報テーブル
-- ----------------------------
drop table if exists sys_post;
create table sys_post
(
  post_id       bigint(20)      not null auto_increment    comment '役職ID',
  post_code     varchar(64)     not null                   comment '役職コード',
  post_name     varchar(50)     not null                   comment '役職名前',
  post_sort     int(4)          not null                   comment '表示順',
  status        char(1)         not null                   comment 'ステータス（0普通 1停止）',
  create_by     varchar(64)     default ''                 comment '作成者',
  create_time   datetime                                   comment '作成時間',
  update_by     varchar(64)     default ''			       comment 'アップデーター',
  update_time   datetime                                   comment '更新時間',
  remark        varchar(500)    default null               comment '備考',
  primary key (post_id)
) engine=innodb comment = 'ジョブ情報テーブル';

-- ----------------------------
-- 初期化-ジョブ情報テーブルデータ
-- ----------------------------
insert into sys_post values(1, 'ceo',  '社長',    1, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(2, 'se',   'プロジェクトマネージャー',  2, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(3, 'hr',   '人事',  3, '0', 'admin', sysdate(), '', null, '');
insert into sys_post values(4, 'user', '一般職',  4, '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 4、ロール情報テーブル
-- ----------------------------
drop table if exists sys_role;
create table sys_role (
  role_id              bigint(20)      not null auto_increment    comment '役割ID',
  role_name            varchar(30)     not null                   comment '役割名前',
  role_key             varchar(100)    not null                   comment 'ロール権限文字列',
  role_sort            int(4)          not null                   comment '表示順',
  data_scope           char(1)         default '1'                comment 'データ範囲（1：すべてのデータ権限 2：カスタマイズされたデータ権限 3：本部門データ権限 4：本部門及以下データ権限）',
  menu_check_strictly  tinyint(1)      default 1                  comment 'メニューツリーの選択項目を関連付けて表示するかどうか。',
  dept_check_strictly  tinyint(1)      default 1                  comment '部門ツリーの選択項目を関連付け表示するかどうか',
  status               char(1)         not null                   comment '役割ステータス（0普通 1停止）',
  del_flag             char(1)         default '0'                comment '消去ステータス（0代表する 2消去）',
  create_by            varchar(64)     default ''                 comment '作成者',
  create_time          datetime                                   comment '作成時間',
  update_by            varchar(64)     default ''                 comment 'アップデーター',
  update_time          datetime                                   comment '更新時間',
  remark               varchar(500)    default null               comment '備考',
  primary key (role_id)
) engine=innodb auto_increment=100 comment = 'ロール情報テーブル';

-- ----------------------------
-- 初期化-ロール情報テーブルデータ
-- ----------------------------
insert into sys_role values('1', 'スーパー管理者',  'admin',  1, 1, 1, 1, '0', '0', 'admin', sysdate(), '', null, 'スーパー管理者');
insert into sys_role values('2', '普通役割',    'common', 2, 2, 1, 1, '0', '0', 'admin', sysdate(), '', null, '普通役割');


-- ----------------------------
-- 5、メニュー権限テーブル
-- ----------------------------
drop table if exists sys_menu;
create table sys_menu (
  menu_id           bigint(20)      not null auto_increment    comment 'メニューID',
  menu_name         varchar(50)     not null                   comment 'メニュー名称',
  parent_id         bigint(20)      default 0                  comment '親メニューID',
  order_num         int(4)          default 0                  comment '表示順',
  path              varchar(200)    default ''                 comment 'ルーティングアドレス',
  component         varchar(255)    default null               comment 'コンポーネントパス',
  query             varchar(255)    default null               comment 'ルーティングパラメーター',
  is_frame          int(1)          default 1                  comment 'それが外部チェーンであるかどうか（0はい 1いいえ）',
  is_cache          int(1)          default 0                  comment 'はいいいえキャッシュ（0キャッシュ 1不キャッシュ）',
  menu_type         char(1)         default ''                 comment 'メニュータイプ（M目次 Cメニュー Fボタン）',
  visible           char(1)         default 0                  comment 'メニューステータス（0見せる 1隠れる）',
  status            char(1)         default 0                  comment 'メニューステータス（0普通 1停止）',
  perms             varchar(100)    default null               comment '権限',
  icon              varchar(100)    default '#'                comment 'メニュー图标',
  create_by         varchar(64)     default ''                 comment '作成者',
  create_time       datetime                                   comment '作成時間',
  update_by         varchar(64)     default ''                 comment 'アップデーター',
  update_time       datetime                                   comment '更新時間',
  remark            varchar(500)    default ''                 comment '備考',
  primary key (menu_id)
) engine=innodb auto_increment=2000 comment = 'メニュー権限テーブル';

-- ----------------------------
-- 初期化-メニュー情報テーブルデータ
-- ----------------------------
-- 一段メニュー
insert into sys_menu values('1', 'システムマネジメント', '0', '1', 'system',           null, '', 1, 0, 'M', '0', '0', '', 'system',   'admin', sysdate(), '', null, 'システムマネジメント目次');
insert into sys_menu values('2', 'システム監視', '0', '2', 'monitor',          null, '', 1, 0, 'M', '0', '0', '', 'monitor',  'admin', sysdate(), '', null, 'システム監視目次');
insert into sys_menu values('3', 'システムツール', '0', '3', 'tool',             null, '', 1, 0, 'M', '0', '0', '', 'tool',     'admin', sysdate(), '', null, 'システムツール目次');
insert into sys_menu values('4', 'DXCウェブサイト', '0', '4', 'http://localhost', null, '', 0, 0, 'M', '0', '0', '', 'guide',    'admin', sysdate(), '', null, 'DXCウェブサイト');
-- 二段メニュー
insert into sys_menu values('100',  'ユーザー管理', '1',   '1', 'user',       'system/user/index',        '', 1, 0, 'C', '0', '0', 'system:user:list',        'user',          'admin', sysdate(), '', null, 'ユーザー管理メニュー');
insert into sys_menu values('101',  '役割管理', '1',   '2', 'role',       'system/role/index',        '', 1, 0, 'C', '0', '0', 'system:role:list',        'peoples',       'admin', sysdate(), '', null, '役割管理メニュー');
insert into sys_menu values('102',  'メニュー管理', '1',   '3', 'menu',       'system/menu/index',        '', 1, 0, 'C', '0', '0', 'system:menu:list',        'tree-table',    'admin', sysdate(), '', null, 'メニュー管理メニュー');
insert into sys_menu values('103',  '部門管理', '1',   '4', 'dept',       'system/dept/index',        '', 1, 0, 'C', '0', '0', 'system:dept:list',        'tree',          'admin', sysdate(), '', null, '部門管理メニュー');
insert into sys_menu values('104',  '役職管理', '1',   '5', 'post',       'system/post/index',        '', 1, 0, 'C', '0', '0', 'system:post:list',        'post',          'admin', sysdate(), '', null, '役職管理メニュー');
insert into sys_menu values('105',  '辞書管理', '1',   '6', 'dict',       'system/dict/index',        '', 1, 0, 'C', '0', '0', 'system:dict:list',        'dict',          'admin', sysdate(), '', null, '辞書管理メニュー');
insert into sys_menu values('106',  'パラメーター設定', '1',   '7', 'config',     'system/config/index',      '', 1, 0, 'C', '0', '0', 'system:config:list',      'edit',          'admin', sysdate(), '', null, 'パラメーター設定メニュー');
insert into sys_menu values('107',  '発表', '1',   '8', 'notice',     'system/notice/index',      '', 1, 0, 'C', '0', '0', 'system:notice:list',      'message',       'admin', sysdate(), '', null, '発表メニュー');
insert into sys_menu values('108',  'ログ管理', '1',   '9', 'log',        '',                         '', 1, 0, 'M', '0', '0', '',                        'log',           'admin', sysdate(), '', null, 'ログ管理メニュー');
insert into sys_menu values('109',  'オンラインユーザー', '2',   '1', 'online',     'monitor/online/index',     '', 1, 0, 'C', '0', '0', 'monitor:online:list',     'online',        'admin', sysdate(), '', null, 'オンラインユーザーメニュー');
insert into sys_menu values('110',  'タイミングタスク', '2',   '2', 'job',        'monitor/job/index',        '', 1, 0, 'C', '0', '0', 'monitor:job:list',        'job',           'admin', sysdate(), '', null, 'タイミングタスクメニュー');
insert into sys_menu values('111',  'データ監視', '2',   '3', 'druid',      'monitor/druid/index',      '', 1, 0, 'C', '0', '0', 'monitor:druid:list',      'druid',         'admin', sysdate(), '', null, 'データ監視メニュー');
insert into sys_menu values('112',  'サービス監視', '2',   '4', 'server',     'monitor/server/index',     '', 1, 0, 'C', '0', '0', 'monitor:server:list',     'server',        'admin', sysdate(), '', null, 'サービス監視メニュー');
insert into sys_menu values('113',  'キャッシュ监控', '2',   '5', 'cache',      'monitor/cache/index',      '', 1, 0, 'C', '0', '0', 'monitor:cache:list',      'redis',         'admin', sysdate(), '', null, 'キャッシュ监控メニュー');
insert into sys_menu values('114',  'キャッシュリスト', '2',   '6', 'cacheList',  'monitor/cache/list',       '', 1, 0, 'C', '0', '0', 'monitor:cache:list',      'redis-list',    'admin', sysdate(), '', null, 'キャッシュリストメニュー');
insert into sys_menu values('115',  'フォーム構造', '3',   '1', 'build',      'tool/build/index',         '', 1, 0, 'C', '0', '0', 'tool:build:list',         'build',         'admin', sysdate(), '', null, 'フォーム構造メニュー');
insert into sys_menu values('116',  'コード生成', '3',   '2', 'gen',        'tool/gen/index',           '', 1, 0, 'C', '0', '0', 'tool:gen:list',           'code',          'admin', sysdate(), '', null, 'コード生成メニュー');
insert into sys_menu values('117',  'システムインターフェイス', '3',   '3', 'swagger',    'tool/swagger/index',       '', 1, 0, 'C', '0', '0', 'tool:swagger:list',       'swagger',       'admin', sysdate(), '', null, 'システムインターフェイスメニュー');
-- 三段メニュー
insert into sys_menu values('500',  '操作ログ', '108', '1', 'operlog',    'monitor/operlog/index',    '', 1, 0, 'C', '0', '0', 'monitor:operlog:list',    'form',          'admin', sysdate(), '', null, '操作ログメニュー');
insert into sys_menu values('501',  'ログインログ', '108', '2', 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor',    'admin', sysdate(), '', null, 'ログインログメニュー');
-- ユーザー管理ボタン
insert into sys_menu values('1000', 'ユーザークエリ', '100', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1001', 'ユーザー増加', '100', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1002', 'ユーザー改訂', '100', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1003', 'ユーザー消去', '100', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1004', 'ユーザーエクスポート', '100', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:export',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1005', 'ユーザーインポート', '100', '6',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:import',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1006', 'パスワードリセット', '100', '7',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd',       '#', 'admin', sysdate(), '', null, '');
-- 役割管理ボタン
insert into sys_menu values('1007', '役割クエリ', '101', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1008', '役割増加', '101', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1009', '役割改訂', '101', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1010', '役割消去', '101', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1011', '役割エクスポート', '101', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:export',         '#', 'admin', sysdate(), '', null, '');
-- メニュー管理ボタン
insert into sys_menu values('1012', 'メニュークエリ', '102', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1013', 'メニュー増加', '102', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1014', 'メニュー改訂', '102', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1015', 'メニュー消去', '102', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove',         '#', 'admin', sysdate(), '', null, '');
-- 部門管理ボタン
insert into sys_menu values('1016', '部門クエリ', '103', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1017', '部門増加', '103', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1018', '部門改訂', '103', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1019', '部門消去', '103', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove',         '#', 'admin', sysdate(), '', null, '');
-- 役職管理ボタン
insert into sys_menu values('1020', '役職クエリ', '104', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1021', '役職増加', '104', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1022', '役職改訂', '104', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1023', '役職消去', '104', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1024', '役職导出', '104', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:export',         '#', 'admin', sysdate(), '', null, '');
-- 辞書管理ボタン
insert into sys_menu values('1025', '辞書', '105', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1026', '辞書', '105', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1027', '辞書の変更', '105', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1028', '辞書削除', '105', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1029', '辞書のエクスポート', '105', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export',         '#', 'admin', sysdate(), '', null, '');
-- パラメーター設定ボタン
insert into sys_menu values('1030', 'パラメータークエリ', '106', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query',        '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1031', 'パラメーターが追加されています', '106', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1032', 'パラメーターの変更', '106', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1033', 'パラメーター削除', '106', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove',       '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1034', 'パラメーターエクスポート', '106', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export',       '#', 'admin', sysdate(), '', null, '');
-- 発表ボタン
insert into sys_menu values('1035', '発表', '107', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query',        '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1036', '発表する', '107', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1037', '発表の変更', '107', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1038', 'アナウンス削除', '107', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove',       '#', 'admin', sysdate(), '', null, '');
-- 操作ログボタン
insert into sys_menu values('1039', '操作クエリ', '500', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query',      '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1040', '消去', '500', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove',     '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1041', 'ログエクスポート', '500', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export',     '#', 'admin', sysdate(), '', null, '');
-- ログインログボタン
insert into sys_menu values('1042', 'ログインクエリ', '501', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1043', 'ログイン削除', '501', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove',  '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1044', 'ログエクスポート', '501', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export',  '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1045', 'アカウントのロックを解除します', '501', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:unlock',  '#', 'admin', sysdate(), '', null, '');
-- 在线ユーザーボタン
insert into sys_menu values('1046', 'オンライン検索', '109', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query',       '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1047', 'バッチ', '109', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1048', '努力する', '109', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', sysdate(), '', null, '');
-- タイミングタスクボタン
insert into sys_menu values('1049', 'ミッションクエリ', '110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query',          '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1050', '新しい仕事', '110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1051', 'ミッションの変更', '110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1052', 'ミッション削除', '110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove',         '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1053', 'ステータス改訂', '110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus',   '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1054', '輸出', '110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export',         '#', 'admin', sysdate(), '', null, '');
-- コード生成ボタン
insert into sys_menu values('1055', 'クエリを生成します', '116', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query',             '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1056', '変更を生成します', '116', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit',              '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1057', '削除を生成します', '116', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1058', 'コードをインポートします', '116', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import',            '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1059', 'プレビューコード', '116', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview',           '#', 'admin', sysdate(), '', null, '');
insert into sys_menu values('1060', 'コードを生成します', '116', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code',              '#', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 6、ユーザーとロールの関連テーブル  ユーザーN-1役割
-- ----------------------------
drop table if exists sys_user_role;
create table sys_user_role (
  user_id   bigint(20) not null comment 'ユーザーID',
  role_id   bigint(20) not null comment '役割ID',
  primary key(user_id, role_id)
) engine=innodb comment = 'ユーザーとロールの関連テーブル';

-- ----------------------------
-- 初期化 - ユーザーと役割の関連テーブルデータ
-- ----------------------------
insert into sys_user_role values ('1', '1');
insert into sys_user_role values ('2', '2');


-- ----------------------------
-- 7、役割とメニューの関連テーブル  役割1-Nメニュー
-- ----------------------------
drop table if exists sys_role_menu;
create table sys_role_menu (
  role_id   bigint(20) not null comment '役割ID',
  menu_id   bigint(20) not null comment 'メニューID',
  primary key(role_id, menu_id)
) engine=innodb comment = '役割とメニューの関連テーブル';

-- ----------------------------
-- 初期化-役割とメニューのリンク・テーブル・データ
-- ----------------------------
insert into sys_role_menu values ('2', '1');
insert into sys_role_menu values ('2', '2');
insert into sys_role_menu values ('2', '3');
insert into sys_role_menu values ('2', '4');
insert into sys_role_menu values ('2', '100');
insert into sys_role_menu values ('2', '101');
insert into sys_role_menu values ('2', '102');
insert into sys_role_menu values ('2', '103');
insert into sys_role_menu values ('2', '104');
insert into sys_role_menu values ('2', '105');
insert into sys_role_menu values ('2', '106');
insert into sys_role_menu values ('2', '107');
insert into sys_role_menu values ('2', '108');
insert into sys_role_menu values ('2', '109');
insert into sys_role_menu values ('2', '110');
insert into sys_role_menu values ('2', '111');
insert into sys_role_menu values ('2', '112');
insert into sys_role_menu values ('2', '113');
insert into sys_role_menu values ('2', '114');
insert into sys_role_menu values ('2', '115');
insert into sys_role_menu values ('2', '116');
insert into sys_role_menu values ('2', '117');
insert into sys_role_menu values ('2', '500');
insert into sys_role_menu values ('2', '501');
insert into sys_role_menu values ('2', '1000');
insert into sys_role_menu values ('2', '1001');
insert into sys_role_menu values ('2', '1002');
insert into sys_role_menu values ('2', '1003');
insert into sys_role_menu values ('2', '1004');
insert into sys_role_menu values ('2', '1005');
insert into sys_role_menu values ('2', '1006');
insert into sys_role_menu values ('2', '1007');
insert into sys_role_menu values ('2', '1008');
insert into sys_role_menu values ('2', '1009');
insert into sys_role_menu values ('2', '1010');
insert into sys_role_menu values ('2', '1011');
insert into sys_role_menu values ('2', '1012');
insert into sys_role_menu values ('2', '1013');
insert into sys_role_menu values ('2', '1014');
insert into sys_role_menu values ('2', '1015');
insert into sys_role_menu values ('2', '1016');
insert into sys_role_menu values ('2', '1017');
insert into sys_role_menu values ('2', '1018');
insert into sys_role_menu values ('2', '1019');
insert into sys_role_menu values ('2', '1020');
insert into sys_role_menu values ('2', '1021');
insert into sys_role_menu values ('2', '1022');
insert into sys_role_menu values ('2', '1023');
insert into sys_role_menu values ('2', '1024');
insert into sys_role_menu values ('2', '1025');
insert into sys_role_menu values ('2', '1026');
insert into sys_role_menu values ('2', '1027');
insert into sys_role_menu values ('2', '1028');
insert into sys_role_menu values ('2', '1029');
insert into sys_role_menu values ('2', '1030');
insert into sys_role_menu values ('2', '1031');
insert into sys_role_menu values ('2', '1032');
insert into sys_role_menu values ('2', '1033');
insert into sys_role_menu values ('2', '1034');
insert into sys_role_menu values ('2', '1035');
insert into sys_role_menu values ('2', '1036');
insert into sys_role_menu values ('2', '1037');
insert into sys_role_menu values ('2', '1038');
insert into sys_role_menu values ('2', '1039');
insert into sys_role_menu values ('2', '1040');
insert into sys_role_menu values ('2', '1041');
insert into sys_role_menu values ('2', '1042');
insert into sys_role_menu values ('2', '1043');
insert into sys_role_menu values ('2', '1044');
insert into sys_role_menu values ('2', '1045');
insert into sys_role_menu values ('2', '1046');
insert into sys_role_menu values ('2', '1047');
insert into sys_role_menu values ('2', '1048');
insert into sys_role_menu values ('2', '1049');
insert into sys_role_menu values ('2', '1050');
insert into sys_role_menu values ('2', '1051');
insert into sys_role_menu values ('2', '1052');
insert into sys_role_menu values ('2', '1053');
insert into sys_role_menu values ('2', '1054');
insert into sys_role_menu values ('2', '1055');
insert into sys_role_menu values ('2', '1056');
insert into sys_role_menu values ('2', '1057');
insert into sys_role_menu values ('2', '1058');
insert into sys_role_menu values ('2', '1059');
insert into sys_role_menu values ('2', '1060');

-- ----------------------------
-- 8、役割和部門の関連テーブル  役割1-N部門
-- ----------------------------
drop table if exists sys_role_dept;
create table sys_role_dept (
  role_id   bigint(20) not null comment '役割ID',
  dept_id   bigint(20) not null comment '部門ID',
  primary key(role_id, dept_id)
) engine=innodb comment = '役割和部門の関連テーブル';

-- ----------------------------
-- 初期化-役割和部門の関連テーブルデータ
-- ----------------------------
insert into sys_role_dept values ('2', '100');
insert into sys_role_dept values ('2', '101');
insert into sys_role_dept values ('2', '105');


-- ----------------------------
-- 9、ユーザー与役職の関連テーブル  ユーザー1-N役職
-- ----------------------------
drop table if exists sys_user_post;
create table sys_user_post
(
  user_id   bigint(20) not null comment 'ユーザーID',
  post_id   bigint(20) not null comment '役職ID',
  primary key (user_id, post_id)
) engine=innodb comment = 'ユーザー与役職の関連テーブル';

-- ----------------------------
-- 初期化-ユーザー与役職の関連テーブルデータ
-- ----------------------------
insert into sys_user_post values ('1', '1');
insert into sys_user_post values ('2', '2');


-- ----------------------------
-- 10、操作ログ記録
-- ----------------------------
drop table if exists sys_oper_log;
create table sys_oper_log (
  oper_id           bigint(20)      not null auto_increment    comment 'ログプライマリキー',
  title             varchar(50)     default ''                 comment 'モジュールタイトル',
  business_type     int(2)          default 0                  comment '事業の種類（0他の 1増加 2改訂 3消去）',
  method            varchar(100)    default ''                 comment 'メソッド名',
  request_method    varchar(10)     default ''                 comment 'リクエスト方法',
  operator_type     int(1)          default 0                  comment '操作カテゴリ（0他の 1バックオフィス・ユーザー 2スマトユーザー）',
  oper_name         varchar(50)     default ''                 comment 'オペレーター',
  dept_name         varchar(50)     default ''                 comment '部門名',
  oper_url          varchar(255)    default ''                 comment 'リクエスト URL',
  oper_ip           varchar(128)    default ''                 comment 'ホストIP',
  oper_location     varchar(255)    default ''                 comment '活動場所',
  oper_param        varchar(2000)   default ''                 comment 'リクエストパラメータ',
  json_result       varchar(2000)   default ''                 comment 'リターンパラメータ',
  status            int(1)          default 0                  comment '操作ステータス（0普通 1异常）',
  error_msg         varchar(2000)   default ''                 comment 'エラーメッセージ',
  oper_time         datetime                                   comment '稼働時間',
  cost_time         bigint(20)      default 0                  comment '経過時間',
  primary key (oper_id),
  key idx_sys_oper_log_bt (business_type),
  key idx_sys_oper_log_s  (status),
  key idx_sys_oper_log_ot (oper_time)
) engine=innodb auto_increment=100 comment = '操作ログ記録';


-- ----------------------------
-- 11、辞書タイプテーブル
-- ----------------------------
drop table if exists sys_dict_type;
create table sys_dict_type
(
  dict_id          bigint(20)      not null auto_increment    comment '辞書の主キー',
  dict_name        varchar(100)    default ''                 comment '辞書名',
  dict_type        varchar(100)    default ''                 comment '辞書タイプ',
  status           char(1)         default '0'                comment 'ステータス（0普通 1停止）',
  create_by        varchar(64)     default ''                 comment '作成者',
  create_time      datetime                                   comment '作成時間',
  update_by        varchar(64)     default ''                 comment 'アップデーター',
  update_time      datetime                                   comment '更新時間',
  remark           varchar(500)    default null               comment '備考',
  primary key (dict_id),
  unique (dict_type)
) engine=innodb auto_increment=100 comment = '辞書タイプテーブル';

insert into sys_dict_type values(1,  'ユーザー性別', 'sys_user_sex',        '0', 'admin', sysdate(), '', null, 'ユーザー性別リスト');
insert into sys_dict_type values(2,  'メニューステータス', 'sys_show_hide',       '0', 'admin', sysdate(), '', null, 'メニューステータスリスト');
insert into sys_dict_type values(3,  'システムスイッチ', 'sys_normal_disable',  '0', 'admin', sysdate(), '', null, 'システムスイッチリスト');
insert into sys_dict_type values(4,  'タスクステータス', 'sys_job_status',      '0', 'admin', sysdate(), '', null, 'タスクステータスリスト');
insert into sys_dict_type values(5,  'タスクのグループ', 'sys_job_group',       '0', 'admin', sysdate(), '', null, 'タスクのグループリスト');
insert into sys_dict_type values(6,  'システムは', 'sys_yes_no',          '0', 'admin', sysdate(), '', null, '「システムは？」リスト');
insert into sys_dict_type values(7,  '通知するタイプ', 'sys_notice_type',     '0', 'admin', sysdate(), '', null, '通知するタイプリスト');
insert into sys_dict_type values(8,  '通知するステータス', 'sys_notice_status',   '0', 'admin', sysdate(), '', null, '通知するステータスリスト');
insert into sys_dict_type values(9,  '操作タイプ', 'sys_oper_type',       '0', 'admin', sysdate(), '', null, '操作タイプリスト');
insert into sys_dict_type values(10, 'システムステータス', 'sys_common_status',   '0', 'admin', sysdate(), '', null, 'システムステータスリスト');


-- ----------------------------
-- 12、辞書データテーブル
-- ----------------------------
drop table if exists sys_dict_data;
create table sys_dict_data
(
  dict_code        bigint(20)      not null auto_increment    comment '辞書コード',
  dict_sort        int(4)          default 0                  comment '辞書ソート',
  dict_label       varchar(100)    default ''                 comment '辞書タグ',
  dict_value       varchar(100)    default ''                 comment '辞書のキー値',
  dict_type        varchar(100)    default ''                 comment '辞書タイプ',
  css_class        varchar(100)    default null               comment 'スタイル属性（その他のスタイル拡張）',
  list_class       varchar(100)    default null               comment 'テーブル表示スタイル',
  is_default       char(1)         default 'N'                comment 'デフォルトか否か（Y はい N いいえ）',
  status           char(1)         default '0'                comment 'ステータス (0 正常 1 非アクティブ)',
  create_by        varchar(64)     default ''                 comment '作成者',
  create_time      datetime                                   comment '作成時間',
  update_by        varchar(64)     default ''                 comment 'アップデーター',
  update_time      datetime                                   comment '更新時間',
  remark           varchar(500)    default null               comment '備考',
  primary key (dict_code)
) engine=innodb auto_increment=100 comment = '辞書データテーブル';

insert into sys_dict_data values(1,  1,  '男',       '0',       'sys_user_sex',        '',   '',        'Y', '0', 'admin', sysdate(), '', null, '性別男');
insert into sys_dict_data values(2,  2,  '女性',       '1',       'sys_user_sex',        '',   '',        'N', '0', 'admin', sysdate(), '', null, '性別女性');
insert into sys_dict_data values(3,  3,  '知らない',     '2',       'sys_user_sex',        '',   '',        'N', '0', 'admin', sysdate(), '', null, '性別知らない');
insert into sys_dict_data values(4,  1,  '見せる',     '0',       'sys_show_hide',       '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '見せるメニュー');
insert into sys_dict_data values(5,  2,  '隠れる',     '1',       'sys_show_hide',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '隠れるメニュー');
insert into sys_dict_data values(6,  1,  '正常',     '0',       'sys_normal_disable',  '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '普通ステータス');
insert into sys_dict_data values(7,  2,  '停止',     '1',       'sys_normal_disable',  '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '停止ステータス');
insert into sys_dict_data values(8,  1,  '正常',     '0',       'sys_job_status',      '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '普通ステータス');
insert into sys_dict_data values(9,  2,  'ポーズ',     '1',       'sys_job_status',      '',   'danger',  'N', '0', 'admin', sysdate(), '', null, 'ポーズステータス');
insert into sys_dict_data values(10, 1,  'デフォルト',     'DEFAULT', 'sys_job_group',       '',   '',        'Y', '0', 'admin', sysdate(), '', null, 'デフォルト分组');
insert into sys_dict_data values(11, 2,  'システム',     'SYSTEM',  'sys_job_group',       '',   '',        'N', '0', 'admin', sysdate(), '', null, 'システム分组');
insert into sys_dict_data values(12, 1,  'はい',       'Y',       'sys_yes_no',          '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, 'システムデフォルトはい');
insert into sys_dict_data values(13, 2,  'いいえ',       'N',       'sys_yes_no',          '',   'danger',  'N', '0', 'admin', sysdate(), '', null, 'システムデフォルトいいえ');
insert into sys_dict_data values(14, 1,  '通知',     '1',       'sys_notice_type',     '',   'warning', 'Y', '0', 'admin', sysdate(), '', null, '通知');
insert into sys_dict_data values(15, 2,  '発表',     '2',       'sys_notice_type',     '',   'success', 'N', '0', 'admin', sysdate(), '', null, '発表');
insert into sys_dict_data values(16, 1,  '正常',     '0',       'sys_notice_status',   '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常ステータス');
insert into sys_dict_data values(17, 2,  '閉鎖',     '1',       'sys_notice_status',   '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '閉鎖ステータス');
insert into sys_dict_data values(18, 99, '他の',     '0',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '他の操作');
insert into sys_dict_data values(19, 1,  '増加',     '1',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '増加操作');
insert into sys_dict_data values(20, 2,  '改訂',     '2',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '改訂操作');
insert into sys_dict_data values(21, 3,  '消去',     '3',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '消去操作');
insert into sys_dict_data values(22, 4,  'オーソライズ',     '4',       'sys_oper_type',       '',   'primary', 'N', '0', 'admin', sysdate(), '', null, 'オーソライズ操作');
insert into sys_dict_data values(23, 5,  'エクスポート',     '5',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, 'エクスポート操作');
insert into sys_dict_data values(24, 6,  'インポート',     '6',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, 'インポート操作');
insert into sys_dict_data values(25, 7,  'キックアウト',     '7',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, 'キックアウト操作');
insert into sys_dict_data values(26, 8,  'コードを生成します', '8',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, '生成操作');
insert into sys_dict_data values(27, 9,  'データクリア', '9',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '清空操作');
insert into sys_dict_data values(28, 1,  '成功',     '0',       'sys_common_status',   '',   'primary', 'N', '0', 'admin', sysdate(), '', null, '普通ステータス');
insert into sys_dict_data values(29, 2,  '失敗',     '1',       'sys_common_status',   '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '失敗ステータス');


-- ----------------------------
-- 13.パラメーター構成テーブル
-- ----------------------------
drop table if exists sys_config;
create table sys_config (
  config_id         int(5)          not null auto_increment    comment 'パラメータ主キー',
  config_name       varchar(100)    default ''                 comment 'パラメータ名',
  config_key        varchar(100)    default ''                 comment 'パラメータ・キー名',
  config_value      varchar(500)    default ''                 comment 'パラメータ値',
  config_type       char(1)         default 'N'                comment 'システム内蔵（Yはい Nいいえ）',
  create_by         varchar(64)     default ''                 comment '作成者',
  create_time       datetime                                   comment '作成時間',
  update_by         varchar(64)     default ''                 comment 'アップデーター',
  update_time       datetime                                   comment '更新時間',
  remark            varchar(500)    default null               comment '備考',
  primary key (config_id)
) engine=innodb auto_increment=100 comment = 'パラメーター構成テーブル';

insert into sys_config values(1, 'メインページ-デフォルト・スキン・スタイル名',     'sys.index.skinName',            'skin-blue',     'Y', 'admin', sysdate(), '', null, '青 skin-blue、緑 skin-green、紫 skin-purple、赤 skin-red、黄 skin-yellow' );
insert into sys_config values(2, 'ユーザー管理-初期パスワード',         'sys.user.initPassword',         '123456',        'Y', 'admin', sysdate(), '', null, '初期化パスワード 123456' );
insert into sys_config values(3, 'メインページ-サイドバーテーマ',           'sys.index.sideTheme',           'theme-dark',    'Y', 'admin', sysdate(), '', null, 'theme-dark，theme-light' );
insert into sys_config values(4, 'アカウント・セルフサービス-CAPTCHAスイッチ',           'sys.account.captchaEnabled',    'true',          'Y', 'admin', sysdate(), '', null, 'CAPTCHA機能を有効にするかどうか（trueオン、falseオフ）');
insert into sys_config values(5, 'アカウント・セルフサービス-ユーザー登録を有効にするかどうか', 'sys.account.registerUser',      'false',         'Y', 'admin', sysdate(), '', null, '登録ユーザー機能を有効にするかどうか（有効にする場合はtrue、無効にする場合はfalse）');
insert into sys_config values(6, 'ユーザーログイン-ブラックリスト',           'sys.login.blackIPList',         '',              'Y', 'admin', sysdate(), '', null, 'ログインIPブラックリスト制限の設定，複数のマッチを"; "で区切ってマッチングをサポート（*ワイルドカード、ネットワークセグメント）');


-- ----------------------------
-- 14、システムアクセスログ
-- ----------------------------
drop table if exists sys_logininfor;
create table sys_logininfor (
  info_id        bigint(20)     not null auto_increment   comment 'アクセスID',
  user_name      varchar(50)    default ''                comment 'ユーザー',
  ipaddr         varchar(128)   default ''                comment 'ログインIP',
  login_location varchar(255)   default ''                comment 'ログイン場所',
  browser        varchar(50)    default ''                comment 'ブラウザの種類',
  os             varchar(50)    default ''                comment 'OS',
  status         char(1)        default '0'               comment 'ログイン状況（0成功 1失敗）',
  msg            varchar(255)   default ''                comment 'アラートメッセージ',
  login_time     datetime                                 comment 'アクセス時間',
  primary key (info_id),
  key idx_sys_logininfor_s  (status),
  key idx_sys_logininfor_lt (login_time)
) engine=innodb auto_increment=100 comment = 'システムアクセスログ';


-- ----------------------------
-- 15、タイミングタスクスケジューラ
-- ----------------------------
drop table if exists sys_job;
create table sys_job (
  job_id              bigint(20)    not null auto_increment    comment 'タスクID',
  job_name            varchar(64)   default ''                 comment 'タスク名',
  job_group           varchar(64)   default 'DEFAULT'          comment 'タスクグループ名',
  invoke_target       varchar(500)  not null                   comment 'ターゲットの文字列を呼び出す',
  cron_expression     varchar(255)  default ''                 comment 'クーロン実行式',
  misfire_policy      varchar(20)   default '3'                comment 'プラン実行エラー戦略（1 即実行 2 一度だけ実行 3 実行中止）',
  concurrent          char(1)       default '1'                comment '同時実行の可否（0は許可 1は禁止）',
  status              char(1)       default '0'                comment 'ステータス (0 通常 1 一時停止)',
  create_by           varchar(64)   default ''                 comment '作成者',
  create_time         datetime                                 comment '作成時間',
  update_by           varchar(64)   default ''                 comment 'アップデーター',
  update_time         datetime                                 comment '更新時間',
  remark              varchar(500)  default ''                 comment '備考',
  primary key (job_id, job_name, job_group)
) engine=innodb auto_increment=100 comment = '15、タイミングタスクスケジューラ';

insert into sys_job values(1, 'システムデフォルト（パラメータなし）', 'DEFAULT', 'ryTask.ryNoParams',        '0/10 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null, '');
insert into sys_job values(2, 'システムデフォルト（パラメータあり）', 'DEFAULT', 'ryTask.ryParams(\'ry\')',  '0/15 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null, '');
insert into sys_job values(3, 'システムデフォルト（複数パラメータ）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)',  '0/20 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 16、タイミング タスク スケジューリング ログ テーブル Timing task scheduling log table
-- ----------------------------
drop table if exists sys_job_log;
create table sys_job_log (
  job_log_id          bigint(20)     not null auto_increment    comment 'タスクログID',
  job_name            varchar(64)    not null                   comment 'タスク名',
  job_group           varchar(64)    not null                   comment 'タスクグループ名',
  invoke_target       varchar(500)   not null                   comment 'ターゲットの文字列を呼び出す',
  job_message         varchar(500)                              comment 'ログメッセージ',
  status              char(1)        default '0'                comment '実行ステータス (0 正常 1 失敗)',
  exception_info      varchar(2000)  default ''                 comment '例外情報',
  create_time         datetime                                  comment '作成時間',
  primary key (job_log_id)
) engine=innodb comment = 'タイミングタスクスケジューリングログテーブル';


-- ----------------------------
-- 17.通知テーブル
-- ----------------------------
drop table if exists sys_notice;
create table sys_notice (
  notice_id         int(4)          not null auto_increment    comment '通知ID',
  notice_title      varchar(50)     not null                   comment '通知タイトル',
  notice_type       char(1)         not null                   comment '通知タイプ（1通知 2会報）',
  notice_content    longblob        default null               comment '通知内容',
  status            char(1)         default '0'                comment '通知ステータス（0普通 1閉鎖）',
  create_by         varchar(64)     default ''                 comment '作成者',
  create_time       datetime                                   comment '作成時間',
  update_by         varchar(64)     default ''                 comment 'アップデーター',
  update_time       datetime                                   comment '更新時間',
  remark            varchar(255)    default null               comment '備考',
  primary key (notice_id)
) engine=innodb auto_increment=10 comment = '通知テーブル';

-- ----------------------------
-- 初期化-会報情報シートデータ
-- ----------------------------
insert into sys_notice values('1', 'Notice：2024-01-01 DXC release 1', '2', 'New version', '0', 'admin', sysdate(), '', null, '管理者');
insert into sys_notice values('2', 'Maintenance：2024-01-01 DXCシステム maintanance 2', '1', 'maintainance',   '0', 'admin', sysdate(), '', null, '管理者');


-- ----------------------------
-- 18.コード生成ビジネステーブル
-- ----------------------------
drop table if exists gen_table;
create table gen_table (
  table_id          bigint(20)      not null auto_increment    comment 'コード',
  table_name        varchar(200)    default ''                 comment 'テーブル名',
  table_comment     varchar(500)    default ''                 comment 'テーブルの説明',
  sub_table_name    varchar(64)     default null               comment '関連するサブテーブルのテーブル名',
  sub_table_fk_name varchar(64)     default null               comment 'サブテーブルに関連付けられた外部キーの名前',
  class_name        varchar(100)    default ''                 comment 'エンティティ・クラス名',
  tpl_category      varchar(200)    default 'crud'             comment '使用テンプレート（crudシングル・テーブル操作 treeツリーテーブル操作）',
  tpl_web_type      varchar(30)     default ''                 comment 'テンプレートタイプ（element-ui　 element-plus）',
  package_name      varchar(100)                               comment 'パッケージパス',
  module_name       varchar(30)                                comment 'モジュール名',
  business_name     varchar(30)                                comment '業務名',
  function_name     varchar(50)                                comment '機能名',
  function_author   varchar(50)                                comment '機能 作者',
  gen_type          char(1)         default '0'                comment 'コードを生成する方式（0zip　 1カスタマイズ・パス）',
  gen_path          varchar(200)    default '/'                comment '生成パス（デフォルトのプロジェクトパスなし）',
  options           varchar(1000)                              comment '他のオプション',
  create_by         varchar(64)     default ''                 comment '作成者',
  create_time 	    datetime                                   comment '作成時間',
  update_by         varchar(64)     default ''                 comment 'アップデーター',
  update_time       datetime                                   comment '更新時間',
  remark            varchar(500)    default null               comment '備考',
  primary key (table_id)
) engine=innodb auto_increment=1 comment = '18.コード生成ビジネステーブル';


-- ----------------------------
-- 19.コード生成ビジネス・テーブル・フィールド
-- ----------------------------
drop table if exists gen_table_column;
create table gen_table_column (
  column_id         bigint(20)      not null auto_increment    comment 'コード',
  table_id          bigint(20)                                 comment '所属テーブル番号',
  column_name       varchar(200)                               comment '列名',
  column_comment    varchar(500)                               comment '列の説明',
  column_type       varchar(100)                               comment '列タイプ',
  java_type         varchar(500)                               comment 'JAVAタイプ',
  java_field        varchar(200)                               comment 'JAVA フィールド名',
  is_pk             char(1)                                    comment '主キーか (1 はい)',
  is_increment      char(1)                                    comment '自己増殖型か（1はい）',
  is_required       char(1)                                    comment '必要かどうか（1 はい）',
  is_insert         char(1)                                    comment '挿入フィールドか（1 はい）',
  is_edit           char(1)                                    comment 'フィールドの編集の可否 (1 yes)',
  is_list           char(1)                                    comment 'リストフィールドか (1 yes)',
  is_query          char(1)                                    comment 'フィールドを照会するかどうか (1 yes)',
  query_type        varchar(200)    default 'EQ'               comment 'クエリーモード（等しい、等しくない、より大きい、より小さい、範囲）',
  html_type         varchar(200)                               comment '表示タイプ（テキストボックス、テキストフィールド、ドロップダウンボックス、チェックボックス、ラジオボックス、日付コントロール）',
  dict_type         varchar(200)    default ''                 comment '辞書タイプ',
  sort              int                                        comment 'ソート.',
  create_by         varchar(64)     default ''                 comment '創設者',
  create_time 	    datetime                                   comment '作成時間',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新時間',
  primary key (column_id)
) engine=innodb auto_increment=1 comment = 'コード生成ビジネス・テーブル・フィールド';
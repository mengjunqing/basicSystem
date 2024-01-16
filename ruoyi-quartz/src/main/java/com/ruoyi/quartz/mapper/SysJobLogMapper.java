package com.ruoyi.quartz.mapper;

import java.util.List;
import com.ruoyi.quartz.domain.SysJobLog;

/**
 * タスクログ情報をスケジュールします データレイヤー
 * 
 * @author ruoyi
 */
public interface SysJobLogMapper
{
    /**
     * 得るquartzログのスケジューリングのタスクを計画します
     * 
     * @param jobLog ログ情報をスーリングします
     * @return タスクログコレクションをスケジュールします
     */
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog);

    /**
     * すべてのスケジューリングタスクログをクエリします
     *
     * @return タスクログリストを表示します
     */
    public List<SysJobLog> selectJobLogAll();

    /**
     * タスクログをスケジュールしますIDクエリスケジューリング情報
     * 
     * @param jobLogId スウォッチタスクログID
     * @return スウォッチタスクログ对象信息
     */
    public SysJobLog selectJobLogById(Long jobLogId);

    /**
     * 新しいタスクログ
     * 
     * @param jobLog ログ情報をスーリングします
     * @return 結果
     */
    public int insertJobLog(SysJobLog jobLog);

    /**
     * 批量删除ログ情報をスーリングします
     * 
     * @param logIds データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteJobLogByIds(Long[] logIds);

    /**
     * タスクログを削除します
     * 
     * @param jobId スケジュールされたログID
     * @return 結果
     */
    public int deleteJobLogById(Long jobId);

    /**
     * タスクログをクリアします
     */
    public void cleanJobLog();
}

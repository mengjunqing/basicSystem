package com.ruoyi.quartz.service;

import java.util.List;
import com.ruoyi.quartz.domain.SysJobLog;

/**
 * タイミングタスクログ情報のスケジューリング サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysJobLogService
{
    /**
     * 得るquartzログのスケジューリングのタスクを計画します
     * 
     * @param jobLog ログ情報をスーリングします
     * @return タスクログコレクションをスケジュールします
     */
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog);

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
     */
    public void addJobLog(SysJobLog jobLog);

    /**
     * 批量删除ログ情報をスーリングします
     * 
     * @param logIds 削除する必要があるログID
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

package com.ruoyi.quartz.service;

import java.util.List;
import org.quartz.SchedulerException;
import com.ruoyi.common.exception.job.TaskException;
import com.ruoyi.quartz.domain.SysJob;

/**
 * 情報情報のスケジューリングのタイミングタスク サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysJobService
{
    /**
     * 得るquartzスケジューラの計画タスク
     * 
     * @param job 情報のスケジューリング
     * @return タスクコレクションをスケジュールします
     */
    public List<SysJob> selectJobList(SysJob job);

    /**
     * タスクをスケジュールしますID查询情報のスケジューリング
     * 
     * @param jobId スケジューリングタスクID
     * @return スケジューリングタスク对象信息
     */
    public SysJob selectJobById(Long jobId);

    /**
     * 一時停止タスク
     * 
     * @param job 情報のスケジューリング
     * @return 結果
     */
    public int pauseJob(SysJob job) throws SchedulerException;

    /**
     * タスクを復元します
     * 
     * @param job 情報のスケジューリング
     * @return 結果
     */
    public int resumeJob(SysJob job) throws SchedulerException;

    /**
     * タスクを削除した後，対応するtrigger削除も削除されます
     * 
     * @param job 情報のスケジューリング
     * @return 結果
     */
    public int deleteJob(SysJob job) throws SchedulerException;

    /**
     * 批量删除情報のスケジューリング
     * 
     * @param jobIds 削除する必要があるタスクID
     * @return 結果
     */
    public void deleteJobByIds(Long[] jobIds) throws SchedulerException;

    /**
     * タスクスケジューリングステータスの変更
     * 
     * @param job 情報のスケジューリング
     * @return 結果
     */
    public int changeStatus(SysJob job) throws SchedulerException;

    /**
     * すぐにタスクを実行します
     * 
     * @param job 情報のスケジューリング
     * @return 結果
     */
    public boolean run(SysJob job) throws SchedulerException;

    /**
     * 新しい仕事
     * 
     * @param job 情報のスケジューリング
     * @return 結果
     */
    public int insertJob(SysJob job) throws SchedulerException, TaskException;

    /**
     * タスクを更新します
     * 
     * @param job 情報のスケジューリング
     * @return 結果
     */
    public int updateJob(SysJob job) throws SchedulerException, TaskException;

    /**
     * チェックcronパフォーマンスが効果的かどうか
     * 
     * @param cronExpression パフォーマンス
     * @return 結果
     */
    public boolean checkCronExpressionIsValid(String cronExpression);
}

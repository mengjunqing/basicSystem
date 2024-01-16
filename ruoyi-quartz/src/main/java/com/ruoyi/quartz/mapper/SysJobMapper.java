package com.ruoyi.quartz.mapper;

import java.util.List;
import com.ruoyi.quartz.domain.SysJob;

/**
 * タスク情報をスケジュールします データレイヤー
 * 
 * @author ruoyi
 */
public interface SysJobMapper
{
    /**
     * クエリスケジューリングタスクログコレクション
     * 
     * @param job 情報のスケジューリング
     * @return ジャッキログ
     */
    public List<SysJob> selectJobList(SysJob job);

    /**
     * すべてのスケジューリングタスクをクエリします
     * 
     * @return タスクリストをスケジュールします
     */
    public List<SysJob> selectJobAll();

    /**
     * スケジュールID查询タスク情報をスケジュールします
     * 
     * @param jobId スケジュールID
     * @return 文字情報
     */
    public SysJob selectJobById(Long jobId);

    /**
     * スケジュールID删除タスク情報をスケジュールします
     * 
     * @param jobId スケジュールID
     * @return 結果
     */
    public int deleteJobById(Long jobId);

    /**
     * 批量删除タスク情報をスケジュールします
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteJobByIds(Long[] ids);

    /**
     * 修改タスク情報をスケジュールします
     * 
     * @param job タスク情報をスケジュールします
     * @return 結果
     */
    public int updateJob(SysJob job);

    /**
     * 新增タスク情報をスケジュールします
     * 
     * @param job タスク情報をスケジュールします
     * @return 結果
     */
    public int insertJob(SysJob job);
}

package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysOperLog;

/**
 * 動作しますログ サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysOperLogService
{
    /**
     * 新增動作しますログ
     * 
     * @param operLog 動作しますログ对象
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统動作しますログ集合
     * 
     * @param operLog 動作しますログ对象
     * @return 動作しますログ集合
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * 批量删除系统動作しますログ
     * 
     * @param operIds 需要删除的動作しますログID
     * @return 結果
     */
    public int deleteOperLogByIds(Long[] operIds);

    /**
     * 查询動作しますログ详细
     * 
     * @param operId 動作しますID
     * @return 動作しますログ对象
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * 清空動作しますログ
     */
    public void cleanOperLog();
}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysConfig;

/**
 * パラメーター構成 データレイヤー
 * 
 * @author ruoyi
 */
public interface SysConfigMapper
{
    /**
     * 查询パラメーター構成信息
     * 
     * @param config パラメーター構成信息
     * @return パラメーター構成信息
     */
    public SysConfig selectConfig(SysConfig config);

    /**
     * 合格IDクエリ構成
     * 
     * @param configId パラメーターID
     * @return パラメーター構成信息
     */
    public SysConfig selectConfigById(Long configId);

    /**
     * 查询パラメーター構成列表
     * 
     * @param config パラメーター構成信息
     * @return パラメーター構成集合
     */
    public List<SysConfig> selectConfigList(SysConfig config);

    /**
     * 根据键名查询パラメーター構成信息
     * 
     * @param configKey パラメーター键名
     * @return パラメーター構成信息
     */
    public SysConfig checkConfigKeyUnique(String configKey);

    /**
     * 新增パラメーター構成
     * 
     * @param config パラメーター構成信息
     * @return 結果
     */
    public int insertConfig(SysConfig config);

    /**
     * 修改パラメーター構成
     * 
     * @param config パラメーター構成信息
     * @return 結果
     */
    public int updateConfig(SysConfig config);

    /**
     * 删除パラメーター構成
     * 
     * @param configId パラメーターID
     * @return 結果
     */
    public int deleteConfigById(Long configId);

    /**
     * 批量删除パラメーター信息
     * 
     * @param configIds 需要删除的パラメーターID
     * @return 結果
     */
    public int deleteConfigByIds(Long[] configIds);
}

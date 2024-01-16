package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysConfig;

/**
 * パラメーター構成 サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysConfigService
{
    /**
     * 查询パラメーター構成信息
     * 
     * @param configId パラメーター構成ID
     * @return パラメーター構成信息
     */
    public SysConfig selectConfigById(Long configId);

    /**
     * 根据键名查询パラメーター構成信息
     * 
     * @param configKey パラメーターキー名
     * @return パラメーターキー値
     */
    public String selectConfigByKey(String configKey);

    /**
     * 検証コードスイッチを取得します
     * 
     * @return true開ける，false閉鎖
     */
    public boolean selectCaptchaEnabled();

    /**
     * 查询パラメーター構成列表
     * 
     * @param config パラメーター構成信息
     * @return パラメーター構成集合
     */
    public List<SysConfig> selectConfigList(SysConfig config);

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
     * バッチ削除パラメーター情報
     * 
     * @param configIds パラメーターを削除する必要がありますID
     */
    public void deleteConfigByIds(Long[] configIds);

    /**
     * パラメーターキャッシュデータをロードします
     */
    public void loadingConfigCache();

    /**
     * パラメーターキャッシュデータをクリアします
     */
    public void clearConfigCache();

    /**
     * パラメーターキャッシュデータをリセットします
     */
    public void resetConfigCache();

    /**
     * 校验パラメーターキー名是否唯一
     * 
     * @param config パラメーター情報
     * @return 結果
     */
    public boolean checkConfigKeyUnique(SysConfig config);
}

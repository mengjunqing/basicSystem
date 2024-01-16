package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysLogininfor;

/**
 * システムアクセスログの状況情報 サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysLogininforService
{
    /**
     * 新しいシステムログインログ
     * 
     * @param logininfor ログオブジェクトにアクセスします
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * クエリシステムログインログコレクション
     * 
     * @param logininfor ログオブジェクトにアクセスします
     * @return ログインレコードコレクション
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * バッチ削除システムログインログ
     * 
     * @param infoIds 削除する必要があるログインログID
     * @return 結果
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * クリアシステムログインログ
     */
    public void cleanLogininfor();
}

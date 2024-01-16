package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysLogininfor;

/**
 * システムアクセスログの状況情報 データレイヤー
 * 
 * @author ruoyi
 */
public interface SysLogininforMapper
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
     * 
     * @return 結果
     */
    public int cleanLogininfor();
}

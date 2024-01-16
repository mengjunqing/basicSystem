package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysNotice;

/**
 * 通知アナウンスフォーム データレイヤー
 * 
 * @author ruoyi
 */
public interface SysNoticeMapper
{
    /**
     * クエリアナウンス情報
     * 
     * @param noticeId 発表ID
     * @return 発表信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * クエリテーブルリスト
     * 
     * @param notice 発表信息
     * @return 発表集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 新增発表
     * 
     * @param notice 発表信息
     * @return 結果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改発表
     * 
     * @param notice 発表信息
     * @return 結果
     */
    public int updateNotice(SysNotice notice);

    /**
     * バッチ削除除除除除
     * 
     * @param noticeId 発表ID
     * @return 結果
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * バッチ削除除除除除信息
     * 
     * @param noticeIds 削除する必要があるテーブルID
     * @return 結果
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}

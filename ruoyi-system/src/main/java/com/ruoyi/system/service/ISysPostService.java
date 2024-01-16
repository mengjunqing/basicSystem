package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPost;

/**
 * 情報を投稿します サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysPostService
{
    /**
     * 查询情報を投稿します集合
     * 
     * @param post 情報を投稿します
     * @return 位置リスト
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * すべての位置を確認してください
     * 
     * @return 位置リスト
     */
    public List<SysPost> selectPostAll();

    /**
     * 合格ID查询情報を投稿します
     * 
     * @param postId 役職ID
     * @return 文字情報
     */
    public SysPost selectPostById(Long postId);

    /**
     * ユーザーによるとID获取役職选择框リスト
     * 
     * @param userId ユーザーID
     * @return 选中役職IDリスト
     */
    public List<Long> selectPostListByUserId(Long userId);

    /**
     * 校验役職名称
     * 
     * @param post 情報を投稿します
     * @return 結果
     */
    public boolean checkPostNameUnique(SysPost post);

    /**
     * コードを確認してください
     * 
     * @param post 情報を投稿します
     * @return 結果
     */
    public boolean checkPostCodeUnique(SysPost post);

    /**
     * 合格IDサービス数量のクエリ
     * 
     * @param postId 役職ID
     * @return 結果
     */
    public int countUserPostById(Long postId);

    /**
     * 删除情報を投稿します
     * 
     * @param postId 役職ID
     * @return 結果
     */
    public int deletePostById(Long postId);

    /**
     * 批量删除情報を投稿します
     * 
     * @param postIds 削除される義務ID
     * @return 結果
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * 新增保存情報を投稿します
     * 
     * @param post 情報を投稿します
     * @return 結果
     */
    public int insertPost(SysPost post);

    /**
     * 修改保存情報を投稿します
     * 
     * @param post 情報を投稿します
     * @return 結果
     */
    public int updatePost(SysPost post);
}

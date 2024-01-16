package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPost;

/**
 * 情報を投稿します データレイヤー
 * 
 * @author ruoyi
 */
public interface SysPostMapper
{
    /**
     * ジョブデータセットをクエリします
     * 
     * @param post 情報を投稿します
     * @return ジョブデータセット
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
     * 查询ユーザー所属役職组
     * 
     * @param userName ユーザー名
     * @return 結果
     */
    public List<SysPost> selectPostsByUserName(String userName);

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
     * 修改情報を投稿します
     * 
     * @param post 情報を投稿します
     * @return 結果
     */
    public int updatePost(SysPost post);

    /**
     * 新增情報を投稿します
     * 
     * @param post 情報を投稿します
     * @return 結果
     */
    public int insertPost(SysPost post);

    /**
     * 校验役職名称
     * 
     * @param postName 役職名称
     * @return 結果
     */
    public SysPost checkPostNameUnique(String postName);

    /**
     * コードを確認してください
     * 
     * @param postCode 実際のコーディング
     * @return 結果
     */
    public SysPost checkPostCodeUnique(String postCode);
}

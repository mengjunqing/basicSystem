package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysUserPost;

/**
 * ユーザーおよびジョブアソシエーションテーブル データレイヤー
 * 
 * @author ruoyi
 */
public interface SysUserPostMapper
{
    /**
     * ユーザーIDユーザーとジョブを削除します
     * 
     * @param userId ユーザーID
     * @return 結果
     */
    public int deleteUserPostByUserId(Long userId);

    /**
     * 合格IDジョブ数のクエリ
     * 
     * @param postId 役職ID
     * @return 結果
     */
    public int countUserPostById(Long postId);

    /**
     * 批量ユーザーとジョブを削除します
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteUserPost(Long[] ids);

    /**
     * 批量新增ユーザー役職信息
     * 
     * @param userPostList ユーザー役職列表
     * @return 結果
     */
    public int batchUserPost(List<SysUserPost> userPostList);
}

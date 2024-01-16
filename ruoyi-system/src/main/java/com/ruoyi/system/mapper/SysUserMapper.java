package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * ユーザーテーブル データレイヤー
 * 
 * @author ruoyi
 */
public interface SysUserMapper
{
    /**
     * 条件の条件に応じてユーザーリストをクエリします
     * 
     * @param sysUser ユーザー情報
     * @return ユーザー情報集合信息
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * ユーザーのコーナーリストが装備されていることを条件ページングクエリに従ってお問い合わせください
     * 
     * @param user ユーザー情報
     * @return ユーザー情報集合信息
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * 条件ページングクエリUnpliordユーザーコーナーリストに従って問い合わせる
     * 
     * @param user ユーザー情報
     * @return ユーザー情報集合信息
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * ユーザー名を介してユーザーを確認します
     * 
     * @param userName ユーザー名
     * @return ユーザーオブジェクト情報
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * ユーザーIDクエリユーザー
     * 
     * @param userId ユーザーID
     * @return ユーザーオブジェクト情報
     */
    public SysUser selectUserById(Long userId);

    /**
     * 新增ユーザー情報
     * 
     * @param user ユーザー情報
     * @return 結果
     */
    public int insertUser(SysUser user);

    /**
     * 修改ユーザー情報
     * 
     * @param user ユーザー情報
     * @return 結果
     */
    public int updateUser(SysUser user);

    /**
     * 修改ユーザー头像
     * 
     * @param userName ユーザー名
     * @param avatar アバターアドレス
     * @return 結果
     */
    public int updateUserAvatar(@Param("userName") String userName, @Param("avatar") String avatar);

    /**
     * 重置ユーザーパスワード
     * 
     * @param userName ユーザー名
     * @param password パスワード
     * @return 結果
     */
    public int resetUserPwd(@Param("userName") String userName, @Param("password") String password);

    /**
     * ユーザーID删除ユーザー
     * 
     * @param userId ユーザーID
     * @return 結果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除ユーザー情報
     * 
     * @param userIds 需要删除的ユーザーID
     * @return 結果
     */
    public int deleteUserByIds(Long[] userIds);

    /**
     * チェックユーザー名称かどうか
     * 
     * @param userName ユーザー名称
     * @return 結果
     */
    public SysUser checkUserNameUnique(String userName);

    /**
     * 携帯電話番号が一意かどうかを確認してください
     *
     * @param phonenumber 電話番号
     * @return 結果
     */
    public SysUser checkPhoneUnique(String phonenumber);

    /**
     * チェックemailかどうか
     *
     * @param email ユーザー邮箱
     * @return 結果
     */
    public SysUser checkEmailUnique(String email);
}

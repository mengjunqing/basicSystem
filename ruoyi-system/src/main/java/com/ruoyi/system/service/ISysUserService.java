package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * ユーザー ビジネス層
 * 
 * @author ruoyi
 */
public interface ISysUserService
{
    /**
     * 根据条件分页查询ユーザー列表
     * 
     * @param user ユーザー信息
     * @return ユーザー信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 根据条件分页查询已分配ユーザー角色列表
     * 
     * @param user ユーザー信息
     * @return ユーザー信息集合信息
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * 根据条件分页查询未分配ユーザー角色列表
     * 
     * @param user ユーザー信息
     * @return ユーザー信息集合信息
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * 通过ユーザー名查询ユーザー
     * 
     * @param userName ユーザー名
     * @return ユーザー对象信息
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * 通过ユーザーID查询ユーザー
     * 
     * @param userId ユーザーID
     * @return ユーザー对象信息
     */
    public SysUser selectUserById(Long userId);

    /**
     * 根据ユーザーID查询ユーザー所属ロールグループ
     * 
     * @param userName ユーザー名
     * @return 結果
     */
    public String selectUserRoleGroup(String userName);

    /**
     * 根据ユーザーID查询ユーザー所属岗位组
     * 
     * @param userName ユーザー名
     * @return 結果
     */
    public String selectUserPostGroup(String userName);

    /**
     * チェックユーザー名称かどうか
     * 
     * @param user ユーザー信息
     * @return 結果
     */
    public boolean checkUserNameUnique(SysUser user);

    /**
     * 携帯電話番号が一意かどうかを確認してください
     *
     * @param user ユーザー信息
     * @return 結果
     */
    public boolean checkPhoneUnique(SysUser user);

    /**
     * チェックemailかどうか
     *
     * @param user ユーザー信息
     * @return 結果
     */
    public boolean checkEmailUnique(SysUser user);

    /**
     * チェックユーザー是否允许操作
     * 
     * @param user ユーザー信息
     */
    public void checkUserAllowed(SysUser user);

    /**
     * チェックユーザー是否有数据权限
     * 
     * @param userId ユーザーid
     */
    public void checkUserDataScope(Long userId);

    /**
     * 新增ユーザー信息
     * 
     * @param user ユーザー信息
     * @return 結果
     */
    public int insertUser(SysUser user);

    /**
     * 注册ユーザー信息
     * 
     * @param user ユーザー信息
     * @return 結果
     */
    public boolean registerUser(SysUser user);

    /**
     * 修改ユーザー信息
     * 
     * @param user ユーザー信息
     * @return 結果
     */
    public int updateUser(SysUser user);

    /**
     * ユーザー授权角色
     * 
     * @param userId ユーザーID
     * @param roleIds ロールグループ
     */
    public void insertUserAuth(Long userId, Long[] roleIds);

    /**
     * 修改ユーザー状态
     * 
     * @param user ユーザー信息
     * @return 結果
     */
    public int updateUserStatus(SysUser user);

    /**
     * 修改ユーザー基本信息
     * 
     * @param user ユーザー信息
     * @return 結果
     */
    public int updateUserProfile(SysUser user);

    /**
     * 修改ユーザー头像
     * 
     * @param userName ユーザー名
     * @param avatar アバターアドレス
     * @return 結果
     */
    public boolean updateUserAvatar(String userName, String avatar);

    /**
     * 重置ユーザーパスワード
     * 
     * @param user ユーザー信息
     * @return 結果
     */
    public int resetPwd(SysUser user);

    /**
     * 重置ユーザーパスワード
     * 
     * @param userName ユーザー名
     * @param password パスワード
     * @return 結果
     */
    public int resetUserPwd(String userName, String password);

    /**
     * 通过ユーザーID删除ユーザー
     * 
     * @param userId ユーザーID
     * @return 結果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除ユーザー信息
     * 
     * @param userIds 需要删除的ユーザーID
     * @return 結果
     */
    public int deleteUserByIds(Long[] userIds);

    /**
     * 导入ユーザー数据
     * 
     * @param userList ユーザー数据列表
     * @param isUpdateSupport サポートを更新するかどうか，すでに存在する場合，更新データ
     * @param operName 操作ユーザー
     * @return 結果
     */
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName);
}

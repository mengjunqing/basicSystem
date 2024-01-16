package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.system.domain.SysRoleDept;
import com.ruoyi.system.domain.SysRoleMenu;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.mapper.SysRoleDeptMapper;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.mapper.SysRoleMenuMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import com.ruoyi.system.service.ISysRoleService;

/**
 * 役割 ビジネス層治療
 * 
 * @author ruoyi
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService
{
    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRoleDeptMapper roleDeptMapper;

    /**
     * 条件に従ってデータカットデータについて問い合わせてください
     * 
     * @param role 役割信息
     * @return エントリー切断データセット情報
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<SysRole> selectRoleList(SysRole role)
    {
        return roleMapper.selectRoleList(role);
    }

    /**
     * ユーザーによるとID問い合わせ
     * 
     * @param userId ユーザーID
     * @return 役割リスト
     */
    @Override
    public List<SysRole> selectRolesByUserId(Long userId)
    {
        List<SysRole> userRoles = roleMapper.selectRolePermissionByUserId(userId);
        List<SysRole> roles = selectRoleAll();
        for (SysRole role : roles)
        {
            for (SysRole userRole : userRoles)
            {
                if (role.getRoleId().longValue() == userRole.getRoleId().longValue())
                {
                    role.setFlag(true);
                    break;
                }
            }
        }
        return roles;
    }

    /**
     * ユーザーによるとIDQuery Authority
     * 
     * @param userId ユーザーID
     * @return 許可リスト
     */
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId)
    {
        List<SysRole> perms = roleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms)
        {
            if (StringUtils.isNotNull(perm))
            {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * すべてのアーケードをクエリします
     * 
     * @return 役割リスト
     */
    @Override
    public List<SysRole> selectRoleAll()
    {
        return SpringUtils.getAopProxy(this).selectRoleList(new SysRole());
    }

    /**
     * ユーザーによるとID获取役割选择框リスト
     * 
     * @param userId ユーザーID
     * @return 選ぶIDリスト
     */
    @Override
    public List<Long> selectRoleListByUserId(Long userId)
    {
        return roleMapper.selectRoleListByUserId(userId);
    }

    /**
     * 切り落とすID問い合わせ
     * 
     * @param roleId 役割ID
     * @return スプリングオブジェクト情報
     */
    @Override
    public SysRole selectRoleById(Long roleId)
    {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * パッセージの名前が名前を切るかどうかは一意です
     * 
     * @param role 役割信息
     * @return 結果
     */
    @Override
    public boolean checkRoleNameUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 検証ですか？
     * 
     * @param role 役割信息
     * @return 結果
     */
    @Override
    public boolean checkRoleKeyUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleKeyUnique(role.getRoleKey());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * テストの操作が許可されているかどうか
     * 
     * @param role 役割信息
     */
    @Override
    public void checkRoleAllowed(SysRole role)
    {
        if (StringUtils.isNotNull(role.getRoleId()) && role.isAdmin())
        {
            throw new ServiceException("スーパー管理者の操作を許可しないでください");
        }
    }

    /**
     * 校验役割是否有データ許可
     * 
     * @param roleId 役割id
     */
    @Override
    public void checkRoleDataScope(Long roleId)
    {
        if (!SysUser.isAdmin(SecurityUtils.getUserId()))
        {
            SysRole role = new SysRole();
            role.setRoleId(roleId);
            List<SysRole> roles = SpringUtils.getAopProxy(this).selectRoleList(role);
            if (StringUtils.isEmpty(roles))
            {
                throw new ServiceException("権限のアクセスデータ削減データはありません！");
            }
        }
    }

    /**
     * 切り落とすID問い合わせ使用数量
     * 
     * @param roleId 役割ID
     * @return 結果
     */
    @Override
    public int countUserRoleByRoleId(Long roleId)
    {
        return userRoleMapper.countUserRoleByRoleId(roleId);
    }

    /**
     * 保存情報を追加しました
     * 
     * @param role 役割信息
     * @return 結果
     */
    @Override
    @Transactional
    public int insertRole(SysRole role)
    {
        // 新しいサービス削減情報
        roleMapper.insertRole(role);
        return insertRoleMenu(role);
    }

    /**
     * 保存カット情報を変更します
     * 
     * @param role 役割信息
     * @return 結果
     */
    @Override
    @Transactional
    public int updateRole(SysRole role)
    {
        // 情報削減情報を変更します
        roleMapper.updateRole(role);
        // メニューとの関連を削除します
        roleMenuMapper.deleteRoleMenuByRoleId(role.getRoleId());
        return insertRoleMenu(role);
    }

    /**
     * 通勤のステータスを変更します
     * 
     * @param role 役割信息
     * @return 結果
     */
    @Override
    public int updateRoleStatus(SysRole role)
    {
        return roleMapper.updateRole(role);
    }

    /**
     * データ許可情報を変更します
     * 
     * @param role 役割信息
     * @return 結果
     */
    @Override
    @Transactional
    public int authDataScope(SysRole role)
    {
        // 情報削減情報を変更します
        roleMapper.updateRole(role);
        // 部門との関連を削除します
        roleDeptMapper.deleteRoleDeptByRoleId(role.getRoleId());
        // 新しいサービスカットと部門の情報（データ許可）
        return insertRoleDept(role);
    }

    /**
     * 新しいサービスカットメニュー情報
     * 
     * @param role 役割对象
     */
    public int insertRoleMenu(SysRole role)
    {
        int rows = 1;
        // 新增ユーザー与役割管理
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (Long menuId : role.getMenuIds())
        {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0)
        {
            rows = roleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }

    /**
     * 新しいサトル切断部門情報(データ許可)
     *
     * @param role 役割对象
     */
    public int insertRoleDept(SysRole role)
    {
        int rows = 1;
        // 新しいサービスカットと部門（データ許可）管理
        List<SysRoleDept> list = new ArrayList<SysRoleDept>();
        for (Long deptId : role.getDeptIds())
        {
            SysRoleDept rd = new SysRoleDept();
            rd.setRoleId(role.getRoleId());
            rd.setDeptId(deptId);
            list.add(rd);
        }
        if (list.size() > 0)
        {
            rows = roleDeptMapper.batchRoleDept(list);
        }
        return rows;
    }

    /**
     * 切り落とすID消去
     * 
     * @param roleId 役割ID
     * @return 結果
     */
    @Override
    @Transactional
    public int deleteRoleById(Long roleId)
    {
        // メニューとの関連を削除します
        roleMenuMapper.deleteRoleMenuByRoleId(roleId);
        // 部門との関連を削除します
        roleDeptMapper.deleteRoleDeptByRoleId(roleId);
        return roleMapper.deleteRoleById(roleId);
    }

    /**
     * バッチで情報を削除します
     * 
     * @param roleIds 削除用の切断ID
     * @return 結果
     */
    @Override
    @Transactional
    public int deleteRoleByIds(Long[] roleIds)
    {
        for (Long roleId : roleIds)
        {
            checkRoleAllowed(new SysRole(roleId));
            checkRoleDataScope(roleId);
            SysRole role = selectRoleById(roleId);
            if (countUserRoleByRoleId(roleId) > 0)
            {
                throw new ServiceException(String.format("%1$s割り当て,削除できません", role.getRoleName()));
            }
        }
        // メニューとの関連を削除します
        roleMenuMapper.deleteRoleMenu(roleIds);
        // 部門との関連を削除します
        roleDeptMapper.deleteRoleDept(roleIds);
        return roleMapper.deleteRoleByIds(roleIds);
    }

    /**
     * 取消授权ユーザー役割
     * 
     * @param userRole ユーザー和役割关联信息
     * @return 結果
     */
    @Override
    public int deleteAuthUser(SysUserRole userRole)
    {
        return userRoleMapper.deleteUserRoleInfo(userRole);
    }

    /**
     * 批量取消授权ユーザー役割
     * 
     * @param roleId 役割ID
     * @param userIds 需要取消授权的ユーザー数据ID
     * @return 結果
     */
    @Override
    public int deleteAuthUsers(Long roleId, Long[] userIds)
    {
        return userRoleMapper.deleteUserRoleInfos(roleId, userIds);
    }

    /**
     * 批量选择授权ユーザー役割
     * 
     * @param roleId 役割ID
     * @param userIds 需要授权的ユーザー数据ID
     * @return 結果
     */
    @Override
    public int insertAuthUsers(Long roleId, Long[] userIds)
    {
        // 新增ユーザー与役割管理
        List<SysUserRole> list = new ArrayList<SysUserRole>();
        for (Long userId : userIds)
        {
            SysUserRole ur = new SysUserRole();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        return userRoleMapper.batchUserRole(list);
    }
}

package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.system.domain.SysUserRole;

/**
 * ユーザーと文字関連のテーブル データレイヤー
 * 
 * @author ruoyi
 */
public interface SysUserRoleMapper
{
    /**
     * ユーザーID删除ユーザー和役割关联
     * 
     * @param userId ユーザーID
     * @return 結果
     */
    public int deleteUserRoleByUserId(Long userId);

    /**
     * 批量删除ユーザー和役割关联
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteUserRole(Long[] ids);

    /**
     * 役割を通してID文字数を照会します
     * 
     * @param roleId 役割ID
     * @return 結果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 批量新增ユーザー役割信息
     * 
     * @param userRoleList ユーザー役割列表
     * @return 結果
     */
    public int batchUserRole(List<SysUserRole> userRoleList);

    /**
     * 删除ユーザー和役割关联信息
     * 
     * @param userRole ユーザー和役割关联信息
     * @return 結果
     */
    public int deleteUserRoleInfo(SysUserRole userRole);

    /**
     * 批量取消授权ユーザー役割
     * 
     * @param roleId 役割ID
     * @param userIds 需要删除的ユーザー数据ID
     * @return 結果
     */
    public int deleteUserRoleInfos(@Param("roleId") Long roleId, @Param("userIds") Long[] userIds);
}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChkUserPermission;

/**
 * 【関数名に記入してください】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public interface ChkUserPermissionMapper 
{
    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    public ChkUserPermission selectChkUserPermissionById(Long id);

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkUserPermission 【関数名に記入してください】
     * @return 【関数名に記入してください】集合
     */
    public List<ChkUserPermission> selectChkUserPermissionList(ChkUserPermission chkUserPermission);

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkUserPermission 【関数名に記入してください】
     * @return 结果
     */
    public int insertChkUserPermission(ChkUserPermission chkUserPermission);

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkUserPermission 【関数名に記入してください】
     * @return 结果
     */
    public int updateChkUserPermission(ChkUserPermission chkUserPermission);

    /**
     * 删除【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    public int deleteChkUserPermissionById(Long id);

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChkUserPermissionByIds(Long[] ids);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkUserPermissionMapper;
import com.ruoyi.system.domain.ChkUserPermission;
import com.ruoyi.system.service.IChkUserPermissionService;

/**
 * 【関数名に記入してください】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
@Service
public class ChkUserPermissionServiceImpl implements IChkUserPermissionService 
{
    @Autowired
    private ChkUserPermissionMapper chkUserPermissionMapper;

    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    @Override
    public ChkUserPermission selectChkUserPermissionById(Long id)
    {
        return chkUserPermissionMapper.selectChkUserPermissionById(id);
    }

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkUserPermission 【関数名に記入してください】
     * @return 【関数名に記入してください】
     */
    @Override
    public List<ChkUserPermission> selectChkUserPermissionList(ChkUserPermission chkUserPermission)
    {
        return chkUserPermissionMapper.selectChkUserPermissionList(chkUserPermission);
    }

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkUserPermission 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int insertChkUserPermission(ChkUserPermission chkUserPermission)
    {
        return chkUserPermissionMapper.insertChkUserPermission(chkUserPermission);
    }

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkUserPermission 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int updateChkUserPermission(ChkUserPermission chkUserPermission)
    {
        return chkUserPermissionMapper.updateChkUserPermission(chkUserPermission);
    }

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkUserPermissionByIds(Long[] ids)
    {
        return chkUserPermissionMapper.deleteChkUserPermissionByIds(ids);
    }

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkUserPermissionById(Long id)
    {
        return chkUserPermissionMapper.deleteChkUserPermissionById(id);
    }
}

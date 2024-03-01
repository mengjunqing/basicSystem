package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkUserMapper;
import com.ruoyi.system.domain.ChkUser;
import com.ruoyi.system.service.IChkUserService;

/**
 * 【関数名に記入してください】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
@Service
public class ChkUserServiceImpl implements IChkUserService 
{
    @Autowired
    private ChkUserMapper chkUserMapper;

    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    @Override
    public ChkUser selectChkUserById(Long id)
    {
        return chkUserMapper.selectChkUserById(id);
    }

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkUser 【関数名に記入してください】
     * @return 【関数名に記入してください】
     */
    @Override
    public List<ChkUser> selectChkUserList(ChkUser chkUser)
    {
        return chkUserMapper.selectChkUserList(chkUser);
    }

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkUser 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int insertChkUser(ChkUser chkUser)
    {
        return chkUserMapper.insertChkUser(chkUser);
    }

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkUser 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int updateChkUser(ChkUser chkUser)
    {
        return chkUserMapper.updateChkUser(chkUser);
    }

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkUserByIds(Long[] ids)
    {
        return chkUserMapper.deleteChkUserByIds(ids);
    }

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkUserById(Long id)
    {
        return chkUserMapper.deleteChkUserById(id);
    }
}

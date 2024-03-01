package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkServiceFileLimitMapper;
import com.ruoyi.system.domain.ChkServiceFileLimit;
import com.ruoyi.system.service.IChkServiceFileLimitService;

/**
 * 【関数名に記入してください】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
@Service
public class ChkServiceFileLimitServiceImpl implements IChkServiceFileLimitService 
{
    @Autowired
    private ChkServiceFileLimitMapper chkServiceFileLimitMapper;

    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    @Override
    public ChkServiceFileLimit selectChkServiceFileLimitById(Long id)
    {
        return chkServiceFileLimitMapper.selectChkServiceFileLimitById(id);
    }

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkServiceFileLimit 【関数名に記入してください】
     * @return 【関数名に記入してください】
     */
    @Override
    public List<ChkServiceFileLimit> selectChkServiceFileLimitList(ChkServiceFileLimit chkServiceFileLimit)
    {
        return chkServiceFileLimitMapper.selectChkServiceFileLimitList(chkServiceFileLimit);
    }

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkServiceFileLimit 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int insertChkServiceFileLimit(ChkServiceFileLimit chkServiceFileLimit)
    {
        return chkServiceFileLimitMapper.insertChkServiceFileLimit(chkServiceFileLimit);
    }

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkServiceFileLimit 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int updateChkServiceFileLimit(ChkServiceFileLimit chkServiceFileLimit)
    {
        return chkServiceFileLimitMapper.updateChkServiceFileLimit(chkServiceFileLimit);
    }

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceFileLimitByIds(Long[] ids)
    {
        return chkServiceFileLimitMapper.deleteChkServiceFileLimitByIds(ids);
    }

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceFileLimitById(Long id)
    {
        return chkServiceFileLimitMapper.deleteChkServiceFileLimitById(id);
    }
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkGovMapper;
import com.ruoyi.system.domain.ChkGov;
import com.ruoyi.system.service.IChkGovService;

/**
 * 【関数名に記入してください】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
@Service
public class ChkGovServiceImpl implements IChkGovService 
{
    @Autowired
    private ChkGovMapper chkGovMapper;

    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    @Override
    public ChkGov selectChkGovById(Long id)
    {
        return chkGovMapper.selectChkGovById(id);
    }

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkGov 【関数名に記入してください】
     * @return 【関数名に記入してください】
     */
    @Override
    public List<ChkGov> selectChkGovList(ChkGov chkGov)
    {
        return chkGovMapper.selectChkGovList(chkGov);
    }

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkGov 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int insertChkGov(ChkGov chkGov)
    {
        return chkGovMapper.insertChkGov(chkGov);
    }

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkGov 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int updateChkGov(ChkGov chkGov)
    {
        return chkGovMapper.updateChkGov(chkGov);
    }

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkGovByIds(Long[] ids)
    {
        return chkGovMapper.deleteChkGovByIds(ids);
    }

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkGovById(Long id)
    {
        return chkGovMapper.deleteChkGovById(id);
    }
}

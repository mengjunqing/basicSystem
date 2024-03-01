package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkServiceMapper;
import com.ruoyi.system.domain.ChkService;
import com.ruoyi.system.service.IChkServiceService;

/**
 * 【関数名に記入してください】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
@Service
public class ChkServiceServiceImpl implements IChkServiceService 
{
    @Autowired
    private ChkServiceMapper chkServiceMapper;

    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    @Override
    public ChkService selectChkServiceById(Long id)
    {
        return chkServiceMapper.selectChkServiceById(id);
    }

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkService 【関数名に記入してください】
     * @return 【関数名に記入してください】
     */
    @Override
    public List<ChkService> selectChkServiceList(ChkService chkService)
    {
        return chkServiceMapper.selectChkServiceList(chkService);
    }

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkService 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int insertChkService(ChkService chkService)
    {
        return chkServiceMapper.insertChkService(chkService);
    }

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkService 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int updateChkService(ChkService chkService)
    {
        return chkServiceMapper.updateChkService(chkService);
    }

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceByIds(Long[] ids)
    {
        return chkServiceMapper.deleteChkServiceByIds(ids);
    }

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceById(Long id)
    {
        return chkServiceMapper.deleteChkServiceById(id);
    }
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkApplicationMapper;
import com.ruoyi.system.domain.ChkApplication;
import com.ruoyi.system.service.IChkApplicationService;

/**
 * 【関数名に記入してください】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
@Service
public class ChkApplicationServiceImpl implements IChkApplicationService 
{
    @Autowired
    private ChkApplicationMapper chkApplicationMapper;

    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    @Override
    public ChkApplication selectChkApplicationById(String id)
    {
        return chkApplicationMapper.selectChkApplicationById(id);
    }

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkApplication 【関数名に記入してください】
     * @return 【関数名に記入してください】
     */
    @Override
    public List<ChkApplication> selectChkApplicationList(ChkApplication chkApplication)
    {
        return chkApplicationMapper.selectChkApplicationList(chkApplication);
    }

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkApplication 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int insertChkApplication(ChkApplication chkApplication)
    {
        return chkApplicationMapper.insertChkApplication(chkApplication);
    }

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkApplication 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int updateChkApplication(ChkApplication chkApplication)
    {
        return chkApplicationMapper.updateChkApplication(chkApplication);
    }

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationByIds(String[] ids)
    {
        return chkApplicationMapper.deleteChkApplicationByIds(ids);
    }

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationById(String id)
    {
        return chkApplicationMapper.deleteChkApplicationById(id);
    }
}

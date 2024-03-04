package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkApplicationMapper;
import com.ruoyi.system.domain.ChkApplication;
import com.ruoyi.system.service.IChkApplicationService;

/**
 * applicationService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkApplicationServiceImpl implements IChkApplicationService 
{
    @Autowired
    private ChkApplicationMapper chkApplicationMapper;

    /**
     * 查询application
     * 
     * @param id application主键
     * @return application
     */
    @Override
    public ChkApplication selectChkApplicationById(String id)
    {
        return chkApplicationMapper.selectChkApplicationById(id);
    }

    /**
     * 查询application列表
     * 
     * @param chkApplication application
     * @return application
     */
    @Override
    public List<ChkApplication> selectChkApplicationList(ChkApplication chkApplication)
    {
        return chkApplicationMapper.selectChkApplicationList(chkApplication);
    }

    /**
     * 新增application
     * 
     * @param chkApplication application
     * @return 结果
     */
    @Override
    public int insertChkApplication(ChkApplication chkApplication)
    {
        return chkApplicationMapper.insertChkApplication(chkApplication);
    }

    /**
     * 修改application
     * 
     * @param chkApplication application
     * @return 结果
     */
    @Override
    public int updateChkApplication(ChkApplication chkApplication)
    {
        return chkApplicationMapper.updateChkApplication(chkApplication);
    }

    /**
     * 批量删除application
     * 
     * @param ids 需要删除的application主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationByIds(String[] ids)
    {
        return chkApplicationMapper.deleteChkApplicationByIds(ids);
    }

    /**
     * 删除application信息
     * 
     * @param id application主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationById(String id)
    {
        return chkApplicationMapper.deleteChkApplicationById(id);
    }
}

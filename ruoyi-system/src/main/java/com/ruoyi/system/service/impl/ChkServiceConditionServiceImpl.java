package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkServiceConditionMapper;
import com.ruoyi.system.domain.ChkServiceCondition;
import com.ruoyi.system.service.IChkServiceConditionService;

/**
 * service_conditionService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkServiceConditionServiceImpl implements IChkServiceConditionService 
{
    @Autowired
    private ChkServiceConditionMapper chkServiceConditionMapper;

    /**
     * 查询service_condition
     * 
     * @param id service_condition主键
     * @return service_condition
     */
    @Override
    public ChkServiceCondition selectChkServiceConditionById(Long id)
    {
        return chkServiceConditionMapper.selectChkServiceConditionById(id);
    }

    /**
     * 查询service_condition列表
     * 
     * @param chkServiceCondition service_condition
     * @return service_condition
     */
    @Override
    public List<ChkServiceCondition> selectChkServiceConditionList(ChkServiceCondition chkServiceCondition)
    {
        return chkServiceConditionMapper.selectChkServiceConditionList(chkServiceCondition);
    }

    /**
     * 新增service_condition
     * 
     * @param chkServiceCondition service_condition
     * @return 结果
     */
    @Override
    public int insertChkServiceCondition(ChkServiceCondition chkServiceCondition)
    {
        return chkServiceConditionMapper.insertChkServiceCondition(chkServiceCondition);
    }

    /**
     * 修改service_condition
     * 
     * @param chkServiceCondition service_condition
     * @return 结果
     */
    @Override
    public int updateChkServiceCondition(ChkServiceCondition chkServiceCondition)
    {
        return chkServiceConditionMapper.updateChkServiceCondition(chkServiceCondition);
    }

    /**
     * 批量删除service_condition
     * 
     * @param ids 需要删除的service_condition主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceConditionByIds(Long[] ids)
    {
        return chkServiceConditionMapper.deleteChkServiceConditionByIds(ids);
    }

    /**
     * 删除service_condition信息
     * 
     * @param id service_condition主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceConditionById(Long id)
    {
        return chkServiceConditionMapper.deleteChkServiceConditionById(id);
    }
}

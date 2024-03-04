package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkApplicationConditionMapper;
import com.ruoyi.system.domain.ChkApplicationCondition;
import com.ruoyi.system.service.IChkApplicationConditionService;

/**
 * application_conditionService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkApplicationConditionServiceImpl implements IChkApplicationConditionService 
{
    @Autowired
    private ChkApplicationConditionMapper chkApplicationConditionMapper;

    /**
     * 查询application_condition
     * 
     * @param id application_condition主键
     * @return application_condition
     */
    @Override
    public ChkApplicationCondition selectChkApplicationConditionById(Long id)
    {
        return chkApplicationConditionMapper.selectChkApplicationConditionById(id);
    }

    /**
     * 查询application_condition列表
     * 
     * @param chkApplicationCondition application_condition
     * @return application_condition
     */
    @Override
    public List<ChkApplicationCondition> selectChkApplicationConditionList(ChkApplicationCondition chkApplicationCondition)
    {
        return chkApplicationConditionMapper.selectChkApplicationConditionList(chkApplicationCondition);
    }

    /**
     * 新增application_condition
     * 
     * @param chkApplicationCondition application_condition
     * @return 结果
     */
    @Override
    public int insertChkApplicationCondition(ChkApplicationCondition chkApplicationCondition)
    {
        return chkApplicationConditionMapper.insertChkApplicationCondition(chkApplicationCondition);
    }

    /**
     * 修改application_condition
     * 
     * @param chkApplicationCondition application_condition
     * @return 结果
     */
    @Override
    public int updateChkApplicationCondition(ChkApplicationCondition chkApplicationCondition)
    {
        return chkApplicationConditionMapper.updateChkApplicationCondition(chkApplicationCondition);
    }

    /**
     * 批量删除application_condition
     * 
     * @param ids 需要删除的application_condition主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationConditionByIds(Long[] ids)
    {
        return chkApplicationConditionMapper.deleteChkApplicationConditionByIds(ids);
    }

    /**
     * 删除application_condition信息
     * 
     * @param id application_condition主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationConditionById(Long id)
    {
        return chkApplicationConditionMapper.deleteChkApplicationConditionById(id);
    }
}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChkApplicationCondition;

/**
 * application_conditionMapper接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface ChkApplicationConditionMapper 
{
    /**
     * 查询application_condition
     * 
     * @param id application_condition主键
     * @return application_condition
     */
    public ChkApplicationCondition selectChkApplicationConditionById(Long id);

    /**
     * 查询application_condition列表
     * 
     * @param chkApplicationCondition application_condition
     * @return application_condition集合
     */
    public List<ChkApplicationCondition> selectChkApplicationConditionList(ChkApplicationCondition chkApplicationCondition);

    /**
     * 新增application_condition
     * 
     * @param chkApplicationCondition application_condition
     * @return 结果
     */
    public int insertChkApplicationCondition(ChkApplicationCondition chkApplicationCondition);

    /**
     * 修改application_condition
     * 
     * @param chkApplicationCondition application_condition
     * @return 结果
     */
    public int updateChkApplicationCondition(ChkApplicationCondition chkApplicationCondition);

    /**
     * 删除application_condition
     * 
     * @param id application_condition主键
     * @return 结果
     */
    public int deleteChkApplicationConditionById(Long id);

    /**
     * 批量删除application_condition
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChkApplicationConditionByIds(Long[] ids);
}

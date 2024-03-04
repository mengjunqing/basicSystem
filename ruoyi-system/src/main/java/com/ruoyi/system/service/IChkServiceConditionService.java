package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ChkServiceCondition;

/**
 * service_conditionService接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface IChkServiceConditionService 
{
    /**
     * 查询service_condition
     * 
     * @param id service_condition主键
     * @return service_condition
     */
    public ChkServiceCondition selectChkServiceConditionById(Long id);

    /**
     * 查询service_condition列表
     * 
     * @param chkServiceCondition service_condition
     * @return service_condition集合
     */
    public List<ChkServiceCondition> selectChkServiceConditionList(ChkServiceCondition chkServiceCondition);

    /**
     * 新增service_condition
     * 
     * @param chkServiceCondition service_condition
     * @return 结果
     */
    public int insertChkServiceCondition(ChkServiceCondition chkServiceCondition);

    /**
     * 修改service_condition
     * 
     * @param chkServiceCondition service_condition
     * @return 结果
     */
    public int updateChkServiceCondition(ChkServiceCondition chkServiceCondition);

    /**
     * 批量删除service_condition
     * 
     * @param ids 需要删除的service_condition主键集合
     * @return 结果
     */
    public int deleteChkServiceConditionByIds(Long[] ids);

    /**
     * 删除service_condition信息
     * 
     * @param id service_condition主键
     * @return 结果
     */
    public int deleteChkServiceConditionById(Long id);
}

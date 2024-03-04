package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChkApplication;

/**
 * applicationMapper接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface ChkApplicationMapper 
{
    /**
     * 查询application
     * 
     * @param id application主键
     * @return application
     */
    public ChkApplication selectChkApplicationById(String id);

    /**
     * 查询application列表
     * 
     * @param chkApplication application
     * @return application集合
     */
    public List<ChkApplication> selectChkApplicationList(ChkApplication chkApplication);

    /**
     * 新增application
     * 
     * @param chkApplication application
     * @return 结果
     */
    public int insertChkApplication(ChkApplication chkApplication);

    /**
     * 修改application
     * 
     * @param chkApplication application
     * @return 结果
     */
    public int updateChkApplication(ChkApplication chkApplication);

    /**
     * 删除application
     * 
     * @param id application主键
     * @return 结果
     */
    public int deleteChkApplicationById(String id);

    /**
     * 批量删除application
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChkApplicationByIds(String[] ids);
}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChkService;

/**
 * serviceMapper接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface ChkServiceMapper 
{
    /**
     * 查询service
     * 
     * @param id service主键
     * @return service
     */
    public ChkService selectChkServiceById(Long id);

    /**
     * 查询service列表
     * 
     * @param chkService service
     * @return service集合
     */
    public List<ChkService> selectChkServiceList(ChkService chkService);

    /**
     * 新增service
     * 
     * @param chkService service
     * @return 结果
     */
    public int insertChkService(ChkService chkService);

    /**
     * 修改service
     * 
     * @param chkService service
     * @return 结果
     */
    public int updateChkService(ChkService chkService);

    /**
     * 删除service
     * 
     * @param id service主键
     * @return 结果
     */
    public int deleteChkServiceById(Long id);

    /**
     * 批量删除service
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChkServiceByIds(Long[] ids);
}

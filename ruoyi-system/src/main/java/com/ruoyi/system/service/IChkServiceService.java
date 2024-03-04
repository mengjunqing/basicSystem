package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ChkService;

/**
 * serviceService接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface IChkServiceService 
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
     * 批量删除service
     * 
     * @param ids 需要删除的service主键集合
     * @return 结果
     */
    public int deleteChkServiceByIds(Long[] ids);

    /**
     * 删除service信息
     * 
     * @param id service主键
     * @return 结果
     */
    public int deleteChkServiceById(Long id);
}

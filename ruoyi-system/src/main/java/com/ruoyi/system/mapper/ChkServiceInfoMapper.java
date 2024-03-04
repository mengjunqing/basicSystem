package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChkServiceInfo;

/**
 * service_infoMapper接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface ChkServiceInfoMapper 
{
    /**
     * 查询service_info
     * 
     * @param id service_info主键
     * @return service_info
     */
    public ChkServiceInfo selectChkServiceInfoById(Long id);

    /**
     * 查询service_info列表
     * 
     * @param chkServiceInfo service_info
     * @return service_info集合
     */
    public List<ChkServiceInfo> selectChkServiceInfoList(ChkServiceInfo chkServiceInfo);

    /**
     * 新增service_info
     * 
     * @param chkServiceInfo service_info
     * @return 结果
     */
    public int insertChkServiceInfo(ChkServiceInfo chkServiceInfo);

    /**
     * 修改service_info
     * 
     * @param chkServiceInfo service_info
     * @return 结果
     */
    public int updateChkServiceInfo(ChkServiceInfo chkServiceInfo);

    /**
     * 删除service_info
     * 
     * @param id service_info主键
     * @return 结果
     */
    public int deleteChkServiceInfoById(Long id);

    /**
     * 批量删除service_info
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChkServiceInfoByIds(Long[] ids);
}

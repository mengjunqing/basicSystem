package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkServiceInfoMapper;
import com.ruoyi.system.domain.ChkServiceInfo;
import com.ruoyi.system.service.IChkServiceInfoService;

/**
 * service_infoService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkServiceInfoServiceImpl implements IChkServiceInfoService 
{
    @Autowired
    private ChkServiceInfoMapper chkServiceInfoMapper;

    /**
     * 查询service_info
     * 
     * @param id service_info主键
     * @return service_info
     */
    @Override
    public ChkServiceInfo selectChkServiceInfoById(Long id)
    {
        return chkServiceInfoMapper.selectChkServiceInfoById(id);
    }

    /**
     * 查询service_info列表
     * 
     * @param chkServiceInfo service_info
     * @return service_info
     */
    @Override
    public List<ChkServiceInfo> selectChkServiceInfoList(ChkServiceInfo chkServiceInfo)
    {
        return chkServiceInfoMapper.selectChkServiceInfoList(chkServiceInfo);
    }

    /**
     * 新增service_info
     * 
     * @param chkServiceInfo service_info
     * @return 结果
     */
    @Override
    public int insertChkServiceInfo(ChkServiceInfo chkServiceInfo)
    {
        return chkServiceInfoMapper.insertChkServiceInfo(chkServiceInfo);
    }

    /**
     * 修改service_info
     * 
     * @param chkServiceInfo service_info
     * @return 结果
     */
    @Override
    public int updateChkServiceInfo(ChkServiceInfo chkServiceInfo)
    {
        return chkServiceInfoMapper.updateChkServiceInfo(chkServiceInfo);
    }

    /**
     * 批量删除service_info
     * 
     * @param ids 需要删除的service_info主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceInfoByIds(Long[] ids)
    {
        return chkServiceInfoMapper.deleteChkServiceInfoByIds(ids);
    }

    /**
     * 删除service_info信息
     * 
     * @param id service_info主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceInfoById(Long id)
    {
        return chkServiceInfoMapper.deleteChkServiceInfoById(id);
    }
}

package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkApplicationInfoMapper;
import com.ruoyi.system.domain.ChkApplicationInfo;
import com.ruoyi.system.service.IChkApplicationInfoService;

/**
 * application_infoService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkApplicationInfoServiceImpl implements IChkApplicationInfoService 
{
    @Autowired
    private ChkApplicationInfoMapper chkApplicationInfoMapper;

    /**
     * 查询application_info
     * 
     * @param id application_info主键
     * @return application_info
     */
    @Override
    public ChkApplicationInfo selectChkApplicationInfoById(Long id)
    {
        return chkApplicationInfoMapper.selectChkApplicationInfoById(id);
    }

    /**
     * 查询application_info列表
     * 
     * @param chkApplicationInfo application_info
     * @return application_info
     */
    @Override
    public List<ChkApplicationInfo> selectChkApplicationInfoList(ChkApplicationInfo chkApplicationInfo)
    {
        return chkApplicationInfoMapper.selectChkApplicationInfoList(chkApplicationInfo);
    }

    /**
     * 新增application_info
     * 
     * @param chkApplicationInfo application_info
     * @return 结果
     */
    @Override
    public int insertChkApplicationInfo(ChkApplicationInfo chkApplicationInfo)
    {
        return chkApplicationInfoMapper.insertChkApplicationInfo(chkApplicationInfo);
    }

    /**
     * 修改application_info
     * 
     * @param chkApplicationInfo application_info
     * @return 结果
     */
    @Override
    public int updateChkApplicationInfo(ChkApplicationInfo chkApplicationInfo)
    {
        return chkApplicationInfoMapper.updateChkApplicationInfo(chkApplicationInfo);
    }

    /**
     * 批量删除application_info
     * 
     * @param ids 需要删除的application_info主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationInfoByIds(Long[] ids)
    {
        return chkApplicationInfoMapper.deleteChkApplicationInfoByIds(ids);
    }

    /**
     * 删除application_info信息
     * 
     * @param id application_info主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationInfoById(Long id)
    {
        return chkApplicationInfoMapper.deleteChkApplicationInfoById(id);
    }
}

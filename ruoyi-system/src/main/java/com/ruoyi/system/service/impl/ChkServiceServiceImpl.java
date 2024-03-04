package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkServiceMapper;
import com.ruoyi.system.domain.ChkService;
import com.ruoyi.system.service.IChkServiceService;

/**
 * serviceService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkServiceServiceImpl implements IChkServiceService 
{
    @Autowired
    private ChkServiceMapper chkServiceMapper;

    /**
     * 查询service
     * 
     * @param id service主键
     * @return service
     */
    @Override
    public ChkService selectChkServiceById(Long id)
    {
        return chkServiceMapper.selectChkServiceById(id);
    }

    /**
     * 查询service列表
     * 
     * @param chkService service
     * @return service
     */
    @Override
    public List<ChkService> selectChkServiceList(ChkService chkService)
    {
        return chkServiceMapper.selectChkServiceList(chkService);
    }

    /**
     * 新增service
     * 
     * @param chkService service
     * @return 结果
     */
    @Override
    public int insertChkService(ChkService chkService)
    {
        return chkServiceMapper.insertChkService(chkService);
    }

    /**
     * 修改service
     * 
     * @param chkService service
     * @return 结果
     */
    @Override
    public int updateChkService(ChkService chkService)
    {
        return chkServiceMapper.updateChkService(chkService);
    }

    /**
     * 批量删除service
     * 
     * @param ids 需要删除的service主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceByIds(Long[] ids)
    {
        return chkServiceMapper.deleteChkServiceByIds(ids);
    }

    /**
     * 删除service信息
     * 
     * @param id service主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceById(Long id)
    {
        return chkServiceMapper.deleteChkServiceById(id);
    }
}

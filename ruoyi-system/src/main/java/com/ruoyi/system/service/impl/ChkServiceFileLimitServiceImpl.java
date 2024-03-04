package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkServiceFileLimitMapper;
import com.ruoyi.system.domain.ChkServiceFileLimit;
import com.ruoyi.system.service.IChkServiceFileLimitService;

/**
 * service_file_limitService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkServiceFileLimitServiceImpl implements IChkServiceFileLimitService 
{
    @Autowired
    private ChkServiceFileLimitMapper chkServiceFileLimitMapper;

    /**
     * 查询service_file_limit
     * 
     * @param id service_file_limit主键
     * @return service_file_limit
     */
    @Override
    public ChkServiceFileLimit selectChkServiceFileLimitById(Long id)
    {
        return chkServiceFileLimitMapper.selectChkServiceFileLimitById(id);
    }

    /**
     * 查询service_file_limit列表
     * 
     * @param chkServiceFileLimit service_file_limit
     * @return service_file_limit
     */
    @Override
    public List<ChkServiceFileLimit> selectChkServiceFileLimitList(ChkServiceFileLimit chkServiceFileLimit)
    {
        return chkServiceFileLimitMapper.selectChkServiceFileLimitList(chkServiceFileLimit);
    }

    /**
     * 新增service_file_limit
     * 
     * @param chkServiceFileLimit service_file_limit
     * @return 结果
     */
    @Override
    public int insertChkServiceFileLimit(ChkServiceFileLimit chkServiceFileLimit)
    {
        return chkServiceFileLimitMapper.insertChkServiceFileLimit(chkServiceFileLimit);
    }

    /**
     * 修改service_file_limit
     * 
     * @param chkServiceFileLimit service_file_limit
     * @return 结果
     */
    @Override
    public int updateChkServiceFileLimit(ChkServiceFileLimit chkServiceFileLimit)
    {
        return chkServiceFileLimitMapper.updateChkServiceFileLimit(chkServiceFileLimit);
    }

    /**
     * 批量删除service_file_limit
     * 
     * @param ids 需要删除的service_file_limit主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceFileLimitByIds(Long[] ids)
    {
        return chkServiceFileLimitMapper.deleteChkServiceFileLimitByIds(ids);
    }

    /**
     * 删除service_file_limit信息
     * 
     * @param id service_file_limit主键
     * @return 结果
     */
    @Override
    public int deleteChkServiceFileLimitById(Long id)
    {
        return chkServiceFileLimitMapper.deleteChkServiceFileLimitById(id);
    }
}

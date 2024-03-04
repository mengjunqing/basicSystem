package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ChkApplicationFileMapper;
import com.ruoyi.system.domain.ChkApplicationFile;
import com.ruoyi.system.service.IChkApplicationFileService;

/**
 * application_fileService业务层处理
 * 
 * @author jc.men
 * @date 2024-03-04
 */
@Service
public class ChkApplicationFileServiceImpl implements IChkApplicationFileService 
{
    @Autowired
    private ChkApplicationFileMapper chkApplicationFileMapper;

    /**
     * 查询application_file
     * 
     * @param id application_file主键
     * @return application_file
     */
    @Override
    public ChkApplicationFile selectChkApplicationFileById(Long id)
    {
        return chkApplicationFileMapper.selectChkApplicationFileById(id);
    }

    /**
     * 查询application_file列表
     * 
     * @param chkApplicationFile application_file
     * @return application_file
     */
    @Override
    public List<ChkApplicationFile> selectChkApplicationFileList(ChkApplicationFile chkApplicationFile)
    {
        return chkApplicationFileMapper.selectChkApplicationFileList(chkApplicationFile);
    }

    /**
     * 新增application_file
     * 
     * @param chkApplicationFile application_file
     * @return 结果
     */
    @Override
    public int insertChkApplicationFile(ChkApplicationFile chkApplicationFile)
    {
        return chkApplicationFileMapper.insertChkApplicationFile(chkApplicationFile);
    }

    /**
     * 修改application_file
     * 
     * @param chkApplicationFile application_file
     * @return 结果
     */
    @Override
    public int updateChkApplicationFile(ChkApplicationFile chkApplicationFile)
    {
        return chkApplicationFileMapper.updateChkApplicationFile(chkApplicationFile);
    }

    /**
     * 批量删除application_file
     * 
     * @param ids 需要删除的application_file主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationFileByIds(Long[] ids)
    {
        return chkApplicationFileMapper.deleteChkApplicationFileByIds(ids);
    }

    /**
     * 删除application_file信息
     * 
     * @param id application_file主键
     * @return 结果
     */
    @Override
    public int deleteChkApplicationFileById(Long id)
    {
        return chkApplicationFileMapper.deleteChkApplicationFileById(id);
    }
}

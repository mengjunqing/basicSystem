package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ChkApplicationFile;

/**
 * application_fileService接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface IChkApplicationFileService 
{
    /**
     * 查询application_file
     * 
     * @param id application_file主键
     * @return application_file
     */
    public ChkApplicationFile selectChkApplicationFileById(Long id);

    /**
     * 查询application_file列表
     * 
     * @param chkApplicationFile application_file
     * @return application_file集合
     */
    public List<ChkApplicationFile> selectChkApplicationFileList(ChkApplicationFile chkApplicationFile);

    /**
     * 新增application_file
     * 
     * @param chkApplicationFile application_file
     * @return 结果
     */
    public int insertChkApplicationFile(ChkApplicationFile chkApplicationFile);

    /**
     * 修改application_file
     * 
     * @param chkApplicationFile application_file
     * @return 结果
     */
    public int updateChkApplicationFile(ChkApplicationFile chkApplicationFile);

    /**
     * 批量删除application_file
     * 
     * @param ids 需要删除的application_file主键集合
     * @return 结果
     */
    public int deleteChkApplicationFileByIds(Long[] ids);

    /**
     * 删除application_file信息
     * 
     * @param id application_file主键
     * @return 结果
     */
    public int deleteChkApplicationFileById(Long id);
}

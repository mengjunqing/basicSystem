package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ChkServiceFileLimit;

/**
 * service_file_limitMapper接口
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public interface ChkServiceFileLimitMapper 
{
    /**
     * 查询service_file_limit
     * 
     * @param id service_file_limit主键
     * @return service_file_limit
     */
    public ChkServiceFileLimit selectChkServiceFileLimitById(Long id);

    /**
     * 查询service_file_limit列表
     * 
     * @param chkServiceFileLimit service_file_limit
     * @return service_file_limit集合
     */
    public List<ChkServiceFileLimit> selectChkServiceFileLimitList(ChkServiceFileLimit chkServiceFileLimit);

    /**
     * 新增service_file_limit
     * 
     * @param chkServiceFileLimit service_file_limit
     * @return 结果
     */
    public int insertChkServiceFileLimit(ChkServiceFileLimit chkServiceFileLimit);

    /**
     * 修改service_file_limit
     * 
     * @param chkServiceFileLimit service_file_limit
     * @return 结果
     */
    public int updateChkServiceFileLimit(ChkServiceFileLimit chkServiceFileLimit);

    /**
     * 删除service_file_limit
     * 
     * @param id service_file_limit主键
     * @return 结果
     */
    public int deleteChkServiceFileLimitById(Long id);

    /**
     * 批量删除service_file_limit
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChkServiceFileLimitByIds(Long[] ids);
}

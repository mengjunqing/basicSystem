package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.File;

/**
 * 【関数名に記入してください】Service接口
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public interface IFileService 
{
    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    public File selectFileById(Long id);

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param file 【関数名に記入してください】
     * @return 【関数名に記入してください】集合
     */
    public List<File> selectFileList(File file);

    /**
     * 新增【関数名に記入してください】
     * 
     * @param file 【関数名に記入してください】
     * @return 结果
     */
    public int insertFile(File file);

    /**
     * 修改【関数名に記入してください】
     * 
     * @param file 【関数名に記入してください】
     * @return 结果
     */
    public int updateFile(File file);

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键集合
     * @return 结果
     */
    public int deleteFileByIds(Long[] ids);

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    public int deleteFileById(Long id);
}

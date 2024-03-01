package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.LogOperation;

/**
 * 【関数名に記入してください】Service接口
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public interface ILogOperationService 
{
    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    public LogOperation selectLogOperationById(Long id);

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param logOperation 【関数名に記入してください】
     * @return 【関数名に記入してください】集合
     */
    public List<LogOperation> selectLogOperationList(LogOperation logOperation);

    /**
     * 新增【関数名に記入してください】
     * 
     * @param logOperation 【関数名に記入してください】
     * @return 结果
     */
    public int insertLogOperation(LogOperation logOperation);

    /**
     * 修改【関数名に記入してください】
     * 
     * @param logOperation 【関数名に記入してください】
     * @return 结果
     */
    public int updateLogOperation(LogOperation logOperation);

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键集合
     * @return 结果
     */
    public int deleteLogOperationByIds(Long[] ids);

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    public int deleteLogOperationById(Long id);
}

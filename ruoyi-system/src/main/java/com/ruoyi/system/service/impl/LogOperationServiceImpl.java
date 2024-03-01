package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.LogOperationMapper;
import com.ruoyi.system.domain.LogOperation;
import com.ruoyi.system.service.ILogOperationService;

/**
 * 【関数名に記入してください】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
@Service
public class LogOperationServiceImpl implements ILogOperationService 
{
    @Autowired
    private LogOperationMapper logOperationMapper;

    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    @Override
    public LogOperation selectLogOperationById(Long id)
    {
        return logOperationMapper.selectLogOperationById(id);
    }

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param logOperation 【関数名に記入してください】
     * @return 【関数名に記入してください】
     */
    @Override
    public List<LogOperation> selectLogOperationList(LogOperation logOperation)
    {
        return logOperationMapper.selectLogOperationList(logOperation);
    }

    /**
     * 新增【関数名に記入してください】
     * 
     * @param logOperation 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int insertLogOperation(LogOperation logOperation)
    {
        return logOperationMapper.insertLogOperation(logOperation);
    }

    /**
     * 修改【関数名に記入してください】
     * 
     * @param logOperation 【関数名に記入してください】
     * @return 结果
     */
    @Override
    public int updateLogOperation(LogOperation logOperation)
    {
        return logOperationMapper.updateLogOperation(logOperation);
    }

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteLogOperationByIds(Long[] ids)
    {
        return logOperationMapper.deleteLogOperationByIds(ids);
    }

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    @Override
    public int deleteLogOperationById(Long id)
    {
        return logOperationMapper.deleteLogOperationById(id);
    }
}

package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ChkApplication;

/**
 * 【関数名に記入してください】Service接口
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public interface IChkApplicationService 
{
    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    public ChkApplication selectChkApplicationById(String id);

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkApplication 【関数名に記入してください】
     * @return 【関数名に記入してください】集合
     */
    public List<ChkApplication> selectChkApplicationList(ChkApplication chkApplication);

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkApplication 【関数名に記入してください】
     * @return 结果
     */
    public int insertChkApplication(ChkApplication chkApplication);

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkApplication 【関数名に記入してください】
     * @return 结果
     */
    public int updateChkApplication(ChkApplication chkApplication);

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键集合
     * @return 结果
     */
    public int deleteChkApplicationByIds(String[] ids);

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    public int deleteChkApplicationById(String id);
}

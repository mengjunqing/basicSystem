package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ChkGov;

/**
 * 【関数名に記入してください】Service接口
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public interface IChkGovService 
{
    /**
     * 查询【関数名に記入してください】
     * 
     * @param id 【関数名に記入してください】主键
     * @return 【関数名に記入してください】
     */
    public ChkGov selectChkGovById(Long id);

    /**
     * 查询【関数名に記入してください】列表
     * 
     * @param chkGov 【関数名に記入してください】
     * @return 【関数名に記入してください】集合
     */
    public List<ChkGov> selectChkGovList(ChkGov chkGov);

    /**
     * 新增【関数名に記入してください】
     * 
     * @param chkGov 【関数名に記入してください】
     * @return 结果
     */
    public int insertChkGov(ChkGov chkGov);

    /**
     * 修改【関数名に記入してください】
     * 
     * @param chkGov 【関数名に記入してください】
     * @return 结果
     */
    public int updateChkGov(ChkGov chkGov);

    /**
     * 批量删除【関数名に記入してください】
     * 
     * @param ids 需要删除的【関数名に記入してください】主键集合
     * @return 结果
     */
    public int deleteChkGovByIds(Long[] ids);

    /**
     * 删除【関数名に記入してください】信息
     * 
     * @param id 【関数名に記入してください】主键
     * @return 结果
     */
    public int deleteChkGovById(Long id);
}

package com.ruoyi.generator.service;

import java.util.List;
import com.ruoyi.generator.domain.GenTableColumn;

/**
 * ビジネス分野 サービスレイヤー
 * 
 * @author ruoyi
 */
public interface IGenTableColumnService
{
    /**
     * 查询ビジネス分野列表
     * 
     * @param tableId ビジネス分野编号
     * @return ビジネス分野集合
     */
    public List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);

    /**
     * 新增ビジネス分野
     * 
     * @param genTableColumn ビジネス分野信息
     * @return 結果
     */
    public int insertGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 修改ビジネス分野
     * 
     * @param genTableColumn ビジネス分野信息
     * @return 結果
     */
    public int updateGenTableColumn(GenTableColumn genTableColumn);

    /**
     * 删除ビジネス分野信息
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteGenTableColumnByIds(String ids);
}

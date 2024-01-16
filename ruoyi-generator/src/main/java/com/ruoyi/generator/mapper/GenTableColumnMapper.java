package com.ruoyi.generator.mapper;

import java.util.List;
import com.ruoyi.generator.domain.GenTableColumn;

/**
 * ビジネス分野 データレイヤー
 * 
 * @author ruoyi
 */
public interface GenTableColumnMapper
{
    /**
     * テーブルの名前に従って情報を紹介します
     * 
     * @param tableName テーブル名
     * @return 列情報
     */
    public List<GenTableColumn> selectDbTableColumnsByName(String tableName);

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
     * 删除ビジネス分野
     * 
     * @param genTableColumns 列データ
     * @return 結果
     */
    public int deleteGenTableColumns(List<GenTableColumn> genTableColumns);

    /**
     * 批量删除ビジネス分野
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteGenTableColumnByIds(Long[] ids);
}

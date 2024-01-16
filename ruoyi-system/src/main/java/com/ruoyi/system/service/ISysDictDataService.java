package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictData;

/**
 * 辞書 ビジネス層
 * 
 * @author ruoyi
 */
public interface ISysDictDataService
{
    /**
     * 条件ページネーションに従って辞書データをクエリします
     * 
     * @param dictData 辞書データ情報
     * @return 辞書データ収集情報
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 根据辞書和タイルキー値查询辞書データ情報
     * 
     * @param dictType 辞書
     * @param dictValue タイルキー値
     * @return タイルラベル
     */
    public String selectDictLabel(String dictType, String dictValue);

    /**
     * 辞書データによるとID検索情報
     * 
     * @param dictCode 辞書数据ID
     * @return 辞書数据
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * 批量删除辞書データ情報
     * 
     * @param dictCodes 削除する必要がある辞書データID
     */
    public void deleteDictDataByIds(Long[] dictCodes);

    /**
     * 新增保存辞書データ情報
     * 
     * @param dictData 辞書データ情報
     * @return 結果
     */
    public int insertDictData(SysDictData dictData);

    /**
     * 修改保存辞書データ情報
     * 
     * @param dictData 辞書データ情報
     * @return 結果
     */
    public int updateDictData(SysDictData dictData);
}

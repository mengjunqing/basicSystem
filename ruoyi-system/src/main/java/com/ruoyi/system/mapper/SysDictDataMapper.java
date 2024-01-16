package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysDictData;

/**
 * 辞書 データレイヤー
 * 
 * @author ruoyi
 */
public interface SysDictDataMapper
{
    /**
     * 条件のページネーションに従って辞書データを確認してください
     * 
     * @param dictData 辞書データ情報
     * @return 辞書データセット情報
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 辞書タイプに従って辞書データを確認してください
     * 
     * @param dictType 辞書
     * @return 辞書データセット情報
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 根据辞書和辞書のキー値查询辞書データ情報
     * 
     * @param dictType 辞書
     * @param dictValue 辞書のキー値
     * @return 辞書ラベル
     */
    public String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * 辞書データによるとID検索情報
     * 
     * @param dictCode 辞書データID
     * @return 辞書データ
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * 查询辞書データ
     * 
     * @param dictType 辞書
     * @return 辞書データ
     */
    public int countDictDataByType(String dictType);

    /**
     * 辞書ID删除辞書データ情報
     * 
     * @param dictCode 辞書データID
     * @return 結果
     */
    public int deleteDictDataById(Long dictCode);

    /**
     * 批量删除辞書データ情報
     * 
     * @param dictCodes 需要删除的辞書データID
     * @return 結果
     */
    public int deleteDictDataByIds(Long[] dictCodes);

    /**
     * 新增辞書データ情報
     * 
     * @param dictData 辞書データ情報
     * @return 結果
     */
    public int insertDictData(SysDictData dictData);

    /**
     * 修改辞書データ情報
     * 
     * @param dictData 辞書データ情報
     * @return 結果
     */
    public int updateDictData(SysDictData dictData);

    /**
     * 辞書を同時に変更します
     * 
     * @param oldDictType 旧辞書
     * @param newDictType 新旧辞書
     * @return 結果
     */
    public int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);
}

package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * 辞書 ビジネス層
 * 
 * @author ruoyi
 */
public interface ISysDictTypeService
{
    /**
     * 条件のページネーションに従って辞書のタイプをクエリします
     * 
     * @param dictType 辞書タイプ情報
     * @return タイプの収集情報
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * あらゆる種類の辞書によると
     * 
     * @return タイプの収集情報
     */
    public List<SysDictType> selectDictTypeAll();

    /**
     * 辞書のタイプに基づく辞書データをクエリします
     * 
     * @param dictType 辞書
     * @return 辞書データ収集情報
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 根据辞書ID検索情報
     * 
     * @param dictId 辞書ID
     * @return 辞書
     */
    public SysDictType selectDictTypeById(Long dictId);

    /**
     * 根据辞書検索情報
     * 
     * @param dictType 辞書
     * @return 辞書
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * 辞書情報のバッチ削除
     * 
     * @param dictIds 削除される辞書ID
     */
    public void deleteDictTypeByIds(Long[] dictIds);

    /**
     * 辞書キャッシュデータの読み込み
     */
    public void loadingDictCache();

    /**
     * クリア辞書のクリアデータ
     */
    public void clearDictCache();

    /**
     * 辞書キャッシュデータをリセットします
     */
    public void resetDictCache();

    /**
     * 新增保存辞書タイプ情報
     * 
     * @param dictType 辞書タイプ情報
     * @return 結果
     */
    public int insertDictType(SysDictType dictType);

    /**
     * 修改保存辞書タイプ情報
     * 
     * @param dictType 辞書タイプ情報
     * @return 結果
     */
    public int updateDictType(SysDictType dictType);

    /**
     * 校验辞書称是否唯一
     * 
     * @param dictType 辞書
     * @return 結果
     */
    public boolean checkDictTypeUnique(SysDictType dictType);
}

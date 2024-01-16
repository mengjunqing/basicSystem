package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * 辞書 データレイヤー
 * 
 * @author ruoyi
 */
public interface SysDictTypeMapper
{
    /**
     * 条件のページネーションに従って辞書タイプを確認してください
     * 
     * @param dictType 辞書タイプ情報
     * @return 辞書タイプの収集情報
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * すべての辞書タイプに応じて
     * 
     * @return 辞書タイプの収集情報
     */
    public List<SysDictType> selectDictTypeAll();

    /**
     * 辞書タイプに応じてID検索情報
     * 
     * @param dictId 辞書ID
     * @return 辞書
     */
    public SysDictType selectDictTypeById(Long dictId);

    /**
     * 辞書タイプに応じて検索情報
     * 
     * @param dictType 辞書
     * @return 辞書
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * 辞書ID辞書情報を削除します
     * 
     * @param dictId 辞書ID
     * @return 結果
     */
    public int deleteDictTypeById(Long dictId);

    /**
     * 批量删除辞書タイプ情報
     * 
     * @param dictIds 削除される辞書ID
     * @return 結果
     */
    public int deleteDictTypeByIds(Long[] dictIds);

    /**
     * 新增辞書タイプ情報
     * 
     * @param dictType 辞書タイプ情報
     * @return 結果
     */
    public int insertDictType(SysDictType dictType);

    /**
     * 修改辞書タイプ情報
     * 
     * @param dictType 辞書タイプ情報
     * @return 結果
     */
    public int updateDictType(SysDictType dictType);

    /**
     * 検証タイトルは、それがユニークかどうかを示しています
     * 
     * @param dictType 辞書
     * @return 結果
     */
    public SysDictType checkDictTypeUnique(String dictType);
}

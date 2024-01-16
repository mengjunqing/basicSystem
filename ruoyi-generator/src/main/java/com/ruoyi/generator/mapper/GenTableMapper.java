package com.ruoyi.generator.mapper;

import java.util.List;
import com.ruoyi.generator.domain.GenTable;

/**
 * 仕事 データレイヤー
 * 
 * @author ruoyi
 */
public interface GenTableMapper
{
    /**
     * クエリリスト
     * 
     * @param genTable 仕事信息
     * @return 仕事集合
     */
    public List<GenTable> selectGenTableList(GenTable genTable);

    /**
     * ライブラリリストに基づくお問い合わせ
     * 
     * @param genTable 仕事信息
     * @return データベーステーブルコレクション
     */
    public List<GenTable> selectDbTableList(GenTable genTable);

    /**
     * ライブラリリストに基づくお問い合わせ
     * 
     * @param tableNames テーブル名グループ
     * @return データベーステーブルコレクション
     */
    public List<GenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * すべてのテーブル情報をクエリします
     * 
     * @return テーブル情報コレクション
     */
    public List<GenTable> selectGenTableAll();

    /**
     * クエリテーブルID仕事信息
     * 
     * @param id 仕事ID
     * @return 仕事信息
     */
    public GenTable selectGenTableById(Long id);

    /**
     * クエリテーブル名称仕事信息
     * 
     * @param tableName テーブル名
     * @return 仕事信息
     */
    public GenTable selectGenTableByName(String tableName);

    /**
     * 新しく追加されました
     * 
     * @param genTable 仕事信息
     * @return 結果
     */
    public int insertGenTable(GenTable genTable);

    /**
     * 改訂
     * 
     * @param genTable 仕事信息
     * @return 結果
     */
    public int updateGenTable(GenTable genTable);

    /**
     * 役人のバッチ削除
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteGenTableByIds(Long[] ids);
}

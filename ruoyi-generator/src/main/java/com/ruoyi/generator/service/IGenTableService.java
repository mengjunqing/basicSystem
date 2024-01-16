package com.ruoyi.generator.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.generator.domain.GenTable;

/**
 * 仕事 サービスレイヤー
 * 
 * @author ruoyi
 */
public interface IGenTableService
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
     * お問い合わせ情報
     * 
     * @param id 仕事ID
     * @return 仕事信息
     */
    public GenTable selectGenTableById(Long id);

    /**
     * 改訂
     * 
     * @param genTable 仕事信息
     * @return 結果
     */
    public void updateGenTable(GenTable genTable);

    /**
     * 情報情報を削除します
     * 
     * @param tableIds 削除する必要があるテーブルデータID
     * @return 結果
     */
    public void deleteGenTableByIds(Long[] tableIds);

    /**
     * テーブル構造をインポートします
     * 
     * @param tableList はじめにフォーム
     */
    public void importGenTable(List<GenTable> tableList);

    /**
     * プレビューコード
     * 
     * @param tableId テーブル番号
     * @return プレビューデータリスト
     */
    public Map<String, String> previewCode(Long tableId);

    /**
     * コードを生成します（ダウンロード方法）
     * 
     * @param tableName テーブル名
     * @return データ
     */
    public byte[] downloadCode(String tableName);

    /**
     * コードを生成します（カスタムパス）
     * 
     * @param tableName テーブル名
     * @return データ
     */
    public void generatorCode(String tableName);

    /**
     * 同步データ库
     * 
     * @param tableName テーブル名
     */
    public void synchDb(String tableName);

    /**
     * 批量コードを生成します（ダウンロード方法）
     * 
     * @param tableNames テーブル・アレイ
     * @return データ
     */
    public byte[] downloadCode(String[] tableNames);

    /**
     * 保存パラメーター検証を変更します
     * 
     * @param genTable 仕事信息
     */
    public void validateEdit(GenTable genTable);
}

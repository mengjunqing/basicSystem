package com.ruoyi.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import com.ruoyi.common.utils.poi.ExcelHandlerAdapter;

/**
 * カスタムエクスポートExcelデータアノテーション
 * 
 * @author ruoyi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel
{
    /**
     * エクスポートの場合excel選別
     */
    public int sort() default Integer.MAX_VALUE;

    /**
     * 出力Excel名前.
     */
    public String name() default "";

    /**
     * 日付形式, のように: yyyy-MM-dd
     */
    public String dateFormat() default "";

    /**
     * のように果是字典类型，辞書を設定してくださいtype価値 (のように: sys_user_sex)
     */
    public String dictType() default "";

    /**
     * コンテンツ転送式を読んでください (のように: 0=男,1=女性,2=未知)
     */
    public String readConverterExp() default "";

    /**
     * 分離主義者，文字列セットの内容を読んでください
     */
    public String separator() default ",";

    /**
     * BigDecimal 正確さ デフォルト:-1(デフォルト不开启BigDecimalフォーマット)
     */
    public int scale() default -1;

    /**
     * BigDecimal ルールをあきらめます デフォルト:BigDecimal.ROUND_HALF_EVEN
     */
    public int roundingMode() default BigDecimal.ROUND_HALF_EVEN;

    /**
     * エクスポートの場合excel各列の高さ
     */
    public double height() default 14;

    /**
     * エクスポートの場合excel各列の幅
     */
    public double width() default 16;

    /**
     * テキストサフィックス,のように% 90 なる90%
     */
    public String suffix() default "";

    /**
     * あなたが空いているとき,字段的デフォルト価値
     */
    public String defaultValue() default "";

    /**
     * 迅速な情報
     */
    public String prompt() default "";

    /**
     * 設定は、入力できない列のみを選択できます.
     */
    public String[] combo() default {};

    /**
     * 垂直合併セルが必要ですか？,需要をコピーします:含むlistセルの収集)
     */
    public boolean needMerge() default false;

    /**
     * データをエクスポートするかどうか,需要をコピーします:テンプレートをエクスポートする必要がある場合があります,これはタイトルのニーズですが、コンテンツはユーザーが手作業で記入する必要があります.
     */
    public boolean isExport() default true;

    /**
     * 別のクラスの属性名,マルチレベルの取得をサポートします,小数点で分離します
     */
    public String targetAttr() default "";

    /**
     * データを自動的に統計するかどうか,最後の行の統計データの概要
     */
    public boolean isStatistics() default false;

    /**
     * エクスポートタイプ（0番号 1弦 2写真）
     */
    public ColumnType cellType() default ColumnType.STRING;

    /**
     * 列ヘッドの背景色をエクスポートします
     */
    public IndexedColors headerBackgroundColor() default IndexedColors.GREY_50_PERCENT;

    /**
     * 列ヘッドフォントの色をエクスポートします
     */
    public IndexedColors headerColor() default IndexedColors.WHITE;

    /**
     * セルの背景色をエクスポートします
     */
    public IndexedColors backgroundColor() default IndexedColors.WHITE;

    /**
     * エクスポートユニットフォントの色
     */
    public IndexedColors color() default IndexedColors.BLACK;

    /**
     * エクスポートフィールドアライメントメソッド
     */
    public HorizontalAlignment align() default HorizontalAlignment.CENTER;

    /**
     * カスタムデータプロセッサ
     */
    public Class<?> handler() default ExcelHandlerAdapter.class;

    /**
     * カスタムデータプロセッサ参数
     */
    public String[] args() default {};

    /**
     * フィールドタイプ（0：出力；1：出力；2：インポートのみ）
     */
    Type type() default Type.ALL;

    public enum Type
    {
        ALL(0), EXPORT(1), IMPORT(2);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    public enum ColumnType
    {
        NUMERIC(0), STRING(1), IMAGE(2);
        private final int value;

        ColumnType(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }
}
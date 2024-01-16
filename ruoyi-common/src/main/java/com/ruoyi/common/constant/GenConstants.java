package com.ruoyi.common.constant;

/**
 * ユニバーサル定数を生成するコード
 * 
 * @author ruoyi
 */
public class GenConstants
{
    /** シングルウォッチ（追加、削除、および変更） */
    public static final String TPL_CRUD = "crud";

    /** ツリーテーブル（追加、削除、および変更） */
    public static final String TPL_TREE = "tree";

    /** 1つのテーブル（追加、削除、および変更） */
    public static final String TPL_SUB = "sub";

    /** ツリーコーディングフィールド */
    public static final String TREE_CODE = "treeCode";

    /** ツリーファーザーコードフィールド */
    public static final String TREE_PARENT_CODE = "treeParentCode";

    /** ツリー名フィールド */
    public static final String TREE_NAME = "treeName";

    /** 優れたメニューID分野 */
    public static final String PARENT_MENU_ID = "parentMenuId";

    /** 優れたメニュー名称分野 */
    public static final String PARENT_MENU_NAME = "parentMenuName";

    /** データベース文字列タイプ */
    public static final String[] COLUMNTYPE_STR = { "char", "varchar", "nvarchar", "varchar2" };

    /** データベーステキストタイプ */
    public static final String[] COLUMNTYPE_TEXT = { "tinytext", "text", "mediumtext", "longtext" };

    /** データベースタイムタイプ */
    public static final String[] COLUMNTYPE_TIME = { "datetime", "time", "date", "timestamp" };

    /** データベースデジタルタイプ */
    public static final String[] COLUMNTYPE_NUMBER = { "tinyint", "smallint", "mediumint", "int", "number", "integer",
            "bit", "bigint", "float", "double", "decimal" };

    /** このページは、分割を編集する必要はありません */
    public static final String[] COLUMNNAME_NOT_EDIT = { "id", "create_by", "create_time", "del_flag" };

    /** ページ上の不要なディスプレイのリストはワイルドに分かれています */
    public static final String[] COLUMNNAME_NOT_LIST = { "id", "create_by", "create_time", "del_flag", "update_by",
            "update_time" };

    /** ページはディビジョンフィールドを照会する必要はありません */
    public static final String[] COLUMNNAME_NOT_QUERY = { "id", "create_by", "create_time", "del_flag", "update_by",
            "update_time", "remark" };

    /** Entity基本クラス */
    public static final String[] BASE_ENTITY = { "createBy", "createTime", "updateBy", "updateTime", "remark" };

    /** Tree基本クラス */
    public static final String[] TREE_ENTITY = { "parentName", "parentId", "orderNum", "ancestors", "children" };

    /** テキストボックス */
    public static final String HTML_INPUT = "input";

    /** テキストドメイン */
    public static final String HTML_TEXTAREA = "textarea";

    /** ドロップダウンボックス */
    public static final String HTML_SELECT = "select";

    /** シングルボックス */
    public static final String HTML_RADIO = "radio";

    /** チェックボックス */
    public static final String HTML_CHECKBOX = "checkbox";

    /** 日付制御 */
    public static final String HTML_DATETIME = "datetime";

    /** 画像アップロードコントロール */
    public static final String HTML_IMAGE_UPLOAD = "imageUpload";

    /** ファイルアップロード制御 */
    public static final String HTML_FILE_UPLOAD = "fileUpload";

    /** 豊富なテキストコントロール */
    public static final String HTML_EDITOR = "editor";

    /** 文字列タイプ */
    public static final String TYPE_STRING = "String";

    /** 積分 */
    public static final String TYPE_INTEGER = "Integer";

    /** 长積分 */
    public static final String TYPE_LONG = "Long";

    /** フローティング - ポイントタイプ */
    public static final String TYPE_DOUBLE = "Double";

    /** 高精度計算タイプ */
    public static final String TYPE_BIGDECIMAL = "BigDecimal";

    /** 時間タイプ */
    public static final String TYPE_DATE = "Date";

    /** あいまいなクエリ */
    public static final String QUERY_LIKE = "LIKE";

    /** 等しいクエリ */
    public static final String QUERY_EQ = "EQ";

    /** 必要 */
    public static final String REQUIRE = "1";
}

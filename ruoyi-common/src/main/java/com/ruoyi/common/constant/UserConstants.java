package com.ruoyi.common.constant;

/**
 * ユーザー定数情報
 * 
 * @author ruoyi
 */
public class UserConstants
{
    /**
     * プラットフォーム内のシステムユーザーの唯一の兆候
     */
    public static final String SYS_USER = "SYS_USER";

    /** 通常のステータス */
    public static final String NORMAL = "0";

    /** 異常状態 */
    public static final String EXCEPTION = "1";

    /** ユーザー禁止 */
    public static final String USER_DISABLE = "1";

    /** キャラクター禁止状態 */
    public static final String ROLE_DISABLE = "1";

    /** 部门通常のステータス */
    public static final String DEPT_NORMAL = "0";

    /** 歯科化ステータス */
    public static final String DEPT_DISABLE = "1";

    /** 字典通常のステータス */
    public static final String DICT_NORMAL = "0";

    /** システムのデフォルトであるかどうか（はい） */
    public static final String YES = "Y";

    /** はいいいえメニュー外链（はい） */
    public static final String YES_FRAME = "0";

    /** はいいいえメニュー外链（いいえ） */
    public static final String NO_FRAME = "1";

    /** メニュー（目次） */
    public static final String TYPE_DIR = "M";

    /** メニュー（メニュー） */
    public static final String TYPE_MENU = "C";

    /** メニュー（ボタン） */
    public static final String TYPE_BUTTON = "F";

    /** Layoutコンポーネントロゴ */
    public final static String LAYOUT = "Layout";
    
    /** ParentViewコンポーネントロゴ */
    public final static String PARENT_VIEW = "ParentView";

    /** InnerLinkコンポーネントロゴ */
    public final static String INNER_LINK = "InnerLink";

    /** 校验はいいいえ唯一的返回标识 */
    public final static boolean UNIQUE = true;
    public final static boolean NOT_UNIQUE = false;

    /**
     * ユーザー名の長さ制限
     */
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 20;

    /**
     * パスワードの長さ制限
     */
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 20;
}

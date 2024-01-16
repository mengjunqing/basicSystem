package com.ruoyi.common.constant;

/**
 * キャッシュkey 絶え間ない
 * 
 * @author ruoyi
 */
public class CacheConstants
{
    /**
     * ログインユーザー redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 検証コード redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * パラメーター管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 辞書管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 耳が多い提出 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 制限 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * ログインアカウントパスワードエラー番号の時間 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";
}

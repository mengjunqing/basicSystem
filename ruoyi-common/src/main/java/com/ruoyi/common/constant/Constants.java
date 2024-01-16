package com.ruoyi.common.constant;

import io.jsonwebtoken.Claims;

/**
 * 普遍的な定数情報
 * 
 * @author ruoyi
 */
public class Constants
{
    /**
     * UTF-8 キャラクターセット
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK キャラクターセット
     */
    public static final String GBK = "GBK";

    /**
     * wwwメインドメイン
     */
    public static final String WWW = "www.";

    /**
     * http聞く
     */
    public static final String HTTP = "http://";

    /**
     * https聞く
     */
    public static final String HTTPS = "https://";

    /**
     * GM成功したロゴ
     */
    public static final String SUCCESS = "0";

    /**
     * ユニバーサル失敗ロゴ
     */
    public static final String FAIL = "1";

    /**
     * ログイン成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * キャンセル
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登録する
     */
    public static final String REGISTER = "Register";

    /**
     * ログインに失敗しました
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 全て
     */
    public static final String ALL_PERMISSION = "*:*:*";

    /**
     * 管理者の役割許可ロゴ
     */
    public static final String SUPER_ADMIN = "admin";

    /**
     * 文字許可セグメンテーション
     */
    public static final String ROLE_DELIMETER = ",";

    /**
     * 権限識別子分離記号
     */
    public static final String PERMISSION_DELIMETER = ",";

    /**
     * 妥当性コードの妥当性期間（分）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * トークン
     */
    public static final String TOKEN = "token";

    /**
     * トークンプレフィックス
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * トークンプレフィックス
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * ユーザーID
     */
    public static final String JWT_USERID = "userid";

    /**
     * ユーザー名称
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * ユーザー头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 作成時間
     */
    public static final String JWT_CREATED = "created";

    /**
     * ユーザー权限
     */
    public static final String JWT_AUTHORITIES = "authorities";

    /**
     * リソースマッピングパス プレフィックス
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI リモートメソッド呼び出し
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP リモートメソッド呼び出し
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS リモートメソッド呼び出し
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * 自動識別jsonオブジェクトホワイトリスト構成（パッケージ名のみが解析を許可します，範囲が小さくなるほど、より安全です）
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.ruoyi" };

    /**
     * タイミングタスクホワイト構成（パッケージ名のみがアクセスを許可します，他のニーズがある場合は、自分で追加できます）
     */
    public static final String[] JOB_WHITELIST_STR = { "com.ruoyi" };

    /**
     * タイムタスク違法なキャラクター
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "com.ruoyi.common.utils.file", "com.ruoyi.common.config" };
}

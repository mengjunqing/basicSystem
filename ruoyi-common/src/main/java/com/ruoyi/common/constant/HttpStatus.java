package com.ruoyi.common.constant;

/**
 * ステータスコードを返します
 * 
 * @author ruoyi
 */
public class HttpStatus
{
    /**
     * 成功した操作
     */
    public static final int SUCCESS = 200;

    /**
     * オブジェクトの作成の成功
     */
    public static final int CREATED = 201;

    /**
     * リクエストは受け入れられました
     */
    public static final int ACCEPTED = 202;

    /**
     * 操作は正常に実行されました，しかし、返品データはありません
     */
    public static final int NO_CONTENT = 204;

    /**
     * リソースが削除されました
     */
    public static final int MOVED_PERM = 301;

    /**
     * リダイレクト
     */
    public static final int SEE_OTHER = 303;

    /**
     * リソースは変更されていません
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * パラメーターリストエラー（足らない，フォーマットは一致しません）
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 不正
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 制限付きアクセス，期限切れ
     */
    public static final int FORBIDDEN = 403;

    /**
     * リソース，サービスは見つかりませんでした
     */
    public static final int NOT_FOUND = 404;

    /**
     * 禁じられているhttp方法
     */
    public static final int BAD_METHOD = 405;

    /**
     * リソース冲突，或者リソース被锁
     */
    public static final int CONFLICT = 409;

    /**
     * サポートされていないデータ，メディアタイプ
     */
    public static final int UNSUPPORTED_TYPE = 415;

    /**
     * 内部システムエラー
     */
    public static final int ERROR = 500;

    /**
     * インターフェイスは実装されていません
     */
    public static final int NOT_IMPLEMENTED = 501;

    /**
     * システム警告メッセージ
     */
    public static final int WARN = 601;
}

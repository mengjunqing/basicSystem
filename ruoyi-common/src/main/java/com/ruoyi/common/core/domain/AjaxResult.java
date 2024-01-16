package com.ruoyi.common.core.domain;

import java.util.HashMap;
import java.util.Objects;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.utils.StringUtils;

/**
 * リマインダー
 * 
 * @author ruoyi
 */
public class AjaxResult extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /** ステータスコード */
    public static final String CODE_TAG = "code";

    /** コンテンツを返します */
    public static final String MSG_TAG = "msg";

    /** データオブジェクト */
    public static final String DATA_TAG = "data";

    /**
     * 新しい作成を初期化します AjaxResult 物体，空のメッセージを表示させます。
     */
    public AjaxResult()
    {
    }

    /**
     * 新しい作成を初期化します AjaxResult 物体
     * 
     * @param code ステータスコード
     * @param msg コンテンツを返します
     */
    public AjaxResult(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 新しい作成を初期化します AjaxResult 物体
     * 
     * @param code ステータスコード
     * @param msg コンテンツを返します
     * @param data データオブジェクト
     */
    public AjaxResult(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 成功したニュースに戻ります
     * 
     * @return 成功したニュース
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("成功した操作");
    }

    /**
     * 成功データに戻ります
     * 
     * @return 成功したニュース
     */
    public static AjaxResult success(Object data)
    {
        return AjaxResult.success("成功した操作", data);
    }

    /**
     * 成功したニュースに戻ります
     * 
     * @param msg コンテンツを返します
     * @return 成功したニュース
     */
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 成功したニュースに戻ります
     * 
     * @param msg コンテンツを返します
     * @param data データオブジェクト
     * @return 成功したニュース
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 警告メッセージに戻ります
     *
     * @param msg コンテンツを返します
     * @return 警告メッセージ
     */
    public static AjaxResult warn(String msg)
    {
        return AjaxResult.warn(msg, null);
    }

    /**
     * 警告メッセージに戻ります
     *
     * @param msg コンテンツを返します
     * @param data データオブジェクト
     * @return 警告メッセージ
     */
    public static AjaxResult warn(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.WARN, msg, data);
    }

    /**
     * エラーメッセージを返します
     * 
     * @return 間違った情報
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("操作に失敗しました");
    }

    /**
     * エラーメッセージを返します
     * 
     * @param msg コンテンツを返します
     * @return 間違った情報
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * エラーメッセージを返します
     * 
     * @param msg コンテンツを返します
     * @param data データオブジェクト
     * @return 間違った情報
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * エラーメッセージを返します
     * 
     * @param code ステータスコード
     * @param msg コンテンツを返します
     * @return 間違った情報
     */
    public static AjaxResult error(int code, String msg)
    {
        return new AjaxResult(code, msg, null);
    }

    /**
     * 是否为成功したニュース
     *
     * @return 結果
     */
    public boolean isSuccess()
    {
        return Objects.equals(HttpStatus.SUCCESS, this.get(CODE_TAG));
    }

    /**
     * 是否为警告メッセージ
     *
     * @return 結果
     */
    public boolean isWarn()
    {
        return Objects.equals(HttpStatus.WARN, this.get(CODE_TAG));
    }

    /**
     * 是否为間違った情報
     *
     * @return 結果
     */
    public boolean isError()
    {
        return Objects.equals(HttpStatus.ERROR, this.get(CODE_TAG));
    }

    /**
     * 便利なチェーンコール
     *
     * @param key 鍵
     * @param value 価値
     * @return データオブジェクト
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}

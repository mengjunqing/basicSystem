package com.ruoyi.common.exception;

/**
 * ビジネス異常
 * 
 * @author ruoyi
 */
public final class ServiceException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * エラーコード
     */
    private Integer code;

    /**
     * エラーメッセージ
     */
    private String message;

    /**
     * 間違った詳細，内部デバッグエラー
     *
     * そして {@link CommonResult#getDetailMessage()} 一貫したデザイン
     */
    private String detailMessage;

    /**
     * 空気構造，バックシーケーションの問題を避けてください
     */
    public ServiceException()
    {
    }

    public ServiceException(String message)
    {
        this.message = message;
    }

    public ServiceException(String message, Integer code)
    {
        this.message = message;
        this.code = code;
    }

    public String getDetailMessage()
    {
        return detailMessage;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public Integer getCode()
    {
        return code;
    }

    public ServiceException setMessage(String message)
    {
        this.message = message;
        return this;
    }

    public ServiceException setDetailMessage(String detailMessage)
    {
        this.detailMessage = detailMessage;
        return this;
    }
}
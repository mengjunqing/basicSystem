package com.ruoyi.common.exception;

/**
 * グローバルな異常
 * 
 * @author ruoyi
 */
public class GlobalException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

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
    public GlobalException()
    {
    }

    public GlobalException(String message)
    {
        this.message = message;
    }

    public String getDetailMessage()
    {
        return detailMessage;
    }

    public GlobalException setDetailMessage(String detailMessage)
    {
        this.detailMessage = detailMessage;
        return this;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public GlobalException setMessage(String message)
    {
        this.message = message;
        return this;
    }
}
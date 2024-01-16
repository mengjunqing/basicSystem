package com.ruoyi.common.exception.user;

/**
 * 検証コード障害異常カテゴリ
 * 
 * @author ruoyi
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire", null);
    }
}

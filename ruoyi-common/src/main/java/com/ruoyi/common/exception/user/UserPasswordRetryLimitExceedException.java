package com.ruoyi.common.exception.user;

/**
 * ユーザーエラー異常カテゴリの最大数
 * 
 * @author ruoyi
 */
public class UserPasswordRetryLimitExceedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount, int lockTime)
    {
        super("user.password.retry.limit.exceed", new Object[] { retryLimitCount, lockTime });
    }
}

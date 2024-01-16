package com.ruoyi.common.exception.user;

/**
 * ユーザーには異常なクラスがありません
 * 
 * @author ruoyi
 */
public class UserNotExistsException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}

package com.ruoyi.common.exception.user;

/**
 * ユーザーのパスワードが正しくないか、標準の異常なカテゴリを満たしていない
 * 
 * @author ruoyi
 */
public class UserPasswordNotMatchException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException()
    {
        super("user.password.not.match", null);
    }
}

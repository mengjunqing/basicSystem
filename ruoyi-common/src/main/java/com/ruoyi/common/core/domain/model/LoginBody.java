package com.ruoyi.common.core.domain.model;

/**
 * ユーザーログインオブジェクト
 * 
 * @author ruoyi
 */
public class LoginBody
{
    /**
     * ユーザー名
     */
    private String username;

    /**
     * ユーザーのパスワード
     */
    private String password;

    /**
     * 検証コード
     */
    private String code;

    /**
     * 独自に識別します
     */
    private String uuid;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
}

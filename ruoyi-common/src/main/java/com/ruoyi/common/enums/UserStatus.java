package com.ruoyi.common.enums;

/**
 * ユーザーステータス
 * 
 * @author ruoyi
 */
public enum UserStatus
{
    OK("0", "普通"), DISABLE("1", "停止"), DELETED("2", "消去");

    private final String code;
    private final String info;

    UserStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}

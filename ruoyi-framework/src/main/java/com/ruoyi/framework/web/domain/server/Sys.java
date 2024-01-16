package com.ruoyi.framework.web.domain.server;

/**
 * システム関連情報
 * 
 * @author ruoyi
 */
public class Sys
{
    /**
     * サーバーの名前
     */
    private String computerName;

    /**
     * サーバIp
     */
    private String computerIp;

    /**
     * プロジェクトパス
     */
    private String userDir;

    /**
     * オペレーティング·システム
     */
    private String osName;

    /**
     * システム構造
     */
    private String osArch;

    public String getComputerName()
    {
        return computerName;
    }

    public void setComputerName(String computerName)
    {
        this.computerName = computerName;
    }

    public String getComputerIp()
    {
        return computerIp;
    }

    public void setComputerIp(String computerIp)
    {
        this.computerIp = computerIp;
    }

    public String getUserDir()
    {
        return userDir;
    }

    public void setUserDir(String userDir)
    {
        this.userDir = userDir;
    }

    public String getOsName()
    {
        return osName;
    }

    public void setOsName(String osName)
    {
        this.osName = osName;
    }

    public String getOsArch()
    {
        return osArch;
    }

    public void setOsArch(String osArch)
    {
        this.osArch = osArch;
    }
}

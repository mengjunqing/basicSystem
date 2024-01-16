package com.ruoyi.system.domain;

/**
 * 今、オンラインで話しています
 * 
 * @author ruoyi
 */
public class SysUserOnline
{
    /** セッション番号 */
    private String tokenId;

    /** 部署名 */
    private String deptName;

    /** ユーザー名 */
    private String userName;

    /** ログインIP住所 */
    private String ipaddr;

    /** ログイン住所 */
    private String loginLocation;

    /** ブラウザタイプ */
    private String browser;

    /** オペレーティング·システム */
    private String os;

    /** ログイン时间 */
    private Long loginTime;

    public String getTokenId()
    {
        return tokenId;
    }

    public void setTokenId(String tokenId)
    {
        this.tokenId = tokenId;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getIpaddr()
    {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr)
    {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation()
    {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation)
    {
        this.loginLocation = loginLocation;
    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public Long getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Long loginTime)
    {
        this.loginTime = loginTime;
    }
}

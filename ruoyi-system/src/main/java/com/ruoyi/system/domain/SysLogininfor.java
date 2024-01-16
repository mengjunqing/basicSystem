package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * システムアクセスレコードテーブル sys_logininfor
 * 
 * @author ruoyi
 */
public class SysLogininfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "シリアルナンバー", cellType = ColumnType.NUMERIC)
    private Long infoId;

    /** ユーザーアカウント */
    @Excel(name = "ユーザーアカウント")
    private String userName;

    /** ログインステータス 0成功 1失敗 */
    @Excel(name = "ログインステータス", readConverterExp = "0=成功,1=失敗")
    private String status;

    /** ログインIP住所 */
    @Excel(name = "ログイン住所")
    private String ipaddr;

    /** ログイン地点 */
    @Excel(name = "ログイン地点")
    private String loginLocation;

    /** ブラウザタイプ */
    @Excel(name = "ブラウザ")
    private String browser;

    /** オペレーティング·システム */
    @Excel(name = "オペレーティング·システム")
    private String os;

    /** 迅速なメッセージ */
    @Excel(name = "迅速なメッセージ")
    private String msg;

    /** 面接時間 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "面接時間", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    public Long getInfoId()
    {
        return infoId;
    }

    public void setInfoId(Long infoId)
    {
        this.infoId = infoId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }
}

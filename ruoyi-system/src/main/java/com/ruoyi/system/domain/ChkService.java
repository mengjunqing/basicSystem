package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * service对象 chk_service
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public class ChkService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 業務名 */
    @Excel(name = "業務名")
    private String title;

    /** 作成時間 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作成時間", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 説明 */
    @Excel(name = "説明")
    private String description;

    /** トリガー */
    @Excel(name = "トリガー")
    private Integer isTrigger;

    /** ステータス */
    @Excel(name = "ステータス")
    private Integer status;

    /** 強制的なOCRを実行するか */
    @Excel(name = "強制的なOCRを実行するか")
    private Integer isEnforceOcr;

    /** webで実行できるか */
    @Excel(name = "webで実行できるか")
    private Integer isPermitWeb;

    /** 審査システム実行するか */
    @Excel(name = "審査システム実行するか")
    private Integer isCheckSystem;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setIsTrigger(Integer isTrigger) 
    {
        this.isTrigger = isTrigger;
    }

    public Integer getIsTrigger() 
    {
        return isTrigger;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setIsEnforceOcr(Integer isEnforceOcr) 
    {
        this.isEnforceOcr = isEnforceOcr;
    }

    public Integer getIsEnforceOcr() 
    {
        return isEnforceOcr;
    }
    public void setIsPermitWeb(Integer isPermitWeb) 
    {
        this.isPermitWeb = isPermitWeb;
    }

    public Integer getIsPermitWeb() 
    {
        return isPermitWeb;
    }
    public void setIsCheckSystem(Integer isCheckSystem) 
    {
        this.isCheckSystem = isCheckSystem;
    }

    public Integer getIsCheckSystem() 
    {
        return isCheckSystem;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("createdTime", getCreatedTime())
            .append("description", getDescription())
            .append("isTrigger", getIsTrigger())
            .append("status", getStatus())
            .append("isEnforceOcr", getIsEnforceOcr())
            .append("isPermitWeb", getIsPermitWeb())
            .append("isCheckSystem", getIsCheckSystem())
            .toString();
    }
}

package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【関数名に記入してください】对象 chk_service
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public class ChkService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String title;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isTrigger;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isEnforceOcr;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isPermitWeb;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
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
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
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

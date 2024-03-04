package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * application_condition对象 chk_application_condition
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public class ChkApplicationCondition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 作成時間 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作成時間", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 作成ユーザー */
    @Excel(name = "作成ユーザー")
    private Long createdBy;

    /** 関連申請 */
    @Excel(name = "関連申請")
    private String applicationId;

    /** 関連業務の条件のフィールドID */
    @Excel(name = "関連業務の条件のフィールドID")
    private Long serviceConditionId;

    /** 関連業務の申請のフィールド値 */
    @Excel(name = "関連業務の申請のフィールド値")
    private String value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setCreatedBy(Long createdBy) 
    {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() 
    {
        return createdBy;
    }
    public void setApplicationId(String applicationId) 
    {
        this.applicationId = applicationId;
    }

    public String getApplicationId() 
    {
        return applicationId;
    }
    public void setServiceConditionId(Long serviceConditionId) 
    {
        this.serviceConditionId = serviceConditionId;
    }

    public Long getServiceConditionId() 
    {
        return serviceConditionId;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createdTime", getCreatedTime())
            .append("createdBy", getCreatedBy())
            .append("applicationId", getApplicationId())
            .append("serviceConditionId", getServiceConditionId())
            .append("value", getValue())
            .toString();
    }
}

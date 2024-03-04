package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * application_info对象 chk_application_info
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public class ChkApplicationInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 作成日時 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作成日時", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 外部キー制約 */
    @Excel(name = "外部キー制約")
    private String applicationId;

    /** サービス */
    @Excel(name = "サービス")
    private Long serviceInfoId;

    /** 値 */
    @Excel(name = "値")
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
    public void setApplicationId(String applicationId) 
    {
        this.applicationId = applicationId;
    }

    public String getApplicationId() 
    {
        return applicationId;
    }
    public void setServiceInfoId(Long serviceInfoId) 
    {
        this.serviceInfoId = serviceInfoId;
    }

    public Long getServiceInfoId() 
    {
        return serviceInfoId;
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
            .append("applicationId", getApplicationId())
            .append("serviceInfoId", getServiceInfoId())
            .append("value", getValue())
            .toString();
    }
}

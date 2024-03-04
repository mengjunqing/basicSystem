package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * service_info对象 chk_service_info
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public class ChkServiceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 作成日時 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作成日時", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 関連サービス */
    @Excel(name = "関連サービス")
    private Long serviceId;

    /** タイトル */
    @Excel(name = "タイトル")
    private String title;

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
    public void setServiceId(Long serviceId) 
    {
        this.serviceId = serviceId;
    }

    public Long getServiceId() 
    {
        return serviceId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createdTime", getCreatedTime())
            .append("serviceId", getServiceId())
            .append("title", getTitle())
            .toString();
    }
}

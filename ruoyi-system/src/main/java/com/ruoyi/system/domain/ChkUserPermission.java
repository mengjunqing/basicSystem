package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【関数名に記入してください】对象 chk_user_permission
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public class ChkUserPermission extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date updatedTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String permission;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long resourceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long roleId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setPermission(String permission) 
    {
        this.permission = permission;
    }

    public String getPermission() 
    {
        return permission;
    }
    public void setResourceId(Long resourceId) 
    {
        this.resourceId = resourceId;
    }

    public Long getResourceId() 
    {
        return resourceId;
    }
    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("updatedTime", getUpdatedTime())
            .append("createdTime", getCreatedTime())
            .append("permission", getPermission())
            .append("resourceId", getResourceId())
            .append("roleId", getRoleId())
            .toString();
    }
}

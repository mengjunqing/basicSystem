package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【関数名に記入してください】对象 file
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public class File extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String filename;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long uploadBy;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String filesize;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String savePath;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String rawpath;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long service;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFilename(String filename) 
    {
        this.filename = filename;
    }

    public String getFilename() 
    {
        return filename;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUploadBy(Long uploadBy) 
    {
        this.uploadBy = uploadBy;
    }

    public Long getUploadBy() 
    {
        return uploadBy;
    }
    public void setFilesize(String filesize) 
    {
        this.filesize = filesize;
    }

    public String getFilesize() 
    {
        return filesize;
    }
    public void setSavePath(String savePath) 
    {
        this.savePath = savePath;
    }

    public String getSavePath() 
    {
        return savePath;
    }
    public void setRawpath(String rawpath) 
    {
        this.rawpath = rawpath;
    }

    public String getRawpath() 
    {
        return rawpath;
    }
    public void setService(Long service) 
    {
        this.service = service;
    }

    public Long getService() 
    {
        return service;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("filename", getFilename())
            .append("createdAt", getCreatedAt())
            .append("uploadBy", getUploadBy())
            .append("filesize", getFilesize())
            .append("savePath", getSavePath())
            .append("rawpath", getRawpath())
            .append("service", getService())
            .toString();
    }
}

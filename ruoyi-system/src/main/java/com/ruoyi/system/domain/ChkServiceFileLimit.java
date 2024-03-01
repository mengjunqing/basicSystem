package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【関数名に記入してください】对象 chk_service_file_limit
 * 
 * @author ruoyi
 * @date 2024-03-01
 */
public class ChkServiceFileLimit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdAt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long service;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String filename;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String samplePicture;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String desctiption;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String fileType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String recommondDpi;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String fileSize;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String filenameRule;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isOcrSystem;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setService(Long service) 
    {
        this.service = service;
    }

    public Long getService() 
    {
        return service;
    }
    public void setFilename(String filename) 
    {
        this.filename = filename;
    }

    public String getFilename() 
    {
        return filename;
    }
    public void setSamplePicture(String samplePicture) 
    {
        this.samplePicture = samplePicture;
    }

    public String getSamplePicture() 
    {
        return samplePicture;
    }
    public void setDesctiption(String desctiption) 
    {
        this.desctiption = desctiption;
    }

    public String getDesctiption() 
    {
        return desctiption;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setRecommondDpi(String recommondDpi) 
    {
        this.recommondDpi = recommondDpi;
    }

    public String getRecommondDpi() 
    {
        return recommondDpi;
    }
    public void setFileSize(String fileSize) 
    {
        this.fileSize = fileSize;
    }

    public String getFileSize() 
    {
        return fileSize;
    }
    public void setFilenameRule(String filenameRule) 
    {
        this.filenameRule = filenameRule;
    }

    public String getFilenameRule() 
    {
        return filenameRule;
    }
    public void setIsOcrSystem(Integer isOcrSystem) 
    {
        this.isOcrSystem = isOcrSystem;
    }

    public Integer getIsOcrSystem() 
    {
        return isOcrSystem;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createdAt", getCreatedAt())
            .append("service", getService())
            .append("filename", getFilename())
            .append("samplePicture", getSamplePicture())
            .append("desctiption", getDesctiption())
            .append("fileType", getFileType())
            .append("recommondDpi", getRecommondDpi())
            .append("fileSize", getFileSize())
            .append("filenameRule", getFilenameRule())
            .append("isOcrSystem", getIsOcrSystem())
            .toString();
    }
}

package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * application_file对象 chk_application_file
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public class ChkApplicationFile extends BaseEntity
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

    /** 関連ファイルルール */
    @Excel(name = "関連ファイルルール")
    private Long serviceFileLimitId;

    /** ファイル名 */
    @Excel(name = "ファイル名")
    private String filename;

    /** ファイルタイプ */
    @Excel(name = "ファイルタイプ")
    private String fileType;

    /** ファイルサイズ */
    @Excel(name = "ファイルサイズ")
    private String fileSize;

    /** ファイルパス */
    @Excel(name = "ファイルパス")
    private String filePath;

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
    public void setServiceFileLimitId(Long serviceFileLimitId) 
    {
        this.serviceFileLimitId = serviceFileLimitId;
    }

    public Long getServiceFileLimitId() 
    {
        return serviceFileLimitId;
    }
    public void setFilename(String filename) 
    {
        this.filename = filename;
    }

    public String getFilename() 
    {
        return filename;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFileSize(String fileSize) 
    {
        this.fileSize = fileSize;
    }

    public String getFileSize() 
    {
        return fileSize;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createdTime", getCreatedTime())
            .append("applicationId", getApplicationId())
            .append("serviceFileLimitId", getServiceFileLimitId())
            .append("filename", getFilename())
            .append("fileType", getFileType())
            .append("fileSize", getFileSize())
            .append("filePath", getFilePath())
            .toString();
    }
}

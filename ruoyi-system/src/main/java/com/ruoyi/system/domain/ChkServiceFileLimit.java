package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * service_file_limit对象 chk_service_file_limit
 * 
 * @author jc.men
 * @date 2024-03-04
 */
public class ChkServiceFileLimit extends BaseEntity
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

    /** ファイル名 */
    @Excel(name = "ファイル名")
    private String filename;

    /** サンプル画像 */
    @Excel(name = "サンプル画像")
    private String samplePicture;

    /** 説明 */
    @Excel(name = "説明")
    private String description;

    /** ファイルタイプ */
    @Excel(name = "ファイルタイプ")
    private String fileType;

    /** 推奨DPI */
    @Excel(name = "推奨DPI")
    private String recommondDpi;

    /** ファイルサイズ */
    @Excel(name = "ファイルサイズ")
    private String fileSize;

    /** ファイル名のルール */
    @Excel(name = "ファイル名のルール")
    private String filenameRule;

    /** OCRシステムかどうか */
    @Excel(name = "OCRシステムかどうか")
    private Integer isOcrSystem;

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
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("createdTime", getCreatedTime())
            .append("serviceId", getServiceId())
            .append("filename", getFilename())
            .append("samplePicture", getSamplePicture())
            .append("description", getDescription())
            .append("fileType", getFileType())
            .append("recommondDpi", getRecommondDpi())
            .append("fileSize", getFileSize())
            .append("filenameRule", getFilenameRule())
            .append("isOcrSystem", getIsOcrSystem())
            .toString();
    }
}

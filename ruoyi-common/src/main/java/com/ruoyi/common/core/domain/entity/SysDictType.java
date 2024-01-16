package com.ruoyi.common.core.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 辞書タイプテーブル sys_dict_type
 * 
 * @author ruoyi
 */
public class SysDictType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 辞書のメインキー */
    @Excel(name = "辞書のメインキー", cellType = ColumnType.NUMERIC)
    private Long dictId;

    /** 辞書名 */
    @Excel(name = "辞書名")
    private String dictName;

    /** 辞書 */
    @Excel(name = "辞書")
    private String dictType;

    /** 州（0普通 1停止） */
    @Excel(name = "州", readConverterExp = "0=普通,1=停止")
    private String status;

    public Long getDictId()
    {
        return dictId;
    }

    public void setDictId(Long dictId)
    {
        this.dictId = dictId;
    }

    @NotBlank(message = "辞書の名前は空にすることはできません")
    @Size(min = 0, max = 100, message = "辞書の名前の長さを超えることはできません100個のキャラクター")
    public String getDictName()
    {
        return dictName;
    }

    public void setDictName(String dictName)
    {
        this.dictName = dictName;
    }

    @NotBlank(message = "辞書は空にすることはできません")
    @Size(min = 0, max = 100, message = "辞書の長さはそれ以上を超えてはなりません100個のキャラクター")
    @Pattern(regexp = "^[a-z][a-z0-9_]*$", message = "辞書は手紙から始める必要があります，できるだけです（小文字，番号，衰退）")
    public String getDictType()
    {
        return dictType;
    }

    public void setDictType(String dictType)
    {
        this.dictType = dictType;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dictId", getDictId())
            .append("dictName", getDictName())
            .append("dictType", getDictType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

package com.ruoyi.common.core.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 辞書データテーブル sys_dict_data
 * 
 * @author ruoyi
 */
public class SysDictData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 辞書 */
    @Excel(name = "辞書", cellType = ColumnType.NUMERIC)
    private Long dictCode;

    /** 辞書 */
    @Excel(name = "辞書", cellType = ColumnType.NUMERIC)
    private Long dictSort;

    /** 辞書ラベル */
    @Excel(name = "辞書ラベル")
    private String dictLabel;

    /** 辞書のキー値 */
    @Excel(name = "辞書のキー値")
    private String dictValue;

    /** 辞書 */
    @Excel(name = "辞書")
    private String dictType;

    /** スタイル属性（その他のスタイルエクステンション） */
    private String cssClass;

    /** テーブル辞書スタイル */
    private String listClass;

    /** デフォルトするかどうか（Yはい Nいいえ） */
    @Excel(name = "デフォルトするかどうか", readConverterExp = "Y=はい,N=いいえ")
    private String isDefault;

    /** 州（0普通 1停止） */
    @Excel(name = "ステータス", readConverterExp = "0=普通,1=停止")
    private String status;

    public Long getDictCode()
    {
        return dictCode;
    }

    public void setDictCode(Long dictCode)
    {
        this.dictCode = dictCode;
    }

    public Long getDictSort()
    {
        return dictSort;
    }

    public void setDictSort(Long dictSort)
    {
        this.dictSort = dictSort;
    }

    @NotBlank(message = "辞書ラベル不能为空")
    @Size(min = 0, max = 100, message = "辞書ラベル长度不能超过100個のキャラクター")
    public String getDictLabel()
    {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel)
    {
        this.dictLabel = dictLabel;
    }

    @NotBlank(message = "辞書のキー値不能为空")
    @Size(min = 0, max = 100, message = "辞書のキー値长度不能超过100個のキャラクター")
    public String getDictValue()
    {
        return dictValue;
    }

    public void setDictValue(String dictValue)
    {
        this.dictValue = dictValue;
    }

    @NotBlank(message = "辞書は空にすることはできません")
    @Size(min = 0, max = 100, message = "辞書の長さを超えることはできません100個のキャラクター")
    public String getDictType()
    {
        return dictType;
    }

    public void setDictType(String dictType)
    {
        this.dictType = dictType;
    }

    @Size(min = 0, max = 100, message = "スタイル属性长度不能超过100個のキャラクター")
    public String getCssClass()
    {
        return cssClass;
    }

    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    public String getListClass()
    {
        return listClass;
    }

    public void setListClass(String listClass)
    {
        this.listClass = listClass;
    }

    public boolean getDefault()
    {
        return UserConstants.YES.equals(this.isDefault);
    }

    public String getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
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
            .append("dictCode", getDictCode())
            .append("dictSort", getDictSort())
            .append("dictLabel", getDictLabel())
            .append("dictValue", getDictValue())
            .append("dictType", getDictType())
            .append("cssClass", getCssClass())
            .append("listClass", getListClass())
            .append("isDefault", getIsDefault())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

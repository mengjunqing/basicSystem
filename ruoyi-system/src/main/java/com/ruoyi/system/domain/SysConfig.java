package com.ruoyi.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * パラメーター構成テーブル sys_config
 * 
 * @author ruoyi
 */
public class SysConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** パラメーターメインキー */
    @Excel(name = "パラメーターメインキー", cellType = ColumnType.NUMERIC)
    private Long configId;

    /** パラメーター名 */
    @Excel(name = "パラメーター名")
    private String configName;

    /** パラメーターキー名 */
    @Excel(name = "パラメーターキー名")
    private String configKey;

    /** パラメーターキー値 */
    @Excel(name = "パラメーターキー値")
    private String configValue;

    /** ビルド-in（Yはい Nいいえ） */
    @Excel(name = "ビルド-in", readConverterExp = "Y=はい,N=いいえ")
    private String configType;

    public Long getConfigId()
    {
        return configId;
    }

    public void setConfigId(Long configId)
    {
        this.configId = configId;
    }

    @NotBlank(message = "パラメーター名不能为空")
    @Size(min = 0, max = 100, message = "パラメーター名不能超过100個々々々々のキャラクター")
    public String getConfigName()
    {
        return configName;
    }

    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    @NotBlank(message = "パラメーターキー名长度不能为空")
    @Size(min = 0, max = 100, message = "パラメーターキー名长度不能超过100個々々々々のキャラクター")
    public String getConfigKey()
    {
        return configKey;
    }

    public void setConfigKey(String configKey)
    {
        this.configKey = configKey;
    }

    @NotBlank(message = "パラメーターキー値不能为空")
    @Size(min = 0, max = 500, message = "パラメーターキー値长度不能超过500個々々々々のキャラクター")
    public String getConfigValue()
    {
        return configValue;
    }

    public void setConfigValue(String configValue)
    {
        this.configValue = configValue;
    }

    public String getConfigType()
    {
        return configType;
    }

    public void setConfigType(String configType)
    {
        this.configType = configType;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("configId", getConfigId())
            .append("configName", getConfigName())
            .append("configKey", getConfigKey())
            .append("configValue", getConfigValue())
            .append("configType", getConfigType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

package com.ruoyi.quartz.domain;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.constant.ScheduleConstants;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.quartz.util.CronUtils;

/**
 * タイミングタスクスケジューリングテーブル sys_job
 * 
 * @author ruoyi
 */
public class SysJob extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** タスクID */
    @Excel(name = "タスク序号", cellType = ColumnType.NUMERIC)
    private Long jobId;

    /** タスク名称 */
    @Excel(name = "タスク名称")
    private String jobName;

    /** タスク组名 */
    @Excel(name = "タスク组名")
    private String jobGroup;

    /** ターゲット文字列を呼び出します */
    @Excel(name = "ターゲット文字列を呼び出します")
    private String invokeTarget;

    /** cron急行 */
    @Excel(name = "急行 ")
    private String cronExpression;

    /** cron計画戦略 */
    @Excel(name = "計画戦略 ", readConverterExp = "0=デフォルト,1=即時トリガー実行,2=1つの実行をトリガーします,3=トリガーせずにすぐに実行します")
    private String misfirePolicy = ScheduleConstants.MISFIRE_DEFAULT;

    /** 同時に実行するかどうか（0許可する 1禁止するする） */
    @Excel(name = "同時実行", readConverterExp = "0=許可する,1=禁止するする")
    private String concurrent;

    /** タスク状态（0普通 1停止） */
    @Excel(name = "タスク状态", readConverterExp = "0=普通,1=停止")
    private String status;

    public Long getJobId()
    {
        return jobId;
    }

    public void setJobId(Long jobId)
    {
        this.jobId = jobId;
    }

    @NotBlank(message = "タスク名称不能为空")
    @Size(min = 0, max = 64, message = "タスク名称不能超过64個々々々々のキャラクター")
    public String getJobName()
    {
        return jobName;
    }

    public void setJobName(String jobName)
    {
        this.jobName = jobName;
    }

    public String getJobGroup()
    {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup)
    {
        this.jobGroup = jobGroup;
    }

    @NotBlank(message = "ターゲット文字列を呼び出します不能为空")
    @Size(min = 0, max = 500, message = "ターゲット文字列を呼び出します长度不能超过500個々々々々のキャラクター")
    public String getInvokeTarget()
    {
        return invokeTarget;
    }

    public void setInvokeTarget(String invokeTarget)
    {
        this.invokeTarget = invokeTarget;
    }

    @NotBlank(message = "Cron急行不能为空")
    @Size(min = 0, max = 255, message = "Cron緊急の行動は超えることはできません255個々々々々のキャラクター")
    public String getCronExpression()
    {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression)
    {
        this.cronExpression = cronExpression;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getNextValidTime()
    {
        if (StringUtils.isNotEmpty(cronExpression))
        {
            return CronUtils.getNextExecution(cronExpression);
        }
        return null;
    }

    public String getMisfirePolicy()
    {
        return misfirePolicy;
    }

    public void setMisfirePolicy(String misfirePolicy)
    {
        this.misfirePolicy = misfirePolicy;
    }

    public String getConcurrent()
    {
        return concurrent;
    }

    public void setConcurrent(String concurrent)
    {
        this.concurrent = concurrent;
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
            .append("jobId", getJobId())
            .append("jobName", getJobName())
            .append("jobGroup", getJobGroup())
            .append("cronExpression", getCronExpression())
            .append("nextValidTime", getNextValidTime())
            .append("misfirePolicy", getMisfirePolicy())
            .append("concurrent", getConcurrent())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

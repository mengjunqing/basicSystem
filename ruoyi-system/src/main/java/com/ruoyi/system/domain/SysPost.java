package com.ruoyi.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 位置テーブル sys_post
 * 
 * @author ruoyi
 */
public class SysPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ジョブ番号 */
    @Excel(name = "ジョブ番号", cellType = ColumnType.NUMERIC)
    private Long postId;

    /** ジョブコード */
    @Excel(name = "ジョブコード")
    private String postCode;

    /** ポジションタイトル */
    @Excel(name = "ポジションタイトル")
    private String postName;

    /** ジョブソート */
    @Excel(name = "ジョブソート")
    private Integer postSort;

    /** 州（0普通 1停止） */
    @Excel(name = "州", readConverterExp = "0=普通,1=停止")
    private String status;

    /** ユーザーがこの投稿ロゴに存在するかどうか デフォルトはありません */
    private boolean flag = false;

    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    @NotBlank(message = "ジョブコード不能为空")
    @Size(min = 0, max = 64, message = "ジョブコード长度不能超过64個々々々のキャラクター")
    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    @NotBlank(message = "ポジションタイトル不能为空")
    @Size(min = 0, max = 50, message = "ポジションタイトル长度不能超过50個々々々のキャラクター")
    public String getPostName()
    {
        return postName;
    }

    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    @NotNull(message = "注文が空になることができないことを示します")
    public Integer getPostSort()
    {
        return postSort;
    }

    public void setPostSort(Integer postSort)
    {
        this.postSort = postSort;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

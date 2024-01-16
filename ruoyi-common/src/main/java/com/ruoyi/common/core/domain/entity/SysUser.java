package com.ruoyi.common.core.domain.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.xss.Xss;

/**
 * ユーザーオブジェクト sys_user
 * 
 * @author ruoyi
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ユーザーID */
    @Excel(name = "ユーザー序号", cellType = ColumnType.NUMERIC, prompt = "ユーザー编号")
    private Long userId;

    /** 部門ID */
    @Excel(name = "部門编号", type = Type.IMPORT)
    private Long deptId;

    /** ユーザー账号 */
    @Excel(name = "ログイン名")
    private String userName;

    /** ユーザー昵称 */
    @Excel(name = "ユーザー名称")
    private String nickName;

    /** ユーザー邮箱 */
    @Excel(name = "ユーザー邮箱")
    private String email;

    /** 電話番号 */
    @Excel(name = "電話番号")
    private String phonenumber;

    /** ユーザー性别 */
    @Excel(name = "ユーザー性别", readConverterExp = "0=男,1=女性,2=未知")
    private String sex;

    /** ユーザー头像 */
    private String avatar;

    /** パスワード */
    private String password;

    /** アカウントのステータス（0普通 1停止） */
    @Excel(name = "アカウントのステータス", readConverterExp = "0=普通,1=停止")
    private String status;

    /** 消去（0代表する 2消去） */
    private String delFlag;

    /** 前回のログインIP */
    @Excel(name = "前回のログインIP", type = Type.EXPORT)
    private String loginIp;

    /** 前回のログイン时间 */
    @Excel(name = "前回のログイン时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    private Date loginDate;

    /** 部門对象 */
    @Excels({
        @Excel(name = "部門名称", targetAttr = "deptName", type = Type.EXPORT),
        @Excel(name = "部門负责人", targetAttr = "leader", type = Type.EXPORT)
    })
    private SysDept dept;

    /** キャラクター */
    private List<SysRole> roles;

    /** ロールグループ */
    private Long[] roleIds;

    /** ジョブグループ */
    private Long[] postIds;

    /** 役割ID */
    private Long roleId;

    public SysUser()
    {

    }

    public SysUser(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    @Xss(message = "ユーザー昵称不能包含脚本字符")
    @Size(min = 0, max = 30, message = "ユーザー昵称长度不能超过30個々のキャラクター")
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    @Xss(message = "ユーザー账号不能包含脚本字符")
    @NotBlank(message = "ユーザー账号不能为空")
    @Size(min = 0, max = 30, message = "ユーザー账号长度不能超过30個々のキャラクター")
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Email(message = "電子メール形式が正しくありません")
    @Size(min = 0, max = 50, message = "メールボックスの長さを超えることはできません50個々のキャラクター")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "電話番号长度不能超过11個々のキャラクター")
    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public Date getLoginDate()
    {
        return loginDate;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public SysDept getDept()
    {
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds()
    {
        return postIds;
    }

    public void setPostIds(Long[] postIds)
    {
        this.postIds = postIds;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dept", getDept())
            .toString();
    }
}

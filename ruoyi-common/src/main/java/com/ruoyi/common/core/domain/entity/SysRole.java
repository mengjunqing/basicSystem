package com.ruoyi.common.core.domain.entity;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * キャラクターテーブル sys_role
 * 
 * @author ruoyi
 */
public class SysRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 役割ID */
    @Excel(name = "役割序号", cellType = ColumnType.NUMERIC)
    private Long roleId;

    /** 役割名称 */
    @Excel(name = "役割名称")
    private String roleName;

    /** 役割权限 */
    @Excel(name = "役割权限")
    private String roleKey;

    /** 役割排序 */
    @Excel(name = "役割排序")
    private Integer roleSort;

    /** データ範囲（1：すべてのデータ権限；2：カスタムデータアクセス許可；3：本部のデータ許可；4：この部門および以下のデータ権限；5：データ権限のみ） */
    @Excel(name = "データ範囲", readConverterExp = "1=すべてのデータ権限,2=カスタムデータアクセス許可,3=本部のデータ許可,4=この部門および以下のデータ権限,5=データ権限のみ")
    private String dataScope;

    /** メニューツリー選択アイテムが関連付けられているかどうか（ 0：父と息子は相互接続されて表示されていません 1：父と息子の相互接続ディスプレイディスプレイ） */
    private boolean menuCheckStrictly;

    /** 部門のツリー選択アイテムが表示に関連しているかどうか（0：父と息子は相互接続されて表示されていません 1：父と息子の相互接続ディスプレイディスプレイ ） */
    private boolean deptCheckStrictly;

    /** 役割状态（0普通 1停止） */
    @Excel(name = "役割状态", readConverterExp = "0=普通,1=停止")
    private String status;

    /** 消去（0代表する 2消去） */
    private String delFlag;

    /** 用户是否存在此役割标识 デフォルトはありません */
    private boolean flag = false;

    /** メニュー */
    private Long[] menuIds;

    /** 部門グループ（データ許可） */
    private Long[] deptIds;

    /** 役割菜单权限 */
    private Set<String> permissions;

    public SysRole()
    {

    }

    public SysRole(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.roleId);
    }

    public static boolean isAdmin(Long roleId)
    {
        return roleId != null && 1L == roleId;
    }

    @NotBlank(message = "役割名称不能为空")
    @Size(min = 0, max = 30, message = "役割名称长度不能超过30個々のキャラクター")
    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    @NotBlank(message = "永続的なキャラクターは空にすることはできません")
    @Size(min = 0, max = 100, message = "許可文字の長さを超えることはできません100個々のキャラクター")
    public String getRoleKey()
    {
        return roleKey;
    }

    public void setRoleKey(String roleKey)
    {
        this.roleKey = roleKey;
    }

    @NotNull(message = "注文が空になることができないことを示します")
    public Integer getRoleSort()
    {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort)
    {
        this.roleSort = roleSort;
    }

    public String getDataScope()
    {
        return dataScope;
    }

    public void setDataScope(String dataScope)
    {
        this.dataScope = dataScope;
    }

    public boolean isMenuCheckStrictly()
    {
        return menuCheckStrictly;
    }

    public void setMenuCheckStrictly(boolean menuCheckStrictly)
    {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public boolean isDeptCheckStrictly()
    {
        return deptCheckStrictly;
    }

    public void setDeptCheckStrictly(boolean deptCheckStrictly)
    {
        this.deptCheckStrictly = deptCheckStrictly;
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

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public Long[] getMenuIds()
    {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds)
    {
        this.menuIds = menuIds;
    }

    public Long[] getDeptIds()
    {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds)
    {
        this.deptIds = deptIds;
    }

    public Set<String> getPermissions()
    {
        return permissions;
    }

    public void setPermissions(Set<String> permissions)
    {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleName", getRoleName())
            .append("roleKey", getRoleKey())
            .append("roleSort", getRoleSort())
            .append("dataScope", getDataScope())
            .append("menuCheckStrictly", isMenuCheckStrictly())
            .append("deptCheckStrictly", isDeptCheckStrictly())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}

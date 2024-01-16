package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleDept;

/**
 * 役割の役割は部門に関連しています データレイヤー
 * 
 * @author ruoyi
 */
public interface SysRoleDeptMapper
{
    /**
     * 役割を通してID部門の役割を削除します
     * 
     * @param roleId 役割ID
     * @return 結果
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * バッチの切断部門に関する関連情報
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * クエリ部門の使用数量
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * バッチ新しいサービス切断部門情報
     * 
     * @param roleDeptList サターシング部門のリスト
     * @return 結果
     */
    public int batchRoleDept(List<SysRoleDept> roleDeptList);
}

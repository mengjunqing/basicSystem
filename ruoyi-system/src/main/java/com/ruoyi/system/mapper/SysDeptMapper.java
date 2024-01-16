package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 部門管理 データレイヤー
 * 
 * @author ruoyi
 */
public interface SysDeptMapper
{
    /**
     * 照会部門管理データ
     * 
     * @param dept 部門情報
     * @return 部門情報コレクション
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 役割によるとIDクエリ部門ツリー情報
     * 
     * @param roleId 役割ID
     * @param deptCheckStrictly 部門のツリー選択アイテムが表示に関連しているかどうか
     * @return 部門リストの選択
     */
    public List<Long> selectDeptListByRoleId(@Param("roleId") Long roleId, @Param("deptCheckStrictly") boolean deptCheckStrictly);

    /**
     * 部門によるとID検索情報
     * 
     * @param deptId 部門ID
     * @return 部門情報
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * によるとIDすべてのサブデパートメントをクエリします
     * 
     * @param deptId 部門ID
     * @return 部門リスト
     */
    public List<SysDept> selectChildrenDeptById(Long deptId);

    /**
     * によるとIDすべてのサブデパートメントをクエリします（通常のステータス）
     * 
     * @param deptId 部門ID
     * @return 子部門数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 子ノードがあるかどうか
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public int hasChildByDeptId(Long deptId);

    /**
     * 部門にユーザーがいるかどうかを確認してください
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 検証部門の名前はユニークですか？
     * 
     * @param deptName 部署名
     * @param parentId 親部門ID
     * @return 結果
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

    /**
     * 新しい部門情報
     * 
     * @param dept 部門情報
     * @return 結果
     */
    public int insertDept(SysDept dept);

    /**
     * 部門情報を変更します
     * 
     * @param dept 部門情報
     * @return 結果
     */
    public int updateDept(SysDept dept);

    /**
     * 修改所在部門通常のステータス
     * 
     * @param deptIds 部門IDグループ
     */
    public void updateDeptStatusNormal(Long[] deptIds);

    /**
     * サブ要素の関係を変更します
     * 
     * @param depts サブエレメント
     * @return 結果
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

    /**
     * 部門管理情報を削除します
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public int deleteDeptById(Long deptId);
}

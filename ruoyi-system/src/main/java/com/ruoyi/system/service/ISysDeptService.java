package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 部門管理 サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysDeptService
{
    /**
     * 照会部門管理データ
     * 
     * @param dept 部門情報
     * @return 部門情報コレクション
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * クエリ部門のツリー構造情報
     * 
     * @param dept 部門情報
     * @return 部門ツリー情報コレクション
     */
    public List<TreeSelect> selectDeptTreeList(SysDept dept);

    /**
     * フロントエンドに必要なツリー構造を構築します
     * 
     * @param depts 部門リスト
     * @return ツリー構造リスト
     */
    public List<SysDept> buildDeptTree(List<SysDept> depts);

    /**
     * フロントエンドのプルダウンツリー構造を構築する
     * 
     * @param depts 部門リスト
     * @return 下拉ツリー構造リスト
     */
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);

    /**
     * 役割によるとIDクエリ部門ツリー情報
     * 
     * @param roleId 役割ID
     * @return 选中部門リスト
     */
    public List<Long> selectDeptListByRoleId(Long roleId);

    /**
     * 部門によるとID検索情報
     * 
     * @param deptId 部門ID
     * @return 部門情報
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * によるとIDすべてのサブデパートメントをクエリします（通常のステータス）
     * 
     * @param deptId 部門ID
     * @return 子部門数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 是否存在する部門子节点
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public boolean hasChildByDeptId(Long deptId);

    /**
     * 查询部門是否存在する用户
     * 
     * @param deptId 部門ID
     * @return 結果 true 存在する false 存在しないする
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 検証部門の名前はユニークですか？
     * 
     * @param dept 部門情報
     * @return 結果
     */
    public boolean checkDeptNameUnique(SysDept dept);

    /**
     * 検証部門にデータ権限があるかどうか
     * 
     * @param deptId 部門id
     */
    public void checkDeptDataScope(Long deptId);

    /**
     * 保存部門情報を追加しました
     * 
     * @param dept 部門情報
     * @return 結果
     */
    public int insertDept(SysDept dept);

    /**
     * 保存部門の情報を変更します
     * 
     * @param dept 部門情報
     * @return 結果
     */
    public int updateDept(SysDept dept);

    /**
     * 部門管理情報を削除します
     * 
     * @param deptId 部門ID
     * @return 結果
     */
    public int deleteDeptById(Long deptId);
}

package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.system.domain.SysUserRole;

/**
 * キャラクタービジネスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysRoleService
{
    /**
     * 条件のページネーションに従ってロールデータを確認してください
     * 
     * @param role ロール情報
     * @return 文字データセット情報
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * ユーザーによるとIDコーナーリストをクエリします
     * 
     * @param userId ユーザーID
     * @return コーナーリスト
     */
    public List<SysRole> selectRolesByUserId(Long userId);

    /**
     * ユーザーによるとIDクエリロール許可
     * 
     * @param userId ユーザーID
     * @return 許可リスト
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * すべての役割をクエリします
     * 
     * @return コーナーリスト
     */
    public List<SysRole> selectRoleAll();

    /**
     * ユーザーによるとIDキャラクター選択ボックスリストを取得します
     * 
     * @param userId ユーザーID
     * @return 役割を選択しましたIDリスト
     */
    public List<Long> selectRoleListByUserId(Long userId);

    /**
     * 役割を通してIDクエリロール
     * 
     * @param roleId 役割ID
     * @return スプリングオブジェクト情報
     */
    public SysRole selectRoleById(Long roleId);

    /**
     * パッセージの名前が名前を切るかどうかは一意です
     * 
     * @param role ロール情報
     * @return 結果
     */
    public boolean checkRoleNameUnique(SysRole role);

    /**
     * 検証ですか？
     * 
     * @param role ロール情報
     * @return 結果
     */
    public boolean checkRoleKeyUnique(SysRole role);

    /**
     * テストの操作が許可されているかどうか
     * 
     * @param role ロール情報
     */
    public void checkRoleAllowed(SysRole role);

    /**
     * 検証のためのデータ権限はありますか？
     * 
     * @param roleId 役割id
     */
    public void checkRoleDataScope(Long roleId);

    /**
     * 役割を通してIDクエリロール使用数量
     * 
     * @param roleId 役割ID
     * @return 結果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 新增保存ロール情報
     * 
     * @param role ロール情報
     * @return 結果
     */
    public int insertRole(SysRole role);

    /**
     * 修改保存ロール情報
     * 
     * @param role ロール情報
     * @return 結果
     */
    public int updateRole(SysRole role);

    /**
     * 通勤のステータスを変更します
     * 
     * @param role ロール情報
     * @return 結果
     */
    public int updateRoleStatus(SysRole role);

    /**
     * データ許可情報を変更します
     * 
     * @param role ロール情報
     * @return 結果
     */
    public int authDataScope(SysRole role);

    /**
     * 役割を通してID消去
     * 
     * @param roleId 役割ID
     * @return 結果
     */
    public int deleteRoleById(Long roleId);

    /**
     * 批量删除ロール情報
     * 
     * @param roleIds 削除用の切断ID
     * @return 結果
     */
    public int deleteRoleByIds(Long[] roleIds);

    /**
     * 取消授权ユーザー役割
     * 
     * @param userRole ユーザー和役割关联信息
     * @return 結果
     */
    public int deleteAuthUser(SysUserRole userRole);

    /**
     * 批量取消授权ユーザー役割
     * 
     * @param roleId 役割ID
     * @param userIds 需要取消授权的ユーザー数据ID
     * @return 結果
     */
    public int deleteAuthUsers(Long roleId, Long[] userIds);

    /**
     * 批量选择授权ユーザー役割
     * 
     * @param roleId 役割ID
     * @param userIds 需要删除的ユーザー数据ID
     * @return 結果
     */
    public int insertAuthUsers(Long roleId, Long[] userIds);
}

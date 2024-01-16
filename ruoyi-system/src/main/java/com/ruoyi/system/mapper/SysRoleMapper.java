package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysRole;

/**
 * キャラクターテーブル データレイヤー
 * 
 * @author ruoyi
 */
public interface SysRoleMapper
{
    /**
     * 条件のページネーションに従ってロールデータを確認してください
     * 
     * @param role ロール情報
     * @return 文字データセット情報
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * ユーザーによるとIDクエリロール
     * 
     * @param userId ユーザーID
     * @return コーナーリスト
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);

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
     * ユーザーによるとIDクエリロール
     * 
     * @param userName ユーザー名
     * @return コーナーリスト
     */
    public List<SysRole> selectRolesByUserName(String userName);

    /**
     * パッセージの名前が名前を切るかどうかは一意です
     * 
     * @param roleName 役割名称
     * @return ロール情報
     */
    public SysRole checkRoleNameUnique(String roleName);

    /**
     * 検証ですか？
     * 
     * @param roleKey モルタル
     * @return ロール情報
     */
    public SysRole checkRoleKeyUnique(String roleKey);

    /**
     * 修改ロール情報
     * 
     * @param role ロール情報
     * @return 結果
     */
    public int updateRole(SysRole role);

    /**
     * 新增ロール情報
     * 
     * @param role ロール情報
     * @return 結果
     */
    public int insertRole(SysRole role);

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
}

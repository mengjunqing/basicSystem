package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleMenu;

/**
 * 役割とメニューに関連するテーブル データレイヤー
 * 
 * @author ruoyi
 */
public interface SysRoleMenuMapper
{
    /**
     * クエリメニューの使用量
     * 
     * @param menuId メニューID
     * @return 結果
     */
    public int checkMenuExistRole(Long menuId);

    /**
     * 役割を通してID删除役割和メニュー关联
     * 
     * @param roleId 役割ID
     * @return 結果
     */
    public int deleteRoleMenuByRoleId(Long roleId);

    /**
     * 批量删除役割メニュー关联信息
     * 
     * @param ids データを削除する必要がありましたID
     * @return 結果
     */
    public int deleteRoleMenu(Long[] ids);

    /**
     * 批量新增役割メニュー信息
     * 
     * @param roleMenuList 役割メニュー列表
     * @return 結果
     */
    public int batchRoleMenu(List<SysRoleMenu> roleMenuList);
}

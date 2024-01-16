package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.system.domain.vo.RouterVo;

/**
 * メニュー ビジネス層
 * 
 * @author ruoyi
 */
public interface ISysMenuService
{
    /**
     * 根据ユーザー查询系统メニュー列表
     * 
     * @param userId ユーザーID
     * @return メニュー列表
     */
    public List<SysMenu> selectMenuList(Long userId);

    /**
     * 根据ユーザー查询系统メニュー列表
     * 
     * @param menu メニュー信息
     * @param userId ユーザーID
     * @return メニュー列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId);

    /**
     * 根据ユーザーIDQuery Authority
     * 
     * @param userId ユーザーID
     * @return 許可リスト
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * 役割によるとIDQuery Authority
     * 
     * @param roleId 役割ID
     * @return 許可リスト
     */
    public Set<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * 根据ユーザーID查询メニュー树信息
     * 
     * @param userId ユーザーID
     * @return メニュー列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 役割によるとID查询メニュー树信息
     * 
     * @param roleId 役割ID
     * @return 选中メニュー列表
     */
    public List<Long> selectMenuListByRoleId(Long roleId);

    /**
     * 构建前端路由所需要的メニュー
     * 
     * @param menus メニュー列表
     * @return ルーティングリスト
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * フロントエンドに必要なツリー構造を構築します
     * 
     * @param menus メニュー列表
     * @return ツリー構造リスト
     */
    public List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * フロントエンドのプルダウンツリー構造を構築する
     * 
     * @param menus メニュー列表
     * @return 下拉ツリー構造リスト
     */
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * 根据メニューID検索情報
     * 
     * @param menuId メニューID
     * @return メニュー信息
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * 是否存在するするメニュー子节点
     * 
     * @param menuId メニューID
     * @return 結果 true 存在するする false 存在するしないする
     */
    public boolean hasChildByMenuId(Long menuId);

    /**
     * 查询メニュー是否存在するする役割
     * 
     * @param menuId メニューID
     * @return 結果 true 存在するする false 存在するしないする
     */
    public boolean checkMenuExistRole(Long menuId);

    /**
     * 新增保存メニュー信息
     * 
     * @param menu メニュー信息
     * @return 結果
     */
    public int insertMenu(SysMenu menu);

    /**
     * 修改保存メニュー信息
     * 
     * @param menu メニュー信息
     * @return 結果
     */
    public int updateMenu(SysMenu menu);

    /**
     * 删除メニュー管理信息
     * 
     * @param menuId メニューID
     * @return 結果
     */
    public int deleteMenuById(Long menuId);

    /**
     * 校验メニュー名称是否唯一
     * 
     * @param menu メニュー信息
     * @return 結果
     */
    public boolean checkMenuNameUnique(SysMenu menu);
}

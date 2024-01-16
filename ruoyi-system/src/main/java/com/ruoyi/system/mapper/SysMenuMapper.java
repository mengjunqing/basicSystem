package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysMenu;

/**
 * メニューテーブル データレイヤー
 *
 * @author ruoyi
 */
public interface SysMenuMapper
{
    /**
     * クエリシステムメニューリスト
     *
     * @param menu メニュー情報
     * @return メニューリスト
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * ユーザーの所有権によると
     *
     * @return 許可リスト
     */
    public List<String> selectMenuPerms();

    /**
     * ユーザーによるとクエリシステムメニューリスト
     *
     * @param menu メニュー情報
     * @return メニューリスト
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);

    /**
     * 役割によるとIDQuery Authority
     * 
     * @param roleId 役割ID
     * @return 許可リスト
     */
    public List<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * ユーザーによるとIDQuery Authority
     *
     * @param userId ユーザーID
     * @return 許可リスト
     */
    public List<String> selectMenuPermsByUserId(Long userId);

    /**
     * ユーザーによるとIDクエリメニュー
     *
     * @return メニューリスト
     */
    public List<SysMenu> selectMenuTreeAll();

    /**
     * ユーザーによるとIDクエリメニュー
     *
     * @param userId ユーザーID
     * @return メニューリスト
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 役割によるとIDクエリメニュー树信息
     * 
     * @param roleId 役割ID
     * @param menuCheckStrictly メニューツリーの選択アイテムが関連付けられているかどうか
     * @return 选中メニューリスト
     */
    public List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);

    /**
     * メニューによるとID検索情報
     *
     * @param menuId メニューID
     * @return メニュー情報
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * 是否存在メニュー子节点
     *
     * @param menuId メニューID
     * @return 結果
     */
    public int hasChildByMenuId(Long menuId);

    /**
     * 新增メニュー情報
     *
     * @param menu メニュー情報
     * @return 結果
     */
    public int insertMenu(SysMenu menu);

    /**
     * 修改メニュー情報
     *
     * @param menu メニュー情報
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
     * @param menuName メニュー名称
     * @param parentId 父メニューID
     * @return 結果
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
}

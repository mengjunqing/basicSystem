package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.system.domain.SysUserOnline;

/**
 * オンラインユーザー サービスレイヤー
 * 
 * @author ruoyi
 */
public interface ISysUserOnlineService
{
    /**
     * ログインアドレスによるクエリ情報
     * 
     * @param ipaddr ログインアドレス
     * @param user ユーザー情報
     * @return オンラインユーザー信息
     */
    public SysUserOnline selectOnlineByIpaddr(String ipaddr, LoginUser user);

    /**
     * ユーザー名を介して情報をクエリします
     * 
     * @param userName ユーザー名
     * @param user ユーザー情報
     * @return オンラインユーザー信息
     */
    public SysUserOnline selectOnlineByUserName(String userName, LoginUser user);

    /**
     * 通过ログインアドレス/ユーザー名查询信息
     * 
     * @param ipaddr ログインアドレス
     * @param userName ユーザー名
     * @param user ユーザー情報
     * @return オンラインユーザー信息
     */
    public SysUserOnline selectOnlineByInfo(String ipaddr, String userName, LoginUser user);

    /**
     * 设置オンラインユーザー信息
     * 
     * @param user ユーザー情報
     * @return オンラインユーザー
     */
    public SysUserOnline loginUserToUserOnline(LoginUser user);
}

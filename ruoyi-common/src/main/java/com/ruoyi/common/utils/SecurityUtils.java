package com.ruoyi.common.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.PatternMatchUtils;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;

/**
 * セキュリティサービスツール
 * 
 * @author ruoyi
 */
public class SecurityUtils
{

    /**
     * ユーザーID
     **/
    public static Long getUserId()
    {
        try
        {
            return getLoginUser().getUserId();
        }
        catch (Exception e)
        {
            throw new ServiceException("得るユーザーID異常な", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 部門の取得ID
     **/
    public static Long getDeptId()
    {
        try
        {
            return getLoginUser().getDeptId();
        }
        catch (Exception e)
        {
            throw new ServiceException("部門の取得ID異常な", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 得るユーザー账户
     **/
    public static String getUsername()
    {
        try
        {
            return getLoginUser().getUsername();
        }
        catch (Exception e)
        {
            throw new ServiceException("得るユーザー账户異常な", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 得るユーザー
     **/
    public static LoginUser getLoginUser()
    {
        try
        {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new ServiceException("得るユーザー信息異常な", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 得るAuthentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成するBCryptPasswordEncoderパスワード
     *
     * @param password パスワード
     * @return 暗号化された文字列
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断パスワード是否相同
     *
     * @param rawPassword 真实パスワード
     * @param encodedPassword キャラクターの後のいとこ
     * @return 結果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 管理者になるかどうか
     * 
     * @param userId ユーザーID
     * @return 結果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    /**
     * 验证ユーザー是否具备某权限
     * 
     * @param permission 権限文字列
     * @return ユーザー是否具备某权限
     */
    public static boolean hasPermi(String permission)
    {
        return hasPermi(getLoginUser().getPermissions(), permission);
    }

    /**
     * 権限が含まれているかどうかを判断します
     * 
     * @param authorities 許可リスト
     * @param permission 権限文字列
     * @return ユーザー是否具备某权限
     */
    public static boolean hasPermi(Collection<String> authorities, String permission)
    {
        return authorities.stream().filter(StringUtils::hasText)
                .anyMatch(x -> Constants.ALL_PERMISSION.equals(x) || PatternMatchUtils.simpleMatch(x, permission));
    }

    /**
     * 验证ユーザー是否拥有某个役割
     * 
     * @param role 文字識別
     * @return ユーザー是否具备某役割
     */
    public static boolean hasRole(String role)
    {
        List<SysRole> roleList = getLoginUser().getUser().getRoles();
        Collection<String> roles = roleList.stream().map(SysRole::getRoleKey).collect(Collectors.toSet());
        return hasRole(roles, role);
    }

    /**
     * 文字が含まれているかどうかを判断します
     * 
     * @param roles コーナーリスト
     * @param role 役割
     * @return ユーザー是否具备某役割权限
     */
    public static boolean hasRole(Collection<String> roles, String role)
    {
        return roles.stream().filter(StringUtils::hasText)
                .anyMatch(x -> Constants.SUPER_ADMIN.equals(x) || PatternMatchUtils.simpleMatch(x, role));
    }

}

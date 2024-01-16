package com.ruoyi.framework.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.ServletUtils;

/**
 * サービス関連の構成
 * 
 * @author ruoyi
 */
@Component
public class ServerConfig
{
    /**
     * 完全な要求パスを取得します，含む：ドメイン名，ポート，コンテキストアクセスパス
     * 
     * @return サービスアドレス
     */
    public String getUrl()
    {
        HttpServletRequest request = ServletUtils.getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request)
    {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}

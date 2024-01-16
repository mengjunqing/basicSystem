package com.ruoyi.framework.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * データソーススイッチ処理
 * 
 * @author ruoyi
 */
public class DynamicDataSourceContextHolder
{
    public static final Logger log = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    /**
     * 使用ThreadLocalメンテナンス変数，ThreadLocalこの変数を使用して、各スレッドに独立変数コピーを提供します，
     * そのため、すべてのスレッドはコピーを独立して変更できます，他のスレッドに対応するコピーには影響しません。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * データソースの変数を設定します
     */
    public static void setDataSourceType(String dsType)
    {
        log.info("スイッチ{}知能", dsType);
        CONTEXT_HOLDER.set(dsType);
    }

    /**
     * 获得知能的变量
     */
    public static String getDataSourceType()
    {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空知能变量
     */
    public static void clearDataSourceType()
    {
        CONTEXT_HOLDER.remove();
    }
}

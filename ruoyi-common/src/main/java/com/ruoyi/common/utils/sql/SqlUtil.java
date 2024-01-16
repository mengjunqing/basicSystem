package com.ruoyi.common.utils.sql;

import com.ruoyi.common.exception.UtilException;
import com.ruoyi.common.utils.StringUtils;

/**
 * sql操作ツール
 * 
 * @author ruoyi
 */
public class SqlUtil
{
    /**
     * 一般的に使用されます sqlキーワード
     */
    public static String SQL_REGEX = "and |extractvalue|updatexml|exec |insert |select |delete |update |drop |count |chr |mid |master |truncate |char |declare |or |+|user()";

    /**
     * サポートレターのみ、番号、下線、空間、コンマ、小数（複数のフィールドソートをサポートします）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

    /**
     * 制限orderBy最大長
     */
    private static final int ORDER_BY_MAX_LENGTH = 500;

    /**
     * 文字を確認してください，バイパスして注射を防ぎます
     */
    public static String escapeOrderBySql(String value)
    {
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value))
        {
            throw new UtilException("パラメーターは仕様を満たしていません，お問い合わせできません");
        }
        if (StringUtils.length(value) > ORDER_BY_MAX_LENGTH)
        {
            throw new UtilException("参数已超过最大制限，お問い合わせできません");
        }
        return value;
    }

    /**
     * 確認する order by 文法が規範を満たすかどうか
     */
    public static boolean isValidOrderBySql(String value)
    {
        return value.matches(SQL_PATTERN);
    }

    /**
     * SQLキーワード检查
     */
    public static void filterKeyword(String value)
    {
        if (StringUtils.isEmpty(value))
        {
            return;
        }
        String[] sqlKeywords = StringUtils.split(SQL_REGEX, "\\|");
        for (String sqlKeyword : sqlKeywords)
        {
            if (StringUtils.indexOfIgnoreCase(value, sqlKeyword) > -1)
            {
                throw new UtilException("パラメーターの存在SQL注射リスク");
            }
        }
    }
}

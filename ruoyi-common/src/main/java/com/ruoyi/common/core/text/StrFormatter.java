package com.ruoyi.common.core.text;

import com.ruoyi.common.utils.StringUtils;

/**
 * 文字列のフォーマット
 * 
 * @author ruoyi
 */
public class StrFormatter
{
    public static final String EMPTY_JSON = "{}";
    public static final char C_BACKSLASH = '\\';
    public static final char C_DELIM_START = '{';
    public static final char C_DELIM_END = '}';

    /**
     * フォーマット文字列<br>
     * この方法は、配置記号の単純さにすぎません {} パラメーターを順番に交換します<br>
     * 出力したい場合 {} 使用 \\转義 { に，出力したい場合 {} 前の \ 使用双转義符 \\\\ に<br>
     * 例：<br>
     * 通常使用されます：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转義{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转義\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     * 
     * @param strPattern 文字列テンプレート
     * @param argArray パラメーターリスト
     * @return 結果
     */
    public static String format(final String strPattern, final Object... argArray)
    {
        if (StringUtils.isEmpty(strPattern) || StringUtils.isEmpty(argArray))
        {
            return strPattern;
        }
        final int strPatternLength = strPattern.length();

        // 初期化の長さは、パフォーマンスを向上させる方が良いです
        StringBuilder sbuf = new StringBuilder(strPatternLength + 50);

        int handledPosition = 0;
        int delimIndex;// 配置がある場所
        for (int argIndex = 0; argIndex < argArray.length; argIndex++)
        {
            delimIndex = strPattern.indexOf(EMPTY_JSON, handledPosition);
            if (delimIndex == -1)
            {
                if (handledPosition == 0)
                {
                    return strPattern;
                }
                else
                { // 文字列テンプレート剩余部分不再包含占位符，加入剩余部分后返回結果
                    sbuf.append(strPattern, handledPosition, strPatternLength);
                    return sbuf.toString();
                }
            }
            else
            {
                if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == C_BACKSLASH)
                {
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == C_BACKSLASH)
                    {
                        // 转義符之前还有一个转義符，職業シンボルはまだ効果的です
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(Convert.utf8Str(argArray[argIndex]));
                        handledPosition = delimIndex + 2;
                    }
                    else
                    {
                        // 占位符被转義
                        argIndex--;
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(C_DELIM_START);
                        handledPosition = delimIndex + 1;
                    }
                }
                else
                {
                    // 通常の配置記号
                    sbuf.append(strPattern, handledPosition, delimIndex);
                    sbuf.append(Convert.utf8Str(argArray[argIndex]));
                    handledPosition = delimIndex + 2;
                }
            }
        }
        // 最後のプレースホルダーに参加した後のすべてのキャラクター
        sbuf.append(strPattern, handledPosition, strPattern.length());

        return sbuf.toString();
    }
}

package com.ruoyi.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.util.AntPathMatcher;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.text.StrFormatter;

/**
 * 文字列ツールクラス
 * 
 * @author ruoyi
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils
{
    /** ヌルの文字列 */
    private static final String NULLSTR = "";

    /** 下線 */
    private static final char SEPARATOR = '_';

    /**
     * 取得パラメーターはヌルの値ではありません
     * 
     * @param value defaultValue 判断するvalue
     * @return value 返品値
     */
    public static <T> T nvl(T value, T defaultValue)
    {
        return value != null ? value : defaultValue;
    }

    /**
     * * 1つを判断しますCollectionヌルかどうか， 含むList，Set，Queue
     * 
     * @param coll 判断するCollection
     * @return true：ヌルです false：ヌルでない
     */
    public static boolean isEmpty(Collection<?> coll)
    {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 1つを判断しますCollection是否ヌルでない，含むList，Set，Queue
     * 
     * @param coll 判断するCollection
     * @return true：ヌルでない false：ヌル
     */
    public static boolean isNotEmpty(Collection<?> coll)
    {
        return !isEmpty(coll);
    }

    /**
     * * 1つを判断します物体数组ヌルかどうか
     * 
     * @param objects 判断する物体数组
     ** @return true：ヌルです false：ヌルでない
     */
    public static boolean isEmpty(Object[] objects)
    {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * 1つを判断します物体数组是否ヌルでない
     * 
     * @param objects 判断する物体数组
     * @return true：ヌルでない false：ヌル
     */
    public static boolean isNotEmpty(Object[] objects)
    {
        return !isEmpty(objects);
    }

    /**
     * * 1つを判断しますMapヌルかどうか
     * 
     * @param map 判断するMap
     * @return true：ヌルです false：ヌルでない
     */
    public static boolean isEmpty(Map<?, ?> map)
    {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * 1つを判断しますMapヌルかどうか
     * 
     * @param map 判断するMap
     * @return true：ヌルでない false：ヌル
     */
    public static boolean isNotEmpty(Map<?, ?> map)
    {
        return !isEmpty(map);
    }

    /**
     * * 1つを判断します弦ヌルかどうか串
     * 
     * @param str String
     * @return true：ヌルです false：ヌルでない
     */
    public static boolean isEmpty(String str)
    {
        return isNull(str) || NULLSTR.equals(str.trim());
    }

    /**
     * * 1つを判断します弦そうであるかどうかヌルでない串
     * 
     * @param str String
     * @return true：ヌルでない串 false：ヌル串
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * * 1つを判断します物体ヌルかどうか
     * 
     * @param object Object
     * @return true：ヌルです false：ヌルでない
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 1つを判断します物体是否ヌルでない
     * 
     * @param object Object
     * @return true：ヌルでない false：ヌル
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

    /**
     * * 1つを判断します物体是否アレイです类型（Java他のアレイの基本タイプ）
     * 
     * @param object 物体
     * @return true：アレイです false：不アレイです
     */
    public static boolean isArray(Object object)
    {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去ヌル格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }

    /**
     * 文字列をインターセプトします
     * 
     * @param str 弦
     * @param start 始める
     * @return 結果
     */
    public static String substring(final String str, int start)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = str.length() + start;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (start > str.length())
        {
            return NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 文字列をインターセプトします
     * 
     * @param str 弦
     * @param start 始める
     * @param end 仕上げる
     * @return 結果
     */
    public static String substring(final String str, int start, int end)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (end < 0)
        {
            end = str.length() + end;
        }
        if (start < 0)
        {
            start = str.length() + start;
        }

        if (end > str.length())
        {
            end = str.length();
        }

        if (start > end)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (end < 0)
        {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 判断ヌルかどうか，并且不是ヌル白字符
     * 
     * @param str 判断するvalue
     * @return 結果
     */
    public static boolean hasText(String str)
    {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    private static boolean containsText(CharSequence str)
    {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++)
        {
            if (!Character.isWhitespace(str.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * フォーマット, {} プレースホルダーを示します<br>
     * この方法は、配置記号の単純さにすぎません {} パラメーターを順番に交換します<br>
     * 出力したい場合 {} 使用 \\正義 { に，出力したい場合 {} 前の \ 使用双正義符 \\\\ に<br>
     * 例：<br>
     * 通常使用されます：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 正義{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 正義\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     * 
     * @param template テキストテンプレート，交換部品 {} 急行
     * @param params パラメーター
     * @return フォーマット化されたテキスト
     */
    public static String format(String template, Object... params)
    {
        if (isEmpty(params) || isEmpty(template))
        {
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * そうであるかどうかhttp(s)://始まり
     * 
     * @param link リンク
     * @return 結果
     */
    public static boolean ishttp(String link)
    {
        return StringUtils.startsWithAny(link, Constants.HTTP, Constants.HTTPS);
    }

    /**
     * 弦转set
     * 
     * @param str 弦
     * @param sep 分離主義者
     * @return set集める
     */
    public static final Set<String> str2Set(String str, String sep)
    {
        return new HashSet<String>(str2List(str, sep, true, false));
    }

    /**
     * 弦转list
     * 
     * @param str 弦
     * @param sep 分離主義者
     * @param filterBlank 过滤纯ヌル白
     * @param trim 去掉首尾ヌル白
     * @return list集める
     */
    public static final List<String> str2List(String str, String sep, boolean filterBlank, boolean trim)
    {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isEmpty(str))
        {
            return list;
        }

        // 过滤ヌル白弦
        if (filterBlank && StringUtils.isBlank(str))
        {
            return list;
        }
        String[] split = str.split(sep);
        for (String string : split)
        {
            if (filterBlank && StringUtils.isBlank(string))
            {
                continue;
            }
            if (trim)
            {
                string = string.trim();
            }
            list.add(string);
        }

        return list;
    }

    /**
     * 与えられたcollection列表中是否含む数组array 与えられた数组array中是否含む给定的元素value
     *
     * @param collection 给定的集める
     * @param array 与えられた配列
     * @return boolean 結果
     */
    public static boolean containsAny(Collection<String> collection, String... array)
    {
        if (isEmpty(collection) || isEmpty(array))
        {
            return false;
        }
        else
        {
            for (String str : array)
            {
                if (collection.contains(str))
                {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 查找指定弦是否含む指定弦列表中的任意一个弦同时串忽略大小写
     *
     * @param cs 指定弦
     * @param searchCharSequences 需要检查的弦数组
     * @return 是否含む任意一个弦
     */
    public static boolean containsAnyIgnoreCase(CharSequence cs, CharSequence... searchCharSequences)
    {
        if (isEmpty(cs) || isEmpty(searchCharSequences))
        {
            return false;
        }
        for (CharSequence testStr : searchCharSequences)
        {
            if (containsIgnoreCase(cs, testStr))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 驼峰转下線命名
     */
    public static String toUnderScoreCase(String str)
    {
        if (str == null)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // フロントキャラクターが大文字かどうか
        boolean preCharIsUpperCase = true;
        // 現在のキャラクターが大文字かどうか
        boolean curreCharIsUpperCase = true;
        // 次のキャラクターが大文字かどうか
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (i > 0)
            {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            }
            else
            {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1))
            {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否含む弦
     * 
     * @param str 验证弦
     * @param strs 弦组
     * @return 含む返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下線大写方式命名的弦转换为驼峰式。如果转换前的下線大写方式命名的弦ヌルです，则返回ヌルの文字列。 例えば：HELLO_WORLD->HelloWorld
     * 
     * @param name 转换前的下線大写方式命名的弦
     * @return 转换后的驼峰式命名的弦
     */
    public static String convertToCamelCase(String name)
    {
        StringBuilder result = new StringBuilder();
        // 迅速な検査
        if (name == null || name.isEmpty())
        {
            // 変更する必要はありません
            return "";
        }
        else if (!name.contains("_"))
        {
            // 不含下線，最初の手紙を書くだけです
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下線将原始弦分割
        String[] camels = name.split("_");
        for (String camel : camels)
        {
            // 跳过原始弦中始まり、结尾的下换线或双重下線
            if (camel.isEmpty())
            {
                continue;
            }
            // 最初の文字
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * カタログの命名方法
     * 例えば：user_name->userName
     */
    public static String toCamelCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        if (s.indexOf(SEPARATOR) == -1)
        {
            return s;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (c == SEPARATOR)
            {
                upperCase = true;
            }
            else if (upperCase)
            {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 查找指定弦一致するかどうか指定弦列表中的任意一个弦
     * 
     * @param str 指定弦
     * @param strs 需要检查的弦数组
     * @return 一致するかどうか
     */
    public static boolean matches(String str, List<String> strs)
    {
        if (isEmpty(str) || isEmpty(strs))
        {
            return false;
        }
        for (String pattern : strs)
        {
            if (isMatch(pattern, str))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断urlルールで構成されていますか: 
     * ? 急行单個々のキャラクター; 
     * * 急行一层路径内的任意弦，レベルを横切らないでください; 
     * ** 急行任意层路径;
     * 
     * @param pattern 一致するルール
     * @param url 一致する必要があるものurl
     * @return
     */
    public static boolean isMatch(String pattern, String url)
    {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj)
    {
        return (T) obj;
    }

    /**
     * 残りの番号0，指定された長さに達します。知らせ，如果数字转换为弦后，より大きいsize，保持するだけです やっとsize個々のキャラクター。
     * 
     * @param num 数字物体
     * @param size 弦指定长度
     * @return 返回数字的弦格式，该弦为指定长度。
     */
    public static final String padl(final Number num, final int size)
    {
        return padl(num.toString(), size, '0');
    }

    /**
     * 弦左补齐。如果原始弦sより大きいsize，保持するだけですやっとsize個々のキャラクター。
     * 
     * @param s 原始弦
     * @param size 弦指定长度
     * @param c 補完するためのキャラクター
     * @return 返回指定长度的弦，由原弦左补齐或截取得到。
     */
    public static final String padl(final String s, final int size, final char c)
    {
        final StringBuilder sb = new StringBuilder(size);
        if (s != null)
        {
            final int len = s.length();
            if (s.length() <= size)
            {
                for (int i = size - len; i > 0; i--)
                {
                    sb.append(c);
                }
                sb.append(s);
            }
            else
            {
                return s.substring(len - size, len);
            }
        }
        else
        {
            for (int i = size; i > 0; i--)
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
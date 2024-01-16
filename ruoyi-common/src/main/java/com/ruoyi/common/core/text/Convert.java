package com.ruoyi.common.core.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.Set;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * タイプコンバーター
 *
 * @author ruoyi
 */
public class Convert
{
    /**
     * 文字列に変換されました<br>
     * 与えられた値がある場合null，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static String toStr(Object value, String defaultValue)
    {
        if (null == value)
        {
            return defaultValue;
        }
        if (value instanceof String)
        {
            return (String) value;
        }
        return value.toString();
    }

    /**
     * 文字列に変換されました<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static String toStr(Object value)
    {
        return toStr(value, null);
    }

    /**
     * 文字に変換されました<br>
     * 与えられた値がある場合null，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Character toChar(Object value, Character defaultValue)
    {
        if (null == value)
        {
            return defaultValue;
        }
        if (value instanceof Character)
        {
            return (Character) value;
        }

        final String valueStr = toStr(value, null);
        return StringUtils.isEmpty(valueStr) ? defaultValue : valueStr.charAt(0);
    }

    /**
     * 文字に変換されました<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Character toChar(Object value)
    {
        return toChar(value, null);
    }

    /**
     * 変換するbyte<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Byte toByte(Object value, Byte defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Byte)
        {
            return (Byte) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).byteValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Byte.parseByte(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するbyte<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Byte toByte(Object value)
    {
        return toByte(value, null);
    }

    /**
     * 変換するShort<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Short toShort(Object value, Short defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Short)
        {
            return (Short) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).shortValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Short.parseShort(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するShort<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Short toShort(Object value)
    {
        return toShort(value, null);
    }

    /**
     * 変換するNumber<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Number toNumber(Object value, Number defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Number)
        {
            return (Number) value;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return NumberFormat.getInstance().parse(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するNumber<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Number toNumber(Object value)
    {
        return toNumber(value, null);
    }

    /**
     * 変換するint<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Integer toInt(Object value, Integer defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Integer)
        {
            return (Integer) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Integer.parseInt(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するint<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Integer toInt(Object value)
    {
        return toInt(value, null);
    }

    /**
     * 変換するInteger配列<br>
     *
     * @param str 変換された値
     * @return 結果
     */
    public static Integer[] toIntArray(String str)
    {
        return toIntArray(",", str);
    }

    /**
     * 変換するLong配列<br>
     *
     * @param str 変換された値
     * @return 結果
     */
    public static Long[] toLongArray(String str)
    {
        return toLongArray(",", str);
    }

    /**
     * 変換するInteger配列<br>
     *
     * @param split ポイント離主義者
     * @param split 変換された値
     * @return 結果
     */
    public static Integer[] toIntArray(String split, String str)
    {
        if (StringUtils.isEmpty(str))
        {
            return new Integer[] {};
        }
        String[] arr = str.split(split);
        final Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            final Integer v = toInt(arr[i], 0);
            ints[i] = v;
        }
        return ints;
    }

    /**
     * 変換するLong配列<br>
     *
     * @param split ポイント離主義者
     * @param str 変換された値
     * @return 結果
     */
    public static Long[] toLongArray(String split, String str)
    {
        if (StringUtils.isEmpty(str))
        {
            return new Long[] {};
        }
        String[] arr = str.split(split);
        final Long[] longs = new Long[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            final Long v = toLong(arr[i], null);
            longs[i] = v;
        }
        return longs;
    }

    /**
     * 変換するString配列<br>
     *
     * @param str 変換された値
     * @return 結果
     */
    public static String[] toStrArray(String str)
    {
        return toStrArray(",", str);
    }

    /**
     * 変換するString配列<br>
     *
     * @param split ポイント離主義者
     * @param split 変換された値
     * @return 結果
     */
    public static String[] toStrArray(String split, String str)
    {
        return str.split(split);
    }

    /**
     * 変換するlong<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Long toLong(Object value, Long defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Long)
        {
            return (Long) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).longValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            // 科学カウント方法をサポートします
            return new BigDecimal(valueStr.trim()).longValue();
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するlong<br>
     * 与えられた値がある場合<code>null</code>，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Long toLong(Object value)
    {
        return toLong(value, null);
    }

    /**
     * 変換するdouble<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Double toDouble(Object value, Double defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Double)
        {
            return (Double) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).doubleValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            // 科学カウント方法をサポートします
            return new BigDecimal(valueStr.trim()).doubleValue();
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するdouble<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Double toDouble(Object value)
    {
        return toDouble(value, null);
    }

    /**
     * 変換するFloat<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Float toFloat(Object value, Float defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Float)
        {
            return (Float) value;
        }
        if (value instanceof Number)
        {
            return ((Number) value).floatValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Float.parseFloat(valueStr.trim());
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するFloat<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Float toFloat(Object value)
    {
        return toFloat(value, null);
    }

    /**
     * 変換するboolean<br>
     * Stringサポート値はです：true、false、yes、ok、no，1,0 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static Boolean toBool(Object value, Boolean defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof Boolean)
        {
            return (Boolean) value;
        }
        String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        valueStr = valueStr.trim().toLowerCase();
        switch (valueStr)
        {
            case "true":
            case "yes":
            case "ok":
            case "1":
                return true;
            case "false":
            case "no":
            case "0":
                return false;
            default:
                return defaultValue;
        }
    }

    /**
     * 変換するboolean<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static Boolean toBool(Object value)
    {
        return toBool(value, null);
    }

    /**
     * 変換するEnum物体<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     *
     * @param clazz EnumのClass
     * @param value 価値
     * @param defaultValue 默认価値
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value, E defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (clazz.isAssignableFrom(value.getClass()))
        {
            @SuppressWarnings("unchecked")
            E myE = (E) value;
            return myE;
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return Enum.valueOf(clazz, valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するEnum物体<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     *
     * @param clazz EnumのClass
     * @param value 価値
     * @return Enum
     */
    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value)
    {
        return toEnum(clazz, value, null);
    }

    /**
     * 変換するBigInteger<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static BigInteger toBigInteger(Object value, BigInteger defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof BigInteger)
        {
            return (BigInteger) value;
        }
        if (value instanceof Long)
        {
            return BigInteger.valueOf((Long) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return new BigInteger(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するBigInteger<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<code>null</code><br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static BigInteger toBigInteger(Object value)
    {
        return toBigInteger(value, null);
    }

    /**
     * 変換するBigDecimal<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @param defaultValue 変換エラー時のデフォルト値
     * @return 結果
     */
    public static BigDecimal toBigDecimal(Object value, BigDecimal defaultValue)
    {
        if (value == null)
        {
            return defaultValue;
        }
        if (value instanceof BigDecimal)
        {
            return (BigDecimal) value;
        }
        if (value instanceof Long)
        {
            return new BigDecimal((Long) value);
        }
        if (value instanceof Double)
        {
            return BigDecimal.valueOf((Double) value);
        }
        if (value instanceof Integer)
        {
            return new BigDecimal((Integer) value);
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isEmpty(valueStr))
        {
            return defaultValue;
        }
        try
        {
            return new BigDecimal(valueStr);
        }
        catch (Exception e)
        {
            return defaultValue;
        }
    }

    /**
     * 変換するBigDecimal<br>
     * 与えられた値がある場合空，または変換が失敗しました，沈黙に戻ります<br>
     * 変換障害はエラーを報告しません
     *
     * @param value 変換された値
     * @return 結果
     */
    public static BigDecimal toBigDecimal(Object value)
    {
        return toBigDecimal(value, null);
    }

    /**
     * 意思物体转为弦<br>
     * 1、Byte配列和ByteBuffer会被変換する对应弦の配列 2、物体配列会调用Arrays.toString方法
     *
     * @param obj 物体
     * @return 弦
     */
    public static String utf8Str(Object obj)
    {
        return str(obj, CharsetKit.CHARSET_UTF_8);
    }

    /**
     * 意思物体转为弦<br>
     * 1、Byte配列和ByteBuffer会被変換する对应弦の配列 2、物体配列会调用Arrays.toString方法
     *
     * @param obj 物体
     * @param charsetName キャラクターセット
     * @return 弦
     */
    public static String str(Object obj, String charsetName)
    {
        return str(obj, Charset.forName(charsetName));
    }

    /**
     * 意思物体转为弦<br>
     * 1、Byte配列和ByteBuffer会被変換する对应弦の配列 2、物体配列会调用Arrays.toString方法
     *
     * @param obj 物体
     * @param charset キャラクターセット
     * @return 弦
     */
    public static String str(Object obj, Charset charset)
    {
        if (null == obj)
        {
            return null;
        }

        if (obj instanceof String)
        {
            return (String) obj;
        }
        else if (obj instanceof byte[])
        {
            return str((byte[]) obj, charset);
        }
        else if (obj instanceof Byte[])
        {
            byte[] bytes = ArrayUtils.toPrimitive((Byte[]) obj);
            return str(bytes, charset);
        }
        else if (obj instanceof ByteBuffer)
        {
            return str((ByteBuffer) obj, charset);
        }
        return obj.toString();
    }

    /**
     * 意思byte配列转为弦
     *
     * @param bytes byte配列
     * @param charset キャラクターセット
     * @return 弦
     */
    public static String str(byte[] bytes, String charset)
    {
        return str(bytes, StringUtils.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset));
    }

    /**
     * バイトコードのデコード
     *
     * @param data 弦
     * @param charset キャラクターセット，このフィールドが空の場合，则解码の結果取决于平台
     * @return 解码后の弦
     */
    public static String str(byte[] data, Charset charset)
    {
        if (data == null)
        {
            return null;
        }

        if (null == charset)
        {
            return new String(data);
        }
        return new String(data, charset);
    }

    /**
     * 意思编码のbyteBufferデータ文字列に変換されました
     *
     * @param data データ
     * @param charset キャラクターセット，如果为空使用当前系统キャラクターセット
     * @return 弦
     */
    public static String str(ByteBuffer data, String charset)
    {
        if (data == null)
        {
            return null;
        }

        return str(data, Charset.forName(charset));
    }

    /**
     * 意思编码のbyteBufferデータ文字列に変換されました
     *
     * @param data データ
     * @param charset キャラクターセット，如果为空使用当前系统キャラクターセット
     * @return 弦
     */
    public static String str(ByteBuffer data, Charset charset)
    {
        if (null == charset)
        {
            charset = Charset.defaultCharset();
        }
        return charset.decode(data).toString();
    }

    // ----------------------------------------------------------------------- フルアングルハーフ - ホーン度変換
    /**
     * 半ポイント - 丸い
     *
     * @param input String.
     * @return 全ホーン弦.
     */
    public static String toSBC(String input)
    {
        return toSBC(input, null);
    }

    /**
     * 半ポイント - 丸い
     *
     * @param input String
     * @param notConvertSet 不替换のキャラクターセット合
     * @return 全ホーン弦.
     */
    public static String toSBC(String input, Set<Character> notConvertSet)
    {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (null != notConvertSet && notConvertSet.contains(c[i]))
            {
                // 跳过不替换の字符
                continue;
            }

            if (c[i] == ' ')
            {
                c[i] = '\u3000';
            }
            else if (c[i] < '\177')
            {
                c[i] = (char) (c[i] + 65248);

            }
        }
        return new String(c);
    }

    /**
     * フルアングルターニングハーフキューブ
     *
     * @param input String.
     * @return 半ホーン弦
     */
    public static String toDBC(String input)
    {
        return toDBC(input, null);
    }

    /**
     * フルアングルを半ポイントの穴として交換します
     *
     * @param text 文章
     * @param notConvertSet 不替换のキャラクターセット合
     * @return 替换后の字符
     */
    public static String toDBC(String text, Set<Character> notConvertSet)
    {
        char[] c = text.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (null != notConvertSet && notConvertSet.contains(c[i]))
            {
                // 跳过不替换の字符
                continue;
            }

            if (c[i] == '\u3000')
            {
                c[i] = ' ';
            }
            else if (c[i] > '\uFF00' && c[i] < '\uFF5F')
            {
                c[i] = (char) (c[i] - 65248);
            }
        }
        String returnString = new String(c);

        return returnString;
    }

    /**
     * デジタル量変換 先写个完全ての然后意思如ゼロ拾替换成ゼロ
     *
     * @param n 番号
     * @return 中文大写番号
     */
    public static String digitUppercase(double n)
    {
        String[] fraction = { "ホーン", "ポイント" };
        String[] digit = { "ゼロ", "1つ", "二", "三つ", "抑制されていない", "なれ", "土地", "傀儡", "八", "傀儡" };
        String[][] unit = { { "元", "万", "1億" }, { "", "拾", "超えて", "千" } };

        String head = n < 0 ? "重荷" : "";
        n = Math.abs(n);

        String s = "";
        for (int i = 0; i < fraction.length; i++)
        {
            // 最適化double計算精度損失の問題
            BigDecimal nNum = new BigDecimal(n);
            BigDecimal decimal = new BigDecimal(10);
            BigDecimal scale = nNum.multiply(decimal).setScale(2, RoundingMode.HALF_EVEN);
            double d = scale.doubleValue();
            s += (digit[(int) (Math.floor(d * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(ゼロ.)+", "");
        }
        if (s.length() < 1)
        {
            s = "全て";
        }
        int integerPart = (int) Math.floor(n);

        for (int i = 0; i < unit[0].length && integerPart > 0; i++)
        {
            String p = "";
            for (int j = 0; j < unit[1].length && n > 0; j++)
            {
                p = digit[integerPart % 10] + unit[1][j] + p;
                integerPart = integerPart / 10;
            }
            s = p.replaceAll("(ゼロ.)*ゼロ$", "").replaceAll("^$", "ゼロ") + unit[0][i] + s;
        }
        return head + s.replaceAll("(ゼロ.)*ゼロ元", "元").replaceFirst("(ゼロ.)+", "").replaceAll("(ゼロ.)+", "ゼロ").replaceAll("^全て$", "ゼロ元全て");
    }
}

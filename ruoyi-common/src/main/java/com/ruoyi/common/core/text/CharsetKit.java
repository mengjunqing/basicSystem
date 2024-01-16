package com.ruoyi.common.core.text;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import com.ruoyi.common.utils.StringUtils;

/**
 * 文字セットツール
 * 
 * @author ruoyi
 */
public class CharsetKit
{
    /** ISO-8859-1 */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /** UTF-8 */
    public static final String UTF_8 = "UTF-8";
    /** GBK */
    public static final String GBK = "GBK";

    /** ISO-8859-1 */
    public static final Charset CHARSET_ISO_8859_1 = Charset.forName(ISO_8859_1);
    /** UTF-8 */
    public static final Charset CHARSET_UTF_8 = Charset.forName(UTF_8);
    /** GBK */
    public static final Charset CHARSET_GBK = Charset.forName(GBK);

    /**
     * 変換するCharset物体
     * 
     * @param charset キャラクターセット，为空则返回デフォルトキャラクターセット
     * @return Charset
     */
    public static Charset charset(String charset)
    {
        return StringUtils.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset);
    }

    /**
     * 转换弦的キャラクターセット编码
     * 
     * @param source 弦
     * @param srcCharset 源キャラクターセット，デフォルトISO-8859-1
     * @param destCharset 目标キャラクターセット，デフォルトUTF-8
     * @return 转换后的キャラクターセット
     */
    public static String convert(String source, String srcCharset, String destCharset)
    {
        return convert(source, Charset.forName(srcCharset), Charset.forName(destCharset));
    }

    /**
     * 转换弦的キャラクターセット编码
     * 
     * @param source 弦
     * @param srcCharset 源キャラクターセット，デフォルトISO-8859-1
     * @param destCharset 目标キャラクターセット，デフォルトUTF-8
     * @return 转换后的キャラクターセット
     */
    public static String convert(String source, Charset srcCharset, Charset destCharset)
    {
        if (null == srcCharset)
        {
            srcCharset = StandardCharsets.ISO_8859_1;
        }

        if (null == destCharset)
        {
            destCharset = StandardCharsets.UTF_8;
        }

        if (StringUtils.isEmpty(source) || srcCharset.equals(destCharset))
        {
            return source;
        }
        return new String(source.getBytes(srcCharset), destCharset);
    }

    /**
     * @return 系统キャラクターセット编码
     */
    public static String systemCharset()
    {
        return Charset.defaultCharset().name();
    }
}

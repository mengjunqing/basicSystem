package com.ruoyi.common.utils.uuid;

import java.util.concurrent.atomic.AtomicInteger;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;

/**
 * @author ruoyi シーケンス生成クラス
 */
public class Seq
{
    // ユニバーサルシーケンスタイプ
    public static final String commSeqType = "COMMON";

    // シーケンスタイプをアップロードします
    public static final String uploadSeqType = "UPLOAD";

    // ユニバーサルインターフェイスシーケンス番号
    private static AtomicInteger commSeq = new AtomicInteger(1);

    // インターフェイスシーケンス番号をアップロードします
    private static AtomicInteger uploadSeq = new AtomicInteger(1);

    // マシンのロゴ
    private static final String machineCode = "A";

    /**
     * 一般のなシリアル番号を取得します
     * 
     * @return シリアル値
     */
    public static String getId()
    {
        return getId(commSeqType);
    }
    
    /**
     * デフォルト16シーケンス番号 yyMMddHHmmss + 一位マシンのロゴ + 3永久にループ文字列
     * 
     * @return シリアル値
     */
    public static String getId(String type)
    {
        AtomicInteger atomicInt = commSeq;
        if (uploadSeqType.equals(type))
        {
            atomicInt = uploadSeq;
        }
        return getId(atomicInt, 3);
    }

    /**
     * ユニバーサルインターフェイスシリアル番号 yyMMddHHmmss + 一位マシンのロゴ + length永久にループ文字列
     * 
     * @param atomicInt 序列数
     * @param length 数値
     * @return シリアル値
     */
    public static String getId(AtomicInteger atomicInt, int length)
    {
        String result = DateUtils.dateTimeNow();
        result += machineCode;
        result += getSeq(atomicInt, length);
        return result;
    }

    /**
     * 文字列を追加するシーケンスサイクル[1, 10 の (length)幂次方), 使使用0Zuo Buqilengthデジタル番号
     * 
     * @return シリアル値
     */
    private synchronized static String getSeq(AtomicInteger atomicInt, int length)
    {
        // 最初に値を取ります+1
        int value = atomicInt.getAndIncrement();

        // 値の場合>=10 の (length)パワーのパワーがリセットされます1
        int maxSeq = (int) Math.pow(10, length);
        if (atomicInt.get() >= maxSeq)
        {
            atomicInt.set(1);
        }
        // ローター文字列，使使用0Zuo Buqi
        return StringUtils.padl(value, length);
    }
}

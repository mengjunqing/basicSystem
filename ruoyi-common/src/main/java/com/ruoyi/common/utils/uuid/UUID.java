package com.ruoyi.common.utils.uuid;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.ruoyi.common.exception.UtilException;

/**
 * 一意の識別コードを提供します（universally unique identifier）（UUID）成し遂げる
 *
 * @author ruoyi
 */
public final class UUID implements java.io.Serializable, Comparable<UUID>
{
    private static final long serialVersionUID = -1185015143654744140L;

    /**
     * SecureRandom 単一の例
     *
     */
    private static class Holder
    {
        static final SecureRandom numberGenerator = getSecureRandom();
    }

    /** これUUID最高64効果のな少し置 */
    private final long mostSigBits;

    /** これUUID最小64効果のな少し置 */
    private final long leastSigBits;

    /**
     * プライベート構造
     * 
     * @param data データ
     */
    private UUID(byte[] data)
    {
        long msb = 0;
        long lsb = 0;
        assert data.length == 16 : "data must be 16 bytes in length";
        for (int i = 0; i < 8; i++)
        {
            msb = (msb << 8) | (data[i] & 0xff);
        }
        for (int i = 8; i < 16; i++)
        {
            lsb = (lsb << 8) | (data[i] & 0xff);
        }
        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    /**
     * 使用指定のデータ构造新の UUID。
     *
     * @param mostSigBits のために {@code UUID} 最高有效 64 少し
     * @param leastSigBits のために {@code UUID} 最小有效 64 少し
     */
    public UUID(long mostSigBits, long leastSigBits)
    {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
    }

    /**
     * 取得 4（擬似ランダム）UUID 静の工場。
     * 
     * @return ランダム {@code UUID}
     */
    public static UUID fastUUID()
    {
        return randomUUID(false);
    }

    /**
     * 取得 4（擬似ランダム）UUID 静の工場。 暗号化された強力な擬似ランダム番号ジェネレーターを使用してこれを生成します UUID。
     * 
     * @return ランダム {@code UUID}
     */
    public static UUID randomUUID()
    {
        return randomUUID(true);
    }

    /**
     * 取得 4（擬似ランダム）UUID 静の工場。 暗号化された強力な擬似ランダム番号ジェネレーターを使用してこれを生成します UUID。
     * 
     * @param isSecure 使用するかどうか{@link SecureRandom}より安全性なランダムコードを取得できる場合，それ以外の場合は、より良いパフォーマンスを得ることができます
     * @return ランダム {@code UUID}
     */
    public static UUID randomUUID(boolean isSecure)
    {
        final Random ng = isSecure ? Holder.numberGenerator : getRandom();

        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f; /* clear version */
        randomBytes[6] |= 0x40; /* set to version 4 */
        randomBytes[8] &= 0x3f; /* clear variant */
        randomBytes[8] |= 0x80; /* set to IETF variant */
        return new UUID(randomBytes);
    }

    /**
     * によると指定バイト配列取得 3（名前が付けられました）UUID 静の工場。
     *
     * @param name のために构造 UUID バイト配列。
     *
     * @return 指定された配列に従って生成します {@code UUID}
     */
    public static UUID nameUUIDFromBytes(byte[] name)
    {
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException nsae)
        {
            throw new InternalError("MD5 not supported");
        }
        byte[] md5Bytes = md.digest(name);
        md5Bytes[6] &= 0x0f; /* clear version */
        md5Bytes[6] |= 0x30; /* set to version 3 */
        md5Bytes[8] &= 0x3f; /* clear variant */
        md5Bytes[8] |= 0x80; /* set to IETF variant */
        return new UUID(md5Bytes);
    }

    /**
     * によると {@link #toString()} フォーム表現の形式で説明されている方法文字列標準{@code UUID}。
     *
     * @param name 指定 {@code UUID} 弦
     * @return 指定された値で {@code UUID}
     * @throws IllegalArgumentException もし name そして {@link #toString} 中説明するの弦表示形式不符抛出これ异常
     *
     */
    public static UUID fromString(String name)
    {
        String[] components = name.split("-");
        if (components.length != 5)
        {
            throw new IllegalArgumentException("Invalid UUID string: " + name);
        }
        for (int i = 0; i < 5; i++)
        {
            components[i] = "0x" + components[i];
        }

        long mostSigBits = Long.decode(components[0]).longValue();
        mostSigBits <<= 16;
        mostSigBits |= Long.decode(components[1]).longValue();
        mostSigBits <<= 16;
        mostSigBits |= Long.decode(components[2]).longValue();

        long leastSigBits = Long.decode(components[3]).longValue();
        leastSigBits <<= 48;
        leastSigBits |= Long.decode(components[4]).longValue();

        return new UUID(mostSigBits, leastSigBits);
    }

    /**
     * 返回これ UUID の 128 少し価値中最小有效 64 少し。
     *
     * @return これ UUID の 128 少し価値中最小有效 64 少し。
     */
    public long getLeastSignificantBits()
    {
        return leastSigBits;
    }

    /**
     * 返回これ UUID の 128 少し価値中最高有效 64 少し。
     *
     * @return これ UUID の 128 少し価値中最高有效 64 少し。
     */
    public long getMostSignificantBits()
    {
        return mostSigBits;
    }

    /**
     * そしてこれ {@code UUID} 相关联のバージョン号. バージョン号説明するこれ {@code UUID} はい如何生成の。
     * <p>
     * バージョン番号には次の意味があります:
     * <ul>
     * <li>1 基于時間间の UUID
     * <li>2 DCE 安全性 UUID
     * <li>3 名前が付けられました UUID
     * <li>4 ランダム UUID
     * </ul>
     *
     * @return これ {@code UUID} のバージョン号
     */
    public int version()
    {
        // Version is bits masked by 0x000000000000F000 in MS long
        return (int) ((mostSigBits >> 12) & 0x0f);
    }

    /**
     * そしてこれ {@code UUID} 相关联の变体号。バリアント番号の説明 {@code UUID} の布局。
     * <p>
     * バリアントには次の意味があります：
     * <ul>
     * <li>0 のために NCS 後方互換性と互換性があります
     * <li>2 <a href="http://www.ietf.org/rfc/rfc4122.txt">IETF&nbsp;RFC&nbsp;4122</a>(Leach-Salz), のためにこれ类
     * <li>6 予約する，Microsoftは互換性に戻ります
     * <li>7 予約する供以后定义使用
     * </ul>
     *
     * @return これ {@code UUID} 相关联の变体号
     */
    public int variant()
    {
        // This field is composed of a varying number of bits.
        // 0 - - Reserved for NCS backward compatibility
        // 1 0 - The IETF aka Leach-Salz variant (used by this class)
        // 1 1 0 Reserved, Microsoft backward compatibility
        // 1 1 1 Reserved for future definition.
        return (int) ((leastSigBits >>> (64 - (leastSigBits >>> 62))) & (leastSigBits >> 63));
    }

    /**
     * そしてこれ UUID 相关联の時間间戳価値。
     *
     * <p>
     * 60 少しの時間间戳価値によるとこれ {@code UUID} の time_low、time_mid そして time_hi フィールド構造。<br>
     * 所得到の時間间戳以 100 毫微秒のために单少し，から UTC（GM調整時間） 1582 年 10 月 15 ゼロから始めます。
     *
     * <p>
     * 時間间戳価値仅在在基于時間间の UUID（それ version 类型のために 1）中間の才能は意味があります。<br>
     * もしこれ {@code UUID} いいえ基于時間间の UUID，则これ方法抛出 UnsupportedOperationException。
     *
     * @throws UnsupportedOperationException もしこれ {@code UUID} いいえ version のために 1 の UUID。
     */
    public long timestamp() throws UnsupportedOperationException
    {
        checkTimeBase();
        return (mostSigBits & 0x0FFFL) << 48//
                | ((mostSigBits >> 16) & 0x0FFFFL) << 32//
                | mostSigBits >>> 32;
    }

    /**
     * そしてこれ UUID 相关联の時間钟序列価値。
     *
     * <p>
     * 14 少しの時間钟序列価値によるとこれ UUID の clock_seq フィールド構造。clock_seq 字段のために保证在基于時間间の UUID 中の時間间唯一性。
     * <p>
     * {@code clockSequence} 価値仅在基于時間间の UUID（それ version 类型のために 1）中間の才能は意味があります。 もしこれ UUID いいえ基于時間间の UUID，则これ方法抛出
     * UnsupportedOperationException。
     *
     * @return これ {@code UUID} の時間钟序列
     *
     * @throws UnsupportedOperationException もしこれ UUID の version 不のために 1
     */
    public int clockSequence() throws UnsupportedOperationException
    {
        checkTimeBase();
        return (int) ((leastSigBits & 0x3FFF000000000000L) >>> 48);
    }

    /**
     * そしてこれ UUID 相关の节点価値。
     *
     * <p>
     * 48 少しの节点価値によるとこれ UUID の node フィールド構造。これ字段旨在のために保存机器の IEEE 802 住所，该住所のために生成これ UUID 空間の独自性を確保するため。
     * <p>
     * 节点価値仅在基于時間间の UUID（それ version 类型のために 1）中間の才能は意味があります。<br>
     * もしこれ UUID いいえ基于時間间の UUID，则これ方法抛出 UnsupportedOperationException。
     *
     * @return これ {@code UUID} の节点価値
     *
     * @throws UnsupportedOperationException もしこれ UUID の version 不のために 1
     */
    public long node() throws UnsupportedOperationException
    {
        checkTimeBase();
        return leastSigBits & 0x0000FFFFFFFFFFFFL;
    }

    /**
     * 返回これ{@code UUID} の弦表现形式。
     *
     * <p>
     * UUID の弦表示形式由これ BNF 説明する：
     * 
     * <pre>
     * {@code
     * UUID                   = <time_low>-<time_mid>-<time_high_and_version>-<variant_and_sequence>-<node>
     * time_low               = 4*<hexOctet>
     * time_mid               = 2*<hexOctet>
     * time_high_and_version  = 2*<hexOctet>
     * variant_and_sequence   = 2*<hexOctet>
     * node                   = 6*<hexOctet>
     * hexOctet               = <hexDigit><hexDigit>
     * hexDigit               = [0-9a-fA-F]
     * }
     * </pre>
     * 
     * </blockquote>
     *
     * @return これ{@code UUID} の弦表现形式
     * @see #toString(boolean)
     */
    @Override
    public String toString()
    {
        return toString(false);
    }

    /**
     * 返回これ{@code UUID} の弦表现形式。
     *
     * <p>
     * UUID の弦表示形式由これ BNF 説明する：
     * 
     * <pre>
     * {@code
     * UUID                   = <time_low>-<time_mid>-<time_high_and_version>-<variant_and_sequence>-<node>
     * time_low               = 4*<hexOctet>
     * time_mid               = 2*<hexOctet>
     * time_high_and_version  = 2*<hexOctet>
     * variant_and_sequence   = 2*<hexOctet>
     * node                   = 6*<hexOctet>
     * hexOctet               = <hexDigit><hexDigit>
     * hexDigit               = [0-9a-fA-F]
     * }
     * </pre>
     * 
     * </blockquote>
     *
     * @param isSimple 簡単なモードですか，简单模式のために不带'-'のUUID弦
     * @return これ{@code UUID} の弦表现形式
     */
    public String toString(boolean isSimple)
    {
        final StringBuilder builder = new StringBuilder(isSimple ? 32 : 36);
        // time_low
        builder.append(digits(mostSigBits >> 32, 8));
        if (!isSimple)
        {
            builder.append('-');
        }
        // time_mid
        builder.append(digits(mostSigBits >> 16, 4));
        if (!isSimple)
        {
            builder.append('-');
        }
        // time_high_and_version
        builder.append(digits(mostSigBits, 4));
        if (!isSimple)
        {
            builder.append('-');
        }
        // variant_and_sequence
        builder.append(digits(leastSigBits >> 48, 4));
        if (!isSimple)
        {
            builder.append('-');
        }
        // node
        builder.append(digits(leastSigBits, 12));

        return builder.toString();
    }

    /**
     * 返回これ UUID の哈希码。
     *
     * @return UUID の哈希码価値。
     */
    @Override
    public int hashCode()
    {
        long hilo = mostSigBits ^ leastSigBits;
        return ((int) (hilo >> 32)) ^ (int) hilo;
    }

    /**
     * 将これ物体そして指定物体比較する。
     * <p>
     * 当且仅当参数不のために {@code null}、それは UUID 物体、具有そしてこれ UUID 相同の varriant、包含相同の価値（每一少し均相同）時間，结果才のために {@code true}。
     *
     * @param obj 要そして之比較するの物体
     *
     * @return もし物体相同，その後、返します {@code true}；否その後、返します {@code false}
     */
    @Override
    public boolean equals(Object obj)
    {
        if ((null == obj) || (obj.getClass() != UUID.class))
        {
            return false;
        }
        UUID id = (UUID) obj;
        return (mostSigBits == id.mostSigBits && leastSigBits == id.leastSigBits);
    }

    // Comparison Operations

    /**
     * 将これ UUID そして指定の UUID 比較する。
     *
     * <p>
     * もし两个 UUID 違う，初め UUID 最高有效字段2番目よりも大きい UUID の对应字段，最初の1つ UUID 2番目よりも大きい UUID。
     *
     * @param val そしてこれ UUID 比較するの UUID
     *
     * @return 在これ UUID 未満、等于または大于 val 時間，別 -1、0 または 1。
     *
     */
    @Override
    public int compareTo(UUID val)
    {
        // The ordering is intentionally set up so that the UUIDs
        // can simply be numerically compared as two numbers
        return (this.mostSigBits < val.mostSigBits ? -1 : //
                (this.mostSigBits > val.mostSigBits ? 1 : //
                        (this.leastSigBits < val.leastSigBits ? -1 : //
                                (this.leastSigBits > val.leastSigBits ? 1 : //
                                        0))));
    }

    // -------------------------------------------------------------------------------------------------------------------
    // Private method start
    /**
     * 返回指定数字对应のhex価値
     * 
     * @param val 価値
     * @param digits 少し
     * @return 価値
     */
    private static String digits(long val, int digits)
    {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }

    /**
     * 检查はい否のためにtime-basedバージョンUUID
     */
    private void checkTimeBase()
    {
        if (version() != 1)
        {
            throw new UnsupportedOperationException("Not a time-based UUID");
        }
    }

    /**
     * 得る{@link SecureRandom}，类提供加密の强随机数生成器 (RNG)
     * 
     * @return {@link SecureRandom}
     */
    public static SecureRandom getSecureRandom()
    {
        try
        {
            return SecureRandom.getInstance("SHA1PRNG");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new UtilException(e);
        }
    }

    /**
     * 得る随机数生成器物体<br>
     * ThreadLocalRandomはいJDK 7乱数を生成するために同時数が提供された後，能够解决多个线程发生の竞争争夺。
     * 
     * @return {@link ThreadLocalRandom}
     */
    public static ThreadLocalRandom getRandom()
    {
        return ThreadLocalRandom.current();
    }
}

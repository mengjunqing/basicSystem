package com.ruoyi.common.utils.uuid;

/**
 * IDジェネレーターツール
 * 
 * @author ruoyi
 */
public class IdUtils
{
    /**
     * ランダムになりますUUID
     * 
     * @return ランダムUUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * 簡素化UUID，水平線を取り外します
     * 
     * @return 簡素化UUID，水平線を取り外します
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }

    /**
     * ランダムになりますUUID，より良い使用ThreadLocalRandom生成するするUUID
     * 
     * @return ランダムUUID
     */
    public static String fastUUID()
    {
        return UUID.fastUUID().toString();
    }

    /**
     * 簡素化UUID，水平線を取り外します，より良い使用ThreadLocalRandom生成するするUUID
     * 
     * @return 簡素化UUID，水平線を取り外します
     */
    public static String fastSimpleUUID()
    {
        return UUID.fastUUID().toString(true);
    }
}

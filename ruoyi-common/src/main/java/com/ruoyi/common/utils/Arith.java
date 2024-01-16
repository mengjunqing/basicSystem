package com.ruoyi.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 正確なフローティング - ポイント番号操作
 * 
 * @author ruoyi
 */
public class Arith
{

    /** 計算精度のデフォルトの削除 */
    private static final int DEF_DIV_SCALE = 10;

    /** このクラスをインスタンス化することはできません */
    private Arith()
    {
    }

    /**
     * 正確な追加操作を供給します。
     * @param v1 追加されます
     * @param v2 増加
     * @return 2つのパラメーターと
     */
    public static double add(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 正確な減算操作を供給します。
     * @param v1 減らす
     * @param v2 劣化
     * @return 2つのパラメーターの違い
     */
    public static double sub(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 正確な乗算操作を供給します。
     * @param v1 番号
     * @param v2 乗数
     * @return 2つのパラメーターの蓄積
     */
    public static double mul(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 供給（比較的）正確な削除操作，無限の状況があるとき，正確です
     * 小数点の後10少し，将来の数に続きます。
     * @param v1 分ける
     * @param v2 除数
     * @return 2つのパラメーターのビジネス
     */
    public static double div(double v1, double v2)
    {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 供給（比較的）正確な削除操作。無限の状況があるとき，によるscaleパラメーター指
     * 定精度，将来の数に続きます。
     * @param v1 分ける
     * @param v2 除数
     * @param scale 表示表示需要正確です小数点の後几少し。
     * @return 2つのパラメーターのビジネス
     */
    public static double div(double v1, double v2, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        if (b1.compareTo(BigDecimal.ZERO) == 0)
        {
            return BigDecimal.ZERO.doubleValue();
        }
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 供給精确的小数少し四舍五入处理。
     * @param v 4つの家と5つのエントリが必要な数字
     * @param scale 小数点后保留几少し
     * @return 4つの家と5つの家の結果
     */
    public static double round(double v, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = BigDecimal.ONE;
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }
}

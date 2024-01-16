package com.ruoyi.quartz.util;

import java.text.ParseException;
import java.util.Date;
import org.quartz.CronExpression;

/**
 * cronパフォーマンスツール
 * 
 * @author ruoyi
 *
 */
public class CronUtils
{
    /**
     * バックブール値は与えられたものを表しますCronパフォーマンスの有効性
     *
     * @param cronExpression Cronパフォーマンス
     * @return boolean パフォーマンス是否有效
     */
    public static boolean isValid(String cronExpression)
    {
        return CronExpression.isValidExpression(cronExpression);
    }

    /**
     * 文字列値を返します,それは、ニュースが無効であることを意味しますCronパフォーマンス给出有效性
     *
     * @param cronExpression Cronパフォーマンス
     * @return String 无效时返回パフォーマンス错误描述,効果的に戻る場合null
     */
    public static String getInvalidMessage(String cronExpression)
    {
        try
        {
            new CronExpression(cronExpression);
            return null;
        }
        catch (ParseException pe)
        {
            return pe.getMessage();
        }
    }

    /**
     * 指定に従って次の実行時間を返しますCronパフォーマンス
     *
     * @param cronExpression Cronパフォーマンス
     * @return Date 次回Cronパフォーマンス执行时间
     */
    public static Date getNextExecution(String cronExpression)
    {
        try
        {
            CronExpression cron = new CronExpression(cronExpression);
            return cron.getNextValidTimeAfter(new Date(System.currentTimeMillis()));
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}

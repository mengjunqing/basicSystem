package com.ruoyi.common.constant;

/**
 * ユニバーサル定数のスケジューリング
 * 
 * @author ruoyi
 */
public class ScheduleConstants
{
    public static final String TASK_CLASS_NAME = "TASK_CLASS_NAME";

    /** 目標を実行しますkey */
    public static final String TASK_PROPERTIES = "TASK_PROPERTIES";

    /** デフォルト */
    public static final String MISFIRE_DEFAULT = "0";

    /** 即時トリガー実行 */
    public static final String MISFIRE_IGNORE_MISFIRES = "1";

    /** 1つの実行をトリガーします */
    public static final String MISFIRE_FIRE_AND_PROCEED = "2";

    /** トリガーせずにすぐに実行します */
    public static final String MISFIRE_DO_NOTHING = "3";

    public enum Status
    {
        /**
         * 普通
         */
        NORMAL("0"),
        /**
         * 一時停止
         */
        PAUSE("1");

        private String value;

        private Status(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }
    }
}

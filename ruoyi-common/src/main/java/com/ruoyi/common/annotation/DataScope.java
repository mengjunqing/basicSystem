package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * データ許可フィルタリング
 * 
 * @author ruoyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * 部門テーブルのエイリアス
     */
    public String deptAlias() default "";

    /**
     * ユーザーウォッチのエイリアス
     */
    public String userAlias() default "";

    /**
     * 寛容な性格（要件の要件に一致する複数の文字に使用）許可注釈に従ってデフォルト@ss得る，複数の権限はコンマによって分離されます
     */
    public String permission() default "";
}

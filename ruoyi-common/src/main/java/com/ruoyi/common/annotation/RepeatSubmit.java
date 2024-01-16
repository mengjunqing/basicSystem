package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * フォームの繰り返しの提出を防ぐために、注釈をカスタマイズします
 * 
 * @author ruoyi
 *
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit
{
    /**
     * 間隔(ms)，これよりも小さく、繰り返し提出されるとみなされます
     */
    public int interval() default 5000;

    /**
     * 迅速なメッセージ
     */
    public String message() default "繰り返し提出は許可されていません，もう一度やり直してください";
}

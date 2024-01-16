package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.enums.LimitType;

/**
 * 制限された注釈
 * 
 * @author ruoyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter
{
    /**
     * 制限key
     */
    public String key() default CacheConstants.RATE_LIMIT_KEY;

    /**
     * 時間を制限します,ユニットセカンド
     */
    public int time() default 60;

    /**
     * 制限次数
     */
    public int count() default 100;

    /**
     * 制限されたタイプ
     */
    public LimitType limitType() default LimitType.DEFAULT;
}

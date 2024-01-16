package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.OperatorType;

/**
 * カスタム操作ログ記録注釈
 * 
 * @author ruoyi
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /**
     * モジュール
     */
    public String title() default "";

    /**
     * 関数
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 人間
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * リクエストパラメーターを保存するかどうか
     */
    public boolean isSaveRequestData() default true;

    /**
     * 応答パラメーターを保存するかどうか
     */
    public boolean isSaveResponseData() default true;

    /**
     * 指定された要求パラメーターを除外します
     */
    public String[] excludeParamNames() default {};
}

package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ruoyi.common.enums.DataSourceType;

/**
 * データの切り替えノートのほとんどをカスタマイズします
 *
 * 優先度：最初の方法，后类，メソッドがクラスのデータソースタイプをカバーする場合，勝つ，それ以外の場合、クラスが勝ちます
 *
 * @author ruoyi
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource
{
    /**
     * データソース名を切り替えます
     */
    public DataSourceType value() default DataSourceType.MASTER;
}

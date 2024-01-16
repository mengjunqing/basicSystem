package com.ruoyi.framework.config;

import java.util.TimeZone;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Program annotation configuration
 *
 * @author ruoyi
 */
@Configuration
// 採用するaopフレームワークはプロキシオブジェクトを公開します,AopContextアクセスできる
@EnableAspectJAutoProxy(exposeProxy = true)
// スキャンに指定しますMapperクラスバッグのパス
@MapperScan("com.ruoyi.**.mapper")
public class ApplicationConfig
{
    /**
     * タイムゾーンの構成
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization()
    {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
    }
}

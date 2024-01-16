package com.ruoyi.framework.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * druid 構成属性
 * 
 * @author ruoyi
 */
@Configuration
public class DruidProperties
{
    @Value("${spring.datasource.druid.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.druid.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.druid.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.druid.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.druid.connectTimeout}")
    private int connectTimeout;

    @Value("${spring.datasource.druid.socketTimeout}")
    private int socketTimeout;

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.maxEvictableIdleTimeMillis}")
    private int maxEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn;

    public DruidDataSource dataSource(DruidDataSource datasource)
    {
        /** 早い時期、最小、最大 */
        datasource.setInitialSize(initialSize);
        datasource.setMaxActive(maxActive);
        datasource.setMinIdle(minIdle);

        /** 接続待機タイムアウト時間を取得する構成 */
        datasource.setMaxWait(maxWait);
        
        /** ドライバー接続タイムアウト時間を構成します，データベースを検出して、接続タイムアウト時間を確立します，ユニットはミリ秒です */
        datasource.setConnectTimeout(connectTimeout);
        
        /** ネットワークタイムアウト時間を構成します，データベース操作がネットワークタイムアウト時間を完了するのを待っています，ユニットはミリ秒です */
        datasource.setSocketTimeout(socketTimeout);

        /** テスト前の構成間隔はどのくらいですか，閉じる必要があるアイドル接続をテストします，ユニットはミリ秒です */
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        /** プール内の最小接続を構成します、生き残るための最大時間，ユニットはミリ秒です */
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);

        /**
         * 接続が効果的かどうかを検出するために使用されますsql，リクエストはクエリステートメントです，一般的に使用されますselect 'x'。もしvalidationQueryのためにnull，testOnBorrow、testOnReturn、testWhileIdle何も機能しません。
         */
        datasource.setValidationQuery(validationQuery);
        /** 建议配置のためにtrue，パフォーマンスに影響を与えません，安全を確保します。接続を申請するときにテストします，もし空闲时间大于timeBetweenEvictionRunsMillis，埋め込むvalidationQuery接続が効果的かどうかを検出します。 */
        datasource.setTestWhileIdle(testWhileIdle);
        /** 申请连接时埋め込むvalidationQuery接続が効果的かどうかを検出します，この構成を行うと、パフォーマンスが低下します。 */
        datasource.setTestOnBorrow(testOnBorrow);
        /** 归还连接时埋め込むvalidationQuery接続が効果的かどうかを検出します，この構成を行うと、パフォーマンスが低下します。 */
        datasource.setTestOnReturn(testOnReturn);
        return datasource;
    }
}

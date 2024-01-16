package com.ruoyi.web.core.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ruoyi.common.config.RuoYiConfig;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2インターフェイス構成
 * 
 * @author ruoyi
 */
@Configuration
public class SwaggerConfig
{
    /** システムの基本構成 */
    @Autowired
    private RuoYiConfig ruoyiConfig;

    /** 開くかどうかswagger */
    @Value("${swagger.enabled}")
    private boolean enabled;

    /** リクエストの統一プレフィックスを設定します */
    @Value("${swagger.pathMapping}")
    private String pathMapping;

    /**
     * 作成するAPI
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.OAS_30)
                // 有効にするかどうかSwagger
                .enable(enabled)
                // 使用来作成する该API基本情報，ドキュメントのページに表示します（カスタマイズされた情報）
                .apiInfo(apiInfo())
                // どのインターフェイスにさらされるかSwagger展示する
                .select()
                // すべてのコメントをスキャンしますapi，この方法を使用する方が柔軟です
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 指定されたパッケージをスキャンしますswagger注釈
                // .apis(RequestHandlerSelectors.basePackage("com.ruoyi.project.tool.swagger"))
                // すべてスキャンします .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                /* セキュリティモードを設定します，swaggerアクセスを設定できますtoken */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .pathMapping(pathMapping);
    }

    /**
     * セキュリティモード，ここで指定してくださいtoken合格Authorizationヘッダーヘッド転送
     */
    private List<SecurityScheme> securitySchemes()
    {
        List<SecurityScheme> apiKeyList = new ArrayList<SecurityScheme>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", In.HEADER.toValue()));
        return apiKeyList;
    }

    /**
     * 安全コンテキスト
     */
    private List<SecurityContext> securityContexts()
    {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build());
        return securityContexts;
    }

    /**
     * デフォルトでは、安全見積もり
     */
    private List<SecurityReference> defaultAuth()
    {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    /**
     * 抽象情報を追加します
     */
    private ApiInfo apiInfo()
    {
        // 使用ApiInfoBuilderカスタマイズ
        return new ApiInfoBuilder()
                // タイトルを設定します
                .title("タイトル：Ruo Yi管理システム_インターフェイスドキュメント")
                // 説明する
                .description("説明する：使会社の会社を管理するための情報,具体的に含めますXXX,XXXモジュール...")
                // 著者情報
                .contact(new Contact(ruoyiConfig.getName(), null, null))
                // バージョン
                .version("バージョン号:" + ruoyiConfig.getVersion())
                .build();
    }
}

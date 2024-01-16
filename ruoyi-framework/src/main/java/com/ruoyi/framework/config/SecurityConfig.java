package com.ruoyi.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;
import com.ruoyi.framework.config.properties.PermitAllUrlProperties;
import com.ruoyi.framework.security.filter.JwtAuthenticationTokenFilter;
import com.ruoyi.framework.security.handle.AuthenticationEntryPointImpl;
import com.ruoyi.framework.security.handle.LogoutSuccessHandlerImpl;

/**
 * spring security構成
 * 
 * @author ruoyi
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    /**
     * カスタムユーザー認定ロジック
     */
    @Autowired
    private UserDetailsService userDetailsService;
    
    /**
     * 認証障害処理クラス
     */
    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;

    /**
     * 処理クラスを終了します
     */
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;

    /**
     * token認定フィルター
     */
    @Autowired
    private JwtAuthenticationTokenFilter authenticationTokenFilter;
    
    /**
     * クロス - ドメインフィルター
     */
    @Autowired
    private CorsFilter corsFilter;

    /**
     * アドレスは匿名のアクセスを許可しました
     */
    @Autowired
    private PermitAllUrlProperties permitAllUrl;

    /**
     * 解決する 直接注入できません AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    /**
     * anyRequest          |   すべての要求パスに一致します
     * access              |   SpringEl式の結果はですtrueアクセスできます
     * anonymous           |   匿名にアクセスできます
     * denyAll             |   ユーザーはアクセスできません
     * fullyAuthenticated  |   ユーザーの完全な認証にアクセスできます（いいえremember-me自動的にログインします）
     * hasAnyAuthority     |   パラメーターがある場合，パラメーター表現権限，次に、いずれかの権限にアクセスできます
     * hasAnyRole          |   パラメーターがある場合，パラメーターは役割を表します，キャラクターのいずれかにアクセスできます
     * hasAuthority        |   パラメーターがある場合，パラメーター表現権限，当局にアクセスできます
     * hasIpAddress        |   パラメーターがある場合，パラメーター表現IP住所，ユーザーの場合IP一致するパラメーター，アクセスできます
     * hasRole             |   パラメーターがある場合，パラメーターは役割を表します，役割にアクセスできます
     * permitAll           |   ユーザーは任意にアクセスできます
     * rememberMe          |   合格しますremember-meユーザーアクセスをログインします
     * authenticated       |   ユーザーログインにアクセスできます
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        // メモマークでは、匿名アクセスを許可しますurl
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();
        permitAllUrl.getUrls().forEach(url -> registry.antMatchers(url).permitAll());

        httpSecurity
                // CSRF無効にします，使用されていないからですsession
                .csrf().disable()
                // 無効にしますHTTP応答ヘッダー
                .headers().cacheControl().disable().and()
                // 認証障害処理クラス
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // に基づくtoken，だから必要はありませんsession
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // フィルターリクエスト
                .authorizeRequests()
                // ログイン用login 登録するregister 検証コードcaptchaImage 匿名アクセスを許可します
                .antMatchers("/login", "/register", "/captchaImage").permitAll()
                // 静的リソース，匿名で訪れることができます
                .antMatchers(HttpMethod.GET, "/", "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/profile/**").permitAll()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**").permitAll()
                // 上記を除くすべての要求は、認証する必要があります
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable();
        // に追加Logout filter
        httpSecurity.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
        // に追加JWT filter
        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // に追加CORS filter
        httpSecurity.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
        httpSecurity.addFilterBefore(corsFilter, LogoutFilter.class);
    }

    /**
     * 強いディスディウムハッシュクリプトの実現
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    /**
     * ID認証インターフェイス
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}

package com.unicom.smartcity.security;

import com.unicom.smartcity.properties.SystemProperties;
import com.unicom.smartcity.security.oauth2.OAuth2PermissionFilter;
import com.unicom.smartcity.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author liukai
 */
@EnableWebSecurity(debug = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler formAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler formAuthenticationFailureHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private SystemProperties systemProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, systemProperties.getLoginUrl()).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage(systemProperties.getLoginUrl())
                .successHandler(formAuthenticationSuccessHandler)
                .failureHandler(formAuthenticationFailureHandler)
                .and()
                .logout().logoutSuccessUrl(systemProperties.getLoginUrl())
                //退出支持GET请求
                .logoutRequestMatcher(new AntPathRequestMatcher(systemProperties.getLogoutUrl(), "GET"))
                .and()
                .exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint(systemProperties.getLoginUrl()))
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .addFilterAfter(new OAuth2PermissionFilter(), FilterSecurityInterceptor.class);

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**", "/lib/**", "/images/**", "/favicon.ico");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("unicom").password(passwordService.getDefaultPassword()).roles("CAS_ADMIN");
    }

}

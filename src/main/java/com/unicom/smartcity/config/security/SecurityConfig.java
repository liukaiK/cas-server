package com.unicom.smartcity.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author liukai
 */
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private AuthenticationSuccessHandler browserAuthenticationSuccessHandler;
//
//    @Autowired
//    private AuthenticationFailureHandler browserAuthenticationFailureHandler;
//
//    @Autowired
//    private AuthenticationEntryPoint casAuthenticationEntryPoint;

    @Autowired
    private AuthenticationProvider restAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.formLogin().loginPage("/login").permitAll().and().authorizeRequests().anyRequest().authenticated();

        http.authenticationProvider(restAuthenticationProvider);

//        http.formLogin()
//                .loginPage("/login").permitAll()
//                .successHandler(browserAuthenticationSuccessHandler)
//                .failureHandler(browserAuthenticationFailureHandler)
//                .and().authorizeRequests().anyRequest().authenticated()
//                .and().headers().frameOptions().sameOrigin();
//        http.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint);
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/login").permitAll().anyRequest().authenticated();
//        http.addFilterBefore(new RestUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(browserUserDetailsService()).passwordEncoder(bCryptPasswordEncoder());
    }

//    @Bean
//    public UserDetailsService browserUserDetailsService() {
//        return new BrowserUserDetailsService();
//    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**", "/lib/**", "/images/**", "/favicon.ico", "/v2/api-docs", "/swagger-ui.html", "/webjars/**", "/swagger-resources/**");
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

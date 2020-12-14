package com.peterholub.onlinelibrary.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(
    HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement()
        .maximumSessions(20)
        .sessionRegistry(sessionRegistry());
        // URL pattern-based security settings
        http.authorizeRequests()
        .antMatchers(
        "/api/**"
        ).permitAll()
        .antMatchers("/**").access("hasRole('admin')")
        .and()
        .formLogin()
//        .successHandler(savedRequestAwareAuthenticationSuccessHandler())
        .loginProcessingUrl("/login")
        .usernameParameter("login").passwordParameter("password")
        //.failureHandler(authFailureHandler)
        .and()
        .logout()
        .and()
        .csrf().ignoringAntMatchers("/**");
    }

//    @Bean
//    public SavedRequestAwareAuthenticationSuccessHandler
//    savedRequestAwareAuthenticationSuccessHandler() {
//        CustomAuthenticationSuccessHandler auth
//        = new CustomAuthenticationSuccessHandler();
//        auth.setTargetUrlParameter("targetUrl");
//        auth.setHashPartParameter("hashpart");
//        return auth;
//    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    //    @Bean("userDetailsService")
    //    @Override
    //    public UserDetailsService userDetailsServiceBean() throws Exception {
    //        return new CustomUserDetailsService(userDAO, userRoleDAO);
}

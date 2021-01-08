package com.longnd.config;

import com.longnd.service.UserServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Log logger = LogFactory.getLog(WebSecurityConfig.class);

    @Autowired
    UserServiceImpl userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

        http
                .formLogin()
                    .loginPage("/login").permitAll().defaultSuccessUrl("/", true)
                    .and()
                .rememberMe()
                    .key("Trader-rememberMe")
                    .userDetailsService(userService)
                .tokenRepository(new InMemoryTokenRepositoryImpl())
                    .tokenValiditySeconds(1296000)
                .and()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated();
        http
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .permitAll();
        http.headers().referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.SAME_ORIGIN);
        http.oauth2Login();

    }


}

package com.allstate.speedyclaimsserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsService userDetailsService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors().and().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**")
                .hasAnyRole("USER")
                .antMatchers(HttpMethod.POST, "/**")
                .hasAnyRole("USER")
                .antMatchers(HttpMethod.PUT, "/**")
                .hasAnyRole("USER")
                .and().csrf().disable()
                .httpBasic();
    }

}

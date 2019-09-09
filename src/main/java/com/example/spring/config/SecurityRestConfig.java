/*
 * Created by Ada.Sarca
 * Date: 9/9/2019
 */
package com.example.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityRestConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.rest.username}")
    private String restUsername;
    @Value("${security.rest.password}")
    private String restPassword;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //create users
        auth.inMemoryAuthentication()
                .withUser(this.restUsername)
                .password(encoder().encode(this.restPassword))
                .authorities("ROLE_REST_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //protect end-points
        http
            .antMatcher("/rest/**")
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest()
                .hasAnyAuthority("ROLE_REST_USER")
                .and()
                .httpBasic()
                .authenticationEntryPoint(basicEntryPoint())
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEntryPoint basicEntryPoint() {
        return new BasicAuthEntryPoint();
    }
}

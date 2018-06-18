package com.phoenixcontact.prototype.config;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/","/swagger-resources").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(
//      ServerHttpSecurity http) {
//        return http.authorizeExchange()
//          .pathMatchers("/actuator/**").permitAll()
//          .anyExchange().authenticated()
//          .and().build();
//    }
}
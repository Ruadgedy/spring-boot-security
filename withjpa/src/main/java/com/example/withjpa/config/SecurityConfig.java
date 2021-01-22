package com.example.withjpa.config;

import com.example.withjpa.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

/**
 * @author yuhao
 * @date: 2021/1/19
 * @description:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserService userService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    RoleHierarchy roleHierarchy(){
        final RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_admin > ROLE_user" );
        return roleHierarchy;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .successHandler((request, response, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    response.setContentType("application/json; charset=UTF-8");
                    final PrintWriter writer = response.getWriter();
                    writer.write(new ObjectMapper().writeValueAsString(principal));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json; charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(exception.getMessage());
                    writer.flush();
                    writer.close();
                })
                .permitAll()
            .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setContentType("application/json; charset=UTF-8");
                    final PrintWriter writer = response.getWriter();
                    writer.write("尚未登录，请先登录");
                    writer.flush();
                    writer.close();
                });

    }
}

package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add support for JDBC...no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource); //tell spring security to use JDBC auth with our data source
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees/").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
        //use basic http auth
        http.httpBasic(Customizer.withDefaults());

        //disable csrf
        //as in general not required for stateless rest apis that use Post, Put,Delete and/or patch
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
    //making use of in memory auth
     /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}pass123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary= User.builder()
                .username("mary")
                .password("{noop}pass123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails hanu= User.builder()
                .username("hanu")
                .password("{noop}pass123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,hanu); //returning instance of inmemoryuserdetailsmanager
    }
*/
}

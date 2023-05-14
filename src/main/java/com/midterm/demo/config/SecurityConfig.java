package com.midterm.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// import com.midterm.demo.service.BindingUserToDBService;


@Configuration
@EnableWebSecurity
// @EnableMethodSecurity
public class SecurityConfig {
    
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("test")
            .password(encoder.encode("1234"))
            .roles("ADMIN")
            .build();
        
            return new InMemoryUserDetailsManager(admin);
        // return new BindingUserToDBService();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        // return http.csrf().disable()
        //     .authorizeHttpRequests()
        //     .requestMatchers("/welcome").permitAll()
        //     .and()
        //     .authorizeHttpRequests().requestMatchers("/giccafe/**").authenticated()
        //     .and()
        //     .formLogin()
        //     .and()
        //     .build();

        // @formatter:off
        // http.authorizeHttpRequests()
        //     .requestMatchers("/cashier/login").permitAll()
        //     .anyRequest().permitAll();
        http.authorizeHttpRequests()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll();
        http.authorizeHttpRequests()
            .requestMatchers("/giccafe/**")
            .authenticated();
        http.formLogin()
            .defaultSuccessUrl("/giccafe/homepage",true)
            .permitAll();
            // .loginPage("/cashier/login");
        http.logout()
            .logoutSuccessUrl("/")
            .permitAll();
        // @formatter:on
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

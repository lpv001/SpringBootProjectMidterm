package com.midterm.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Order(1)
public class CashierSecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;
    
    @Bean
    public UserDetailsService userDetailsService(){
        // UserDetails admin = User.withUsername("test")
        //     .password(encoder.encode("1234"))
        //     .roles("ADMIN")
        //     .build();
        
        //     return new InMemoryUserDetailsManager(admin);
        // return new BindingUserToDBService();
        return new UserInfoUserDetailsService();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        http.authorizeHttpRequests()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll();

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

        
        // http.authorizeHttpRequests()
        //     .requestMatchers("/admin/login", "/cashier/login")
        //     .permitAll();
        // http.authorizeHttpRequests()
        //     .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
        //     .permitAll();
        // http.authorizeHttpRequests()
        //     .requestMatchers("/giccafe/**")
        //     .hasAuthority("CASHIER");
        //     // .authenticated();
        // http.formLogin()
        //     .defaultSuccessUrl("/giccafe/homepage",true)
        //     .loginPage("/cashier/login")
        //     .permitAll();
        // http.logout()
        //     .logoutSuccessUrl("/")
        //     .permitAll();

        // http
        // .authorizeHttpRequests(requests -> requests
        //     .requestMatchers("/giccafe/**").hasAuthority("CASHIER")
        //     .anyRequest().authenticated()
        // )
        // .formLogin(form -> form
        //     .loginPage("/cashier/login")
        //     .defaultSuccessUrl("/giccafe/homepage",true)
        //     .permitAll()
        // )
        // .logout(logout -> logout
        //     .permitAll());
        
        http
        .authorizeHttpRequests(authorize -> authorize
              .requestMatchers(new AntPathRequestMatcher("/giccafe/**")).hasAuthority("CASHIER")
              .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/cashier/login")
            .successHandler(customSuccessHandler)
            .failureUrl("/pagenotfound")
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll()
        )
        .httpBasic();

        
        return http.csrf().disable().build();
        
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}


//  https://stackoverflow.com/questions/67520600/redirect-to-different-page-after-login-based-on-user-role-with-spring-security
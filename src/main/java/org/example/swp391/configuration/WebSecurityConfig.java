package org.example.swp391.configuration;

import org.example.swp391.exception.CustomAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers("/css/**", "/images/**", "/js/**", "/font/**").permitAll()
//                        .requestMatchers("/", "/login", "/logout").permitAll()
//                        .requestMatchers("/cart/**").permitAll()
//                        .requestMatchers("/details/**").permitAll()
//                        .requestMatchers("/email").permitAll()
//                        .requestMatchers("/api/cart/**").permitAll()
//                        .requestMatchers("/checkout/**").hasRole("EMPLOYEE")
////                      .requestMatchers("/admin/**","/employee/**").hasRole("ADMIN")
//                        .requestMatchers("/admin/**").permitAll()
//                        .requestMatchers("/employee/**").hasRole("EMPLOYEE")
                          .anyRequest().permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/ok", true)
//                        .failureUrl("/not")
                       .failureHandler(new CustomAuthenticationFailureHandler())
                )
                .rememberMe(rememberMe -> rememberMe
                        .key("uniqueAndSecret")
                        .tokenValiditySeconds(86400)
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
package com.example.SilkRoad.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.SilkRoad.Service.security.UserDetailsServiceCustom;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
                return config.getAuthenticationManager();
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                return new UserDetailsServiceCustom();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);

                builder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

                AuthenticationManager manager = builder.build();
                http

                                .authorizeRequests(requests -> requests
                                                .antMatchers("/admin/**")
                                                .hasAuthority("ADMIN")
                                                .antMatchers("/home/**")
                                                .hasAuthority("USER")
                                                .antMatchers("/profile/**")
                                                .hasAuthority("USER")
                                                .antMatchers("/friendship/**")
                                                .hasAuthority("USER")
                                                // .antMatchers("/login*")
                                                // .permitAll()
                                                // .antMatchers("/signUp*")
                                                // .permitAll()
                                                .anyRequest()
                                                .permitAll())
                                // .formLogin(login -> login
                                // .disable())
                                // .loginPage("/signIn.html")
                                // .loginProcessingUrl("/login")
                                // .defaultSuccessUrl("/index.html", true)
                                // .permitAll())
                                .logout(logout -> logout
                                                .invalidateHttpSession(true)
                                                .deleteCookies("JSESSIONID")
                                                .clearAuthentication(true)
                                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                                .logoutSuccessUrl("/login"))
                                .exceptionHandling(handling -> handling
                                                .accessDeniedHandler(new MyAccessDeniedHandler()))
                                .csrf(csrf -> csrf.disable())
                                .authenticationManager(manager);
                // .httpBasic(withDefaults());
                return http.build();
        }

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
                return (web) -> web.ignoring()
                                .antMatchers("/js/**", "/css/**");
        }
}
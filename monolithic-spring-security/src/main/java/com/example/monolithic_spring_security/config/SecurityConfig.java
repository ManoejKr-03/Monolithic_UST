package com.example.monolithic_spring_security.config;

import com.example.monolithic_spring_security.service.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
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

@Configuration 
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

         
        @Bean
        public UserDetailsService userDetailsService( ) {
       // UserDetails admin = User.withUsername("Emma")
        //                 .password(encoder.encode("Watson"))
        //                 .roles("ADMIN")
        //                 .build();
        // UserDetails user = User.withUsername("manoj")
        //                 .password(encoder.encode("manoj"))
        //                 .roles("USER")
        //                 .build();
        // return new InMemoryUserDetailsManager(admin, user); 
            
             return new CustomUserDetailsService();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
        }

        // configuring the endpoints who can access and who need to authenticate
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            return http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.requestMatchers("/swagger-ui/**" , "/h2-console/**")
            .permitAll()
            .requestMatchers("/api/products", "/api/products/{proId}").hasRole("USER")
            .anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())
            .headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin()))
            .build();
        }

        //ask man how we get the password from the login form ( it will be done by authenticationProvider)
        @Bean
        public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
       // System.out.println(userDetailsService())
        authenticationProvider.setPasswordEncoder(passwordEncoder());
     //   authenticationProvider.setPreAuthenticationChecks();
        return authenticationProvider;


        }




    
}

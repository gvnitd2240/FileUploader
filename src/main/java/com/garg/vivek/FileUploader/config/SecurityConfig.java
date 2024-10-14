//package com.garg.vivek.FileUploader.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableMethodSecurity(securedEnabled = true)
//public class SecurityConfig {
//    private final JwtFilter jwtFilter;
//    private final AuthenticationProvider authenticationProvider;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(withDefaults()) // Use default CORS settings or configure it if needed
//                .csrf(csrf -> csrf.disable()) // Disabling CSRF as it's typically not needed in stateless JWT authentication
//                .authorizeHttpRequests(req ->
//                        req
//                                // Allow authentication endpoints
//                                .requestMatchers("/api/v1/auth/**").permitAll()
//                                // Require authentication for all other requests
//                                .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session policy
//                )
//                .authenticationProvider(authenticationProvider) // Use the custom authentication provider
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter before authentication filter
//
//        return http.build();
//    }
//}
package co.edu.uniquindio.proyecto.seguridad;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final JwtAuthenticationEntryPoint jwtEntryPoint;
//    private final AuthenticationProvider authenticationProvider;
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.cors();
//        http.authorizeHttpRequests().requestMatchers("/api/auth/**").permitAll()
//                .anyRequest().authenticated();
//        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authenticationProvider(authenticationProvider);
//        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//}

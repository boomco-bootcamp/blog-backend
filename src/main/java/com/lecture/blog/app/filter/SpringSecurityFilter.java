package com.lecture.blog.app.filter;
import java.util.List;
import com.lecture.blog.app.utils.JwtTokenUtil;
import com.lecture.blog.biz.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SpringSecurityFilter {

    private final LoginFilter loginFilter;

    public SpringSecurityFilter(LoginFilter loginFilter) {
        this.loginFilter = loginFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // CORS 설정 추가
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

        http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);

        //경로별 권한 추가(인가)
        http
                .authorizeHttpRequests((auth) -> auth
                        // 유저 정보 관련 서비스
                        .requestMatchers("/api/user/info").hasAnyAuthority("ADMIN","USER")
                        .requestMatchers("/api/user/delete").hasAnyAuthority("ADMIN","USER")
                        // 파일 관련 서비스
                        .requestMatchers("/api/file/upload").hasAnyAuthority("ADMIN","USER")
                        //.anyRequest().authenticated()
                        .anyRequest().permitAll()
                );

//        //로그인 페이지로 이동시키기
//        http
//                .formLogin((auth) -> auth.loginPage("/login") //리다이렉션할 경로 설정
//                        .loginProcessingUrl("/loginProc") //로그인데이터를 넘길 경로 (html에서 post하는 경로)
//                        .successHandler((request, response, authentication) -> {
//                            // 로그인 성공 시 처리할 로직
//                            response.sendRedirect("/"); // 성공 후 리다이렉트할 경로
//                        })
//                        .permitAll()
//                );


        //개발용 csrf 설정 해제
        http
                .csrf((auth) -> auth.disable());
        // cors and csrf set
        http.cors(c -> c.configurationSource(corsConfigurationSource()));

        return http.build();
    }

    /**
     * cors 설정
     * */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 로컬
        configuration.addAllowedOriginPattern("http://localhost:3000");
        configuration.addAllowedOriginPattern("https://localhost:3000");

        // 운영
        configuration.addAllowedOriginPattern("http://3.34.41.77:7501");
        configuration.addAllowedOriginPattern("https://3.34.41.77:7501");

        // 개발 환경 서버
        configuration.addAllowedOriginPattern("http://192.168.0.174:3000");
        configuration.addAllowedOriginPattern("https://192.168.0.174:3000");

        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.addExposedHeader("Content-Disposition");
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

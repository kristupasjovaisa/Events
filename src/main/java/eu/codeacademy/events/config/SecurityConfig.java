package eu.codeacademy.events.config;

import eu.codeacademy.events.user.mapper.UserMapper;
import eu.codeacademy.events.user.repository.UserRepository;
import eu.codeacademy.events.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Bean
    public UserDetailsService userDetailsService(){
        return new LoginService(userRepository,mapper);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/events").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("nickname")
                .defaultSuccessUrl("/",true)
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/")
                .permitAll();

    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .loginPage("/login-events")
//                .loginProcessingUrl("/login-events")
//                .defaultSuccessUrl("/",true)
//                .usernameParameter("loginNickname")
//                .passwordParameter("loginPassword");
//    }
}

package hu.reverselogic.meter_reading.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import hu.reverselogic.meter_reading.services.CustomUserDetailsService;

@EnableWebSecurity
//@EnableJpaRepositories
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
                .and().formLogin().permitAll();

    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder(){
        
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return true;
            }
        
            @Override
            public String encode(CharSequence rawPassword) {
                //TODO titkosítás
                return rawPassword.toString();
            }
        };
    }
}
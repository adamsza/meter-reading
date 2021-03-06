package hu.reverselogic.meter_reading.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import hu.reverselogic.meter_reading.services.CustomUserDetailsService;

@EnableWebSecurity
@EnableJpaRepositories(basePackages = "hu.reverselogic.meter_reading.repositories")
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
                .antMatchers("/meterlist*").authenticated()
                .antMatchers("/readinglist*").authenticated()
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/")
                .defaultSuccessUrl("/meterlist")
                .usernameParameter("email")
                .passwordParameter("password");
        http.logout();

    }

    private PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
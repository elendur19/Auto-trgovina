package hr.fer.ris.autotrgovina.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/vehicle/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/manufacturer").permitAll()
                .antMatchers("/api/manufacturer").hasAuthority("ADMIN")
                .antMatchers("/api/validateLogin").hasAuthority("ADMIN")
                .anyRequest().authenticated();

//        httpSecurity.csrf().disable().authorizeRequests()
//                            .antMatchers("/api/vehicle").hasAuthority("ADMIN");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

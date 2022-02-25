package hr.fer.ris.autotrgovina.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add Users for in memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
            .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
            .withUser(users.username("mary").password("test123").roles("MANAGER"))
            .withUser(users.username("susan").password("test123").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().httpBasic();

/*        http.csrf().disable().
                cors().disable()
                .httpBasic()
                .antMatchers("/index.html", "/", "/home", "/api/authorize").permitAll()
                .anyRequest().authenticated();*/
    }
}

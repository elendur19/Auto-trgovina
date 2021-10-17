package hr.fer.ris.autotrgovina.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class BasicWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BasicWebSecurityConfigurerAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/vehicle/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/manufacturer").permitAll()
                .antMatchers("/api/manufacturer").hasAuthority("ADMIN")
                .antMatchers("/api/validateLogin").hasAuthority("ADMIN")
                .anyRequest().authenticated();

//        httpSecurity.csrf().disable().authorizeRequests()
//                            .antMatchers("/api/vehicle").hasAuthority("ADMIN");

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails johnUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN") // ROLE_ADMIN
                .build();

        UserDetails ivanUser = User.builder()
                .username("Ivan")
                .password(passwordEncoder.encode("password"))
                .roles("USER") // ROLE_USER
                .build();


        return new InMemoryUserDetailsManager(
                johnUser,
                ivanUser
        );
    }

    /*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ADMIN");
    }*/
}

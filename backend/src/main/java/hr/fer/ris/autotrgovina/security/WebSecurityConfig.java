package hr.fer.ris.autotrgovina.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static hr.fer.ris.autotrgovina.security.UserRole.*;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().disable()
                .csrf().disable()
                .httpBasic();

//                .antMatchers(HttpMethod.GET, "/api/vehicle/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/manufacturer/**").hasAuthority(MANUFACTURER_READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/api/manufacturer/**").hasAuthority(MANUFACTURER_WRITE.getPermission())
//                .antMatchers("/api/**").hasRole("ADMIN")
//                .antMatchers("/api/validateLogin").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();

//        httpSecurity.csrf().disable().authorizeRequests()
//                            .antMatchers("/api/vehicle").hasAuthority("ADMIN");

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .authorities(ADMIN.getGrantedAuthorities())
                //.roles(ADMIN.name())// ROLE_ADMIN
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
                .authorities(USER.getGrantedAuthorities())
                //.roles(USER.name()) // ROLE_USER
                .build();

        UserDetails maintainer = User.builder()
                .username("maintainer")
                .password(passwordEncoder.encode("maintainer"))
                .authorities(MAINTAINER.getGrantedAuthorities())
                //.roles(USER.name()) // ROLE_MAINTAINER
                .build();

        return new InMemoryUserDetailsManager (
                admin,
                user,
                maintainer
        );
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .authorities("ADMIN");
    }
}

package hr.fer.ris.autotrgovina.security.service;

import hr.fer.ris.autotrgovina.entity.User;
import hr.fer.ris.autotrgovina.repository.UserRepository;
import hr.fer.ris.autotrgovina.service.definition.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImplementation implements UserDetailsService {
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User with username {} not found.", username);
            throw new UsernameNotFoundException("Username does not exist in database: " + username);
        }
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        // add for each User Role create new SimpleGrantedAuthority
        user.getRoles().forEach(role ->
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}

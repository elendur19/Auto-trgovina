package hr.fer.ris.autotrgovina.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static hr.fer.ris.autotrgovina.security.UserPermission.*;

public enum UserRole {
    USER(Sets.newHashSet(MANUFACTURER_READ, VEHICLE_READ)),
    ADMIN(Sets.newHashSet(MANUFACTURER_READ, MANUFACTURER_WRITE, VEHICLE_READ, VEHICLE_WRITE)),
    MAINTAINER(Sets.newHashSet(MANUFACTURER_READ, VEHICLE_READ, VEHICLE_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}

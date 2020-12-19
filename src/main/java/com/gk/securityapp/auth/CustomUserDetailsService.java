package com.gk.securityapp.auth;

import com.gk.securityapp.permission.PermissionEntity;
import com.gk.securityapp.permission.PermissionRepository;
import com.gk.securityapp.role.RoleEntity;
import com.gk.securityapp.role.RoleRepository;
import com.gk.securityapp.user.UserEntity;
import com.gk.securityapp.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @NonNull UserRepository userRepository;

    @NonNull RoleRepository roleRepository;

    @NonNull PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        Function<PermissionEntity, String> toPermissionName = PermissionEntity::getName;

        return User.builder()
                .username(username)
                .password(userEntity.getPassword())
                .authorities(permissionRepository.findAllByRolesIn(roleRepository.findAllByNameIn(userEntity.getRoles())
                        .stream()
                        .map(RoleEntity::getName)
                        .collect(Collectors.toList()))
                        .stream()
                        .map(toPermissionName.andThen(SimpleGrantedAuthority::new))
                        .collect(Collectors.toList()))
                .build();
    }
}

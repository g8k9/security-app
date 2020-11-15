package com.gk.securityapp.auth.service;

import com.gk.securityapp.auth.EagerUserRepository;
import com.gk.securityapp.auth.entity.EagerPermissionEntity;
import com.gk.securityapp.auth.entity.EagerRoleEntity;
import com.gk.securityapp.auth.entity.EagerUserEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EagerUserDetailsService implements UserDetailsService {
    @NonNull EagerUserRepository eagerUserRepository;

    @NonNull PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EagerUserEntity userEntity = eagerUserRepository.findByUsername(username);
        Function<EagerPermissionEntity, String> toPermissionName = EagerPermissionEntity::getName;
        Function<String, GrantedAuthority> toGrantedAuthority = SimpleGrantedAuthority::new;

        return User.builder()
            .username(username)
            .password(userEntity.getPassword())
            .passwordEncoder(passwordEncoder::encode)
            .roles(userEntity.getRoles().stream().map(EagerRoleEntity::getName).toArray(String[]::new))
            .authorities(userEntity.getRoles()
                .parallelStream()
                .flatMap(role -> role.getPermissions().parallelStream())
                .map(toPermissionName.andThen(toGrantedAuthority))
                .collect(Collectors.toSet()))
            .build();
    }
}

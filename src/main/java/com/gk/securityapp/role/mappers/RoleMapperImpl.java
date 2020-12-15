package com.gk.securityapp.role.mappers;

import com.gk.securityapp.role.RoleDTO;
import com.gk.securityapp.role.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleDTO toDto(RoleEntity roleEntity) {
        return Optional.ofNullable(roleEntity)
                .map(entity -> RoleDTO.builder()
                        .name(entity.getName())
                        .title(entity.getTitle())
                        .enabled(entity.isEnabled())
                        .permissions(entity.getPermissions())
                        .users(entity.getUsers())
                        .build())
                .orElse(null);
    }

    @Override
    public RoleEntity toEntity(RoleDTO roleDTO) {
        return Optional.ofNullable(roleDTO)
                .map(dto -> RoleEntity.builder()
                        .name(dto.getName())
                        .title(dto.getTitle())
                        .enabled(dto.isEnabled())
                        .permissions(dto.getPermissions())
                        .users(dto.getUsers())
                        .build())
                .orElse(null);
    }
}

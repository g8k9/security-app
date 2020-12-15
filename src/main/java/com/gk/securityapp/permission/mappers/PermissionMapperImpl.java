package com.gk.securityapp.permission.mappers;

import com.gk.securityapp.permission.PermissionDTO;
import com.gk.securityapp.permission.PermissionEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PermissionMapperImpl implements PermissionMapper {
    @Override
    public PermissionDTO toDto(PermissionEntity permissionEntity) {
        return Optional.ofNullable(permissionEntity)
                .map(entity -> PermissionDTO.builder()
                        .name(entity.getName())
                        .title(entity.getTitle())
                        .enabled(entity.isEnabled())
                        .roles(entity.getRoles())
                        .build())
                .orElse(null);
    }

    @Override
    public PermissionEntity toEntity(PermissionDTO permissionDTO) {
        return Optional.ofNullable(permissionDTO)
                .map(dto -> PermissionEntity.builder()
                        .name(dto.getName())
                        .title(dto.getTitle())
                        .enabled(dto.isEnabled())
                        .roles(dto.getRoles())
                        .build())
                .orElse(null);
    }
}

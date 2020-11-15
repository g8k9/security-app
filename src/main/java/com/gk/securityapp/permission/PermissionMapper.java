package com.gk.securityapp.permission;

import com.gk.securityapp.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<PermissionDTO, PermissionEntity> {
}

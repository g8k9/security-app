package com.gk.securityapp.role;

import com.gk.securityapp.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<RoleDTO, RoleEntity> {
}

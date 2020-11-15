package com.gk.securityapp.user.mappers;

import com.gk.securityapp.common.mapper.BaseMapper;
import com.gk.securityapp.common.mapper.DateMapper;
import com.gk.securityapp.user.UserEntity;
import com.gk.securityapp.user.dto.CreateUserRequest;
import com.gk.securityapp.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PasswordMapper.class, DateMapper.class})
public interface UserMapper extends BaseMapper<UserDTO, UserEntity> {
    @Mapping(target = "password", ignore = true)
    UserDTO toDto(UserEntity entity);

    @Mapping(target = "password", source = "password", qualifiedBy = EncodedMapping.class)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "role", ignore = true)
    UserEntity toEntity(UserDTO dto);

    @Mapping(target = "password", source = "password", qualifiedBy = EncodedMapping.class)
    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(CreateUserRequest userRequest);
}

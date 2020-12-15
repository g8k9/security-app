package com.gk.securityapp.user.mappers;

import com.gk.securityapp.common.mapper.BaseMapper;
import com.gk.securityapp.user.UserEntity;
import com.gk.securityapp.user.dto.CreateUserRequest;
import com.gk.securityapp.user.dto.UserDTO;

public interface UserMapper extends BaseMapper<UserDTO, UserEntity> {
    UserDTO toDto(UserEntity entity);

    UserEntity toEntity(UserDTO dto);

    UserEntity toEntity(CreateUserRequest userRequest);
}

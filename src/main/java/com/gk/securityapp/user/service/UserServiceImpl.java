package com.gk.securityapp.user.service;

import com.gk.securityapp.common.service.BaseServiceImpl;
import com.gk.securityapp.user.UserEntity;
import com.gk.securityapp.user.UserRepository;
import com.gk.securityapp.user.dto.UserDTO;
import com.gk.securityapp.user.mappers.UserMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserDTO, Integer, UserEntity> implements UserService {

    @NonNull
    @Getter(PROTECTED)
    UserRepository repository;

    @NonNull
    @Getter(PROTECTED)
    UserMapper mapper;
}

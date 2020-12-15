package com.gk.securityapp.role.services;

import com.gk.securityapp.common.service.BaseServiceImpl;
import com.gk.securityapp.role.RoleDTO;
import com.gk.securityapp.role.RoleEntity;
import com.gk.securityapp.role.RoleRepository;
import com.gk.securityapp.role.mappers.RoleMapper;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, Integer, RoleEntity> implements RoleService {
    @NonNull
    @Getter(PROTECTED)
    RoleRepository repository;
    @NonNull
    @Getter(PROTECTED)
    RoleMapper mapper;
}


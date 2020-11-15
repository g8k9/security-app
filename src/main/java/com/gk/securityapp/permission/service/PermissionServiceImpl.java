package com.gk.securityapp.permission.service;

import com.gk.securityapp.common.service.BaseServiceImpl;
import com.gk.securityapp.permission.PermissionDTO;
import com.gk.securityapp.permission.PermissionEntity;
import com.gk.securityapp.permission.PermissionMapper;
import com.gk.securityapp.permission.PermissionRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl extends BaseServiceImpl<PermissionDTO, Integer, PermissionEntity> implements PermissionService {
    @NonNull
    @Getter(PROTECTED)
    PermissionRepository repository;

    @NonNull
    @Getter(PROTECTED)
    PermissionMapper mapper;
}

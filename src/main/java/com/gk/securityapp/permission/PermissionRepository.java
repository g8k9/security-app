package com.gk.securityapp.permission;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PermissionRepository extends PagingAndSortingRepository<PermissionEntity, Integer> {
    List<PermissionEntity> findAllByRolesIn(List<String> roles);
}

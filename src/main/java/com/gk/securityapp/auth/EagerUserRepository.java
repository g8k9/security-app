package com.gk.securityapp.auth;

import com.gk.securityapp.auth.entity.EagerUserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EagerUserRepository extends PagingAndSortingRepository<EagerUserEntity, Integer> {
    EagerUserEntity findByUsername(String username);
}

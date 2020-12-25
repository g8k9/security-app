package com.gk.securityapp.client;

import com.gk.securityapp.client.entities.OauthClientDetailsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OauthClientRepository extends PagingAndSortingRepository<OauthClientDetailsEntity, String> {
}

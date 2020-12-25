package com.gk.securityapp.client.services;

import com.gk.securityapp.client.OauthClientDTO;
import com.gk.securityapp.client.OauthClientRepository;
import com.gk.securityapp.client.entities.OauthClientDetailsEntity;
import com.gk.securityapp.client.mappers.OauthClientMapper;
import com.gk.securityapp.common.service.BaseServiceImpl;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PROTECTED;

@Service
@RequiredArgsConstructor
public class OauthClientServiceImpl extends BaseServiceImpl<OauthClientDTO, String, OauthClientDetailsEntity> implements OauthClientService {
    @NonNull
    @Getter(PROTECTED)
    OauthClientRepository repository;

    @NonNull
    @Getter(PROTECTED)
    OauthClientMapper mapper;
}

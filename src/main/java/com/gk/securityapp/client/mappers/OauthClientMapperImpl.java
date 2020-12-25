package com.gk.securityapp.client.mappers;

import com.gk.securityapp.client.OauthClientDTO;
import com.gk.securityapp.client.entities.OauthClientDetailsEntity;
import org.springframework.stereotype.Component;

@Component
public class OauthClientMapperImpl implements OauthClientMapper {
    @Override
    public OauthClientDTO toDto(OauthClientDetailsEntity entity) {
        return null;
    }

    @Override
    public OauthClientDetailsEntity toEntity(OauthClientDTO dto) {
        return null;
    }
}

package com.gk.securityapp.common.mappers;

public interface BaseMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);
}

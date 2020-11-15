package com.gk.securityapp.common.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<D, ID> {
    D create(D body);

    D update(ID id, D body);

    void delete(ID id);

    Optional<D> getById(ID id);

    List<D> getAll();
}

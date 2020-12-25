package com.gk.securityapp.role;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@Jacksonized
public class RoleDTO {
    int id;
    String name;
    String clientId;
    boolean enabled;
    @Singular
    List<String> permissions;
    @Singular
    List<Integer> users;
}

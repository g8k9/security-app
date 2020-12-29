package com.gk.securityapp.permission;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@Jacksonized
public class PermissionDTO {
    int id;
    String name;
    boolean enabled;
    @Singular
    List<String> roles;
}

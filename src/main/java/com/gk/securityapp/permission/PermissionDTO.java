package com.gk.securityapp.permission;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder(toBuilder = true, access = AccessLevel.PUBLIC)
@Jacksonized
public class PermissionDTO {
    Integer id;
    String name;
    String title;
    boolean enabled;
}

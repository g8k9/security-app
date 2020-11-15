package com.gk.securityapp.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.OffsetDateTime;

@Getter
@Builder(toBuilder = true, access = AccessLevel.PUBLIC)
@Jacksonized
public class UserDTO {
    int id;
    String username;
    String password;
    boolean enabled;
    OffsetDateTime createdDate;
    OffsetDateTime lastModifiedDate;
}

package com.gk.securityapp.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@Builder(toBuilder = true, access = AccessLevel.PUBLIC)
@JsonDeserialize(builder = UserDTO.UserDTOBuilder.class)
public class UserDTO {
    int id;
    String username;
    String password;
    boolean enabled;
    OffsetDateTime createdDate;
    OffsetDateTime lastModifiedDate;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserDTOBuilder {
    }
}

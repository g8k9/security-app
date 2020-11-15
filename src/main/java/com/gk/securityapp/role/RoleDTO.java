package com.gk.securityapp.role;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true, access = AccessLevel.PUBLIC)
@JsonDeserialize(builder = RoleDTO.RoleDTOBuilder.class)
public class RoleDTO {

    Integer id;
    String name;
    String title;
    boolean enabled;

    @JsonPOJOBuilder(withPrefix = "")
    public static class RoleDTOBuilder {
    }
}

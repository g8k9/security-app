package com.gk.securityapp.permission;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true, access = AccessLevel.PUBLIC)
@JsonDeserialize(builder = PermissionDTO.PermissionDTOBuilder.class)
public class PermissionDTO {

    Integer id;
    String name;
    String title;
    boolean enabled;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PermissionDTOBuilder {
    }
}

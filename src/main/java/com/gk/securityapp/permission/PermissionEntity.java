package com.gk.securityapp.permission;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permissions", schema = "public")
@Setter(AccessLevel.PACKAGE)
@Getter
@Builder(toBuilder = true)
@Jacksonized
public class PermissionEntity {
    @Id
    @Column(name = "name", unique = true, updatable = false, nullable = false)
    String name;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection
    @CollectionTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "permission_name"))
    @Column(name = "role_name")
    @Singular
    List<String> roles;
}

package com.gk.securityapp.permission;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permissions", schema = "public")
@Setter(AccessLevel.PACKAGE)
@Getter
@Builder(toBuilder = true)
@JsonDeserialize(builder = PermissionEntity.PermissionEntityBuilder.class)
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name", unique = true, updatable = false, nullable = false)
    String name;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection
    @CollectionTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "permission_id"))
    @Column(name = "role_id")
    @Singular
    Set<Integer> roles;
}

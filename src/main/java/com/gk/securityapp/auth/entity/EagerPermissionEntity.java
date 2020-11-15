package com.gk.securityapp.auth.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permissions", schema = "public")
@Setter(AccessLevel.PACKAGE)
@Getter
@Builder(toBuilder = true)
@JsonDeserialize(builder = EagerPermissionEntity.EagerPermissionEntityBuilder.class)
public class EagerPermissionEntity {
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

    @ManyToMany(mappedBy = "permissions")
    @Singular
    Set<EagerRoleEntity> roles;
}

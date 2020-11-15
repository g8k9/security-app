package com.gk.securityapp.auth.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "public")
@Setter(AccessLevel.PACKAGE)
@Getter
@Builder(toBuilder = true)
@JsonDeserialize(builder = EagerRoleEntity.EagerRoleEntityBuilder.class)
public class EagerRoleEntity {
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @Singular
    Set<EagerPermissionEntity> permissions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @Singular
    Set<EagerUserEntity> users;
}

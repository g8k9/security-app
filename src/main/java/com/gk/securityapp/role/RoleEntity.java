package com.gk.securityapp.role;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "public")
@Setter(AccessLevel.PACKAGE)
@Getter
@Builder(toBuilder = true)
@JsonDeserialize(builder = RoleEntity.RoleEntityBuilder.class)
public class RoleEntity {
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
    @CollectionTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "permission_id")
    @Singular
    Set<Integer> permissions;

    @ElementCollection
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "user_id")
    @Singular
    Set<Integer> users;
}

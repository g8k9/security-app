package com.gk.securityapp.role;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "public")
@FieldDefaults(makeFinal = false)
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder(toBuilder = true)
@Jacksonized
public class RoleEntity {
    @Id
    @Column(name = "name")
    String name;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "role_name"))
    @Column(name = "permission_name")
    @Singular
    List<String> permissions;

    @ElementCollection
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_name"))
    @Column(name = "user_id")
    @Singular
    List<Integer> users;
}

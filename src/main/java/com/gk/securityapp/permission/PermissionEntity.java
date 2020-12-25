package com.gk.securityapp.permission;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permissions", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {
        "name", "client_id"
}))
@FieldDefaults(makeFinal = false)
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder(toBuilder = true)
@Jacksonized
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    int id;

    @Column(name = "name", updatable = false, nullable = false)
    String name;

    @Column(name = "client_id", updatable = false, nullable = false)
    String clientId;


    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection
    @CollectionTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "permission_name"))
    @Column(name = "role_name")
    @Singular
    List<String> roles;
}

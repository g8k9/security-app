package com.gk.securityapp.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users", schema = "public")
@Setter
@Getter
@Builder(toBuilder = true)
@Jacksonized
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "username", unique = true, updatable = false, nullable = false)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "enabled", nullable = false)
    boolean enabled;

    @ElementCollection
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_name")
    @Singular
    List<String> roles;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Builder.Default
    Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Builder.Default
    Instant lastModifiedDate = Instant.now();
}

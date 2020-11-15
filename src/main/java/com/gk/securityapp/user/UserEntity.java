package com.gk.securityapp.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "users", schema = "public")
@Setter(AccessLevel.PACKAGE)
@Getter
@Builder(toBuilder = true)
@JsonDeserialize(builder = UserEntity.UserEntityBuilder.class)
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
    @Column(name = "role_id")
    @Singular
    Set<Integer> roles;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Builder.Default
    Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Builder.Default
    Instant lastModifiedDate = Instant.now();
}

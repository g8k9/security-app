package com.gk.securityapp.auth.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
@JsonDeserialize(builder = EagerUserEntity.EagerUserEntityBuilder.class)
public class EagerUserEntity {
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

    @ManyToMany(mappedBy = "users")
    Set<EagerRoleEntity> roles;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Builder.Default
    Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Builder.Default
    Instant lastModifiedDate = Instant.now();
}

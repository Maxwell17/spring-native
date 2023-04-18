package com.example.springnative.repository.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "accounts", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime created_on;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime last_login;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinTable(
            name = "account_roles",
            joinColumns = @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "role_id")),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "user_id")))
    private Role role;

}

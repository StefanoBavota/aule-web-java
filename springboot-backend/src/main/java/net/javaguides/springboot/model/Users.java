package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "email_verified_at")
    private Timestamp emailVerifiedAt;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;
}

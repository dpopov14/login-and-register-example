package com.example.backend.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")

@Getter
@Setter
@ToString(exclude = {"id"})
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Column(nullable = false)
    private String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}

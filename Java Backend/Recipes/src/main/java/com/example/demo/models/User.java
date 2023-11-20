package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private Long id;

    //    @Email
    @Pattern(regexp = ".+@.+\\..+")
    @NotBlank(message = "Email is required")
    String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password minimum 8")
    String password;

}

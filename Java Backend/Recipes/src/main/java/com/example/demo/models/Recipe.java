package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Long id;

    @NotBlank(message = "Name is required")
    String name;

    @NotBlank(message = "Description is required")
    @NonNull String description;

    @NotNull(message = "Ingredients should not be null")
    @Size(min = 1, message = "Should have at least 1 ingredient")
    @ElementCollection
    List<String> ingredients;

    @NotNull(message = "Directions should not be null")
    @Size(min = 1, message = "Should have at least 1 direction")
    @ElementCollection
    List<String> directions;
}

package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
//@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Setter(AccessLevel.NONE) //
    @JsonIgnore //
    Long id;

    @NotBlank(message = "Name is required")
    String name;

    @NotBlank(message = "Category is required")
    String category;

    @NotBlank(message = "Description is required")
    String description;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @UpdateTimestamp
    LocalDateTime date;

    //    @NotNull(message = "Ingredients should not be null")
    @NotEmpty(message = "Ingredients can not be empty") //
    @Size(min = 1, message = "Should have at least 1 ingredient")
    @ElementCollection
    List<String> ingredients;

    //    @NotNull(message = "Directions should not be null")
    @NotEmpty(message = "Directions cannot be empty")
    @Size(min = 1, message = "Should have at least 1 direction")
    @ElementCollection
    List<String> directions;


    public void copyOf(Recipe recipe) {
        name = recipe.name;
        category = recipe.category;
        description = recipe.description;
        ingredients = recipe.ingredients;
        directions = recipe.directions;
    }
}

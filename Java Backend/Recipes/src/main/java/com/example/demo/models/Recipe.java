package com.example.demo.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> recipe-stage3
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

<<<<<<< HEAD
@Builder
@Getter
@AllArgsConstructor
@Entity
@Table(name = "recipe")
@JsonDeserialize(builder = Recipe.RecipeBuilder.class)
@JsonIncludeProperties({"name", "description", "ingredients", "directions"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "id" })
=======
@Entity
@Table(name = "recipe")
>>>>>>> recipe-stage3
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    Long id;

    @Column
    @NonNull String name;

    @Column
    @NonNull String description;
=======
    @JsonIgnore
    Long id;

    @Column
    @NotNull
    @NotBlank
    String name;

    @Column
    @NotNull
    @NotBlank
    String description;
>>>>>>> recipe-stage3

    @Column
<<<<<<< HEAD
    @NonNull List<String> ingredients;
=======
    @NotNull
    @Size(min = 1)
    @ElementCollection
    List<String> ingredients;
>>>>>>> recipe-stage3

    @Column
<<<<<<< HEAD
    @NonNull List<String> directions;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class RecipeBuilder {
=======
    @NotNull
    @Size(min = 1)
    @ElementCollection
    List<String> directions;

    public Recipe() {
    }

    public Recipe(Long id, String name, String description, List<String> ingredients, List<String> directions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
>>>>>>> recipe-stage3
    }
}

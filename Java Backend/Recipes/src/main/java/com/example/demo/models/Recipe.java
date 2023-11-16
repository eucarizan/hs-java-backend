package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@Entity
@Table(name = "recipe")
@JsonDeserialize(builder = Recipe.RecipeBuilder.class)
@JsonIncludeProperties({"name", "description", "ingredients", "directions"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "id" })
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    @NonNull String name;

    @Column
    @NonNull String description;

    @Singular
    @Column
    @NonNull List<String> ingredients;

    @Singular
    @Column
    @NonNull List<String> directions;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class RecipeBuilder {
    }
}

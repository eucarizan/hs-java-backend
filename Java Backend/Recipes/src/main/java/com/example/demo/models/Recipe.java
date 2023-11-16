package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipe")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;

    @Column
    @NonNull
    String name;

    @Column
    @NonNull
    String description;

    @Singular
    @Column
    @NonNull
    List<String> ingredients;

    @Singular
    @Column
    @NonNull
    List<String> directions;
}

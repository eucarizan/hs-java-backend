package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Recipe {

    @Id
    @GeneratedValue()
    Long id;

    @Builder.Default
    String name = "Fresh Mint Tea";

    @Builder.Default
    String description = "Light, aromatic and refreshing beverage, ...";

    @Singular
    List<String> ingredients = Arrays.asList("boiled water", "honey", "fresh mint leaves");

    @Singular
    List<String> directions = Arrays.asList("Boil water", "Pour boiling hot water into a mug",
            "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again");
}

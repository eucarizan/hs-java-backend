package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Recipe {
    @Builder.Default
    String name = "Fresh Mint Tea";
    @Builder.Default
    String description = "Light, aromatic and refreshing beverage, ...";
    @Builder.Default
    String ingredients = "boiled water, honey, fresh mint leaves";
    @Builder.Default
    String directions = "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again.";
}

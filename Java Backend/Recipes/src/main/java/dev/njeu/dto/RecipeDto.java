package dev.njeu.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecipeDto {
    private String name;
    private LocalDateTime date;
    private String category;
    private String description;
    private List<String> ingredients;
    private List<String> directions;
}

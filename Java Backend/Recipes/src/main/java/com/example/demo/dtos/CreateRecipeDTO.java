package com.example.demo.dtos;

import lombok.Getter;

@Getter
public class CreateRecipeDTO {
    int id;

    public CreateRecipeDTO(int id) {
        this.id = id;
    }

}

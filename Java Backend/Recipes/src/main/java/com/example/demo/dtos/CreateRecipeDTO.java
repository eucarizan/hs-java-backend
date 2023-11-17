package com.example.demo.dtos;

import lombok.Getter;

@Getter
public class CreateRecipeDTO {
    long id;

    public CreateRecipeDTO(long id) {
        this.id = id;
    }

}

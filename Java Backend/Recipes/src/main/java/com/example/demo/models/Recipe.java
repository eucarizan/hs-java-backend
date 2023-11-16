package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "recipe")
public record Recipe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,
    String name,
    String description,
    List<String> ingredients,
    List<String> directions
) {

}

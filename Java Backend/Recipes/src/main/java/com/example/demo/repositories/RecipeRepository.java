package com.example.demo.repositories;

import com.example.demo.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findByCategoryIgnoreCaseContainsOrderByDateDesc(String category);
    List<Recipe> findByNameIgnoreCaseContainsOrderByDateDesc(String name);
}

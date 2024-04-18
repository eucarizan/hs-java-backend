package dev.njeu.repositories;

import dev.njeu.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByCategoryEqualsIgnoreCaseOrderByDateTimeDesc(String search);
    List<Recipe> findAllByNameContainsIgnoreCaseOrderByDateTimeDesc(String search);
}

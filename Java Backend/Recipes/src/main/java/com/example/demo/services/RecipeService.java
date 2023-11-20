package com.example.demo.services;

import com.example.demo.models.Recipe;
import com.example.demo.models.User;
import com.example.demo.repositories.RecipeRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Recipe> findById(long id) {
        return recipeRepository.findById(id);
    }

    public long add(Recipe recipe, UserDetails user) {
        recipe.setEmail(user.getUsername());
        return recipeRepository.save(recipe).getId();
    }

    public ResponseEntity<Void> deleteById(long id, UserDetails user) {
        var recipe = findById(id);
        if (recipe.isPresent()) {
            if (recipe.get().getEmail().equals(user.getUsername())) {
                recipeRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Recipe>> getRecipesByName(String name) {
        return ResponseEntity.ok(recipeRepository.findByNameIgnoreCaseContainsOrderByDateDesc(name));
    }

    public ResponseEntity<List<Recipe>> getRecipesByCategory(String category) {
        return ResponseEntity.ok(recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category));
    }

    public boolean updateById(long id, Recipe recipe) {
        var recipeToUpdate = findById(id);

        if (recipeToUpdate.isPresent()) {
            Recipe oldRecipe = recipeToUpdate.get();
            oldRecipe.copyOf(recipe);
            recipeRepository.save(oldRecipe);
            return true;
        }

        return false;
    }

    public boolean registerUser(User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}

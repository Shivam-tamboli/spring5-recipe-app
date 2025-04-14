package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.commands.RecipeCommand;
import guru.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;
// defining a contract for recipe-related operations.
public interface RecipeService {
    // Method to fetch a Recipe by its ID.
    Recipe findById(Long id);
    // Method to retrieve all Recipe objects as a Set.
    Set<Recipe> getRecipes();
    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}

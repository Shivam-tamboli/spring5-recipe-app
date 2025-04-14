package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

//RecipeRepository is a specialized interface that connects the Recipe class to the database,
// extend gains access to all the public methods and properties of the parent class or interface.
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

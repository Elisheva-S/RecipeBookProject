package springboot.recipebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.recipebook.model.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	 @Query(value = "SELECT r.recipe_name, r.instructions,"
	 		+ "  STRING_AGG(i.ingredient_name, ', ') AS ingredient_names,sum(i.price)"
	 		+ "FROM recipe r "
	 		+ "LEFT JOIN ingredients_recipe ri "
	 		+ "ON r.recipe_id = ri.recipe_id "
	 		+ "LEFT JOIN ingredient i "
	 		+ "ON i.ingredient_id = ri.ingredient_id "
	 		+ "WHERE ri.recipe_id = (:recipeId) "
	 		+ "GROUP BY r.recipe_name,  r.instructions;", nativeQuery = true)
	    List<Object[]> getRecipeDetails(@Param("recipeId") Long recipeId);
	    
}

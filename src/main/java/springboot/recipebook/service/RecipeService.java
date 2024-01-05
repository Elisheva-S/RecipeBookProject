package springboot.recipebook.service;
import springboot.recipebook.dto.RecipeDTO;
import springboot.recipebook.dto.RecipeRequestDTO;
import springboot.recipebook.exception.InvalidRecipeDataException;
import springboot.recipebook.model.*;
import java.util.List;

public interface RecipeService {
    List<RecipeRequestDTO> getRecipeDetails(Long recipeId);
    void AddNewRecipe(RecipeDTO recipeDTO) throws InvalidRecipeDataException;
}

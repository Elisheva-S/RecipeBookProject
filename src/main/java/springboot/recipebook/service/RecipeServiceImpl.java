package springboot.recipebook.service;
import springboot.recipebook.repository.*;
import springboot.recipebook.dto.IngredientDTO;
import springboot.recipebook.dto.RecipeDTO;
import springboot.recipebook.dto.RecipeRequestDTO;
import springboot.recipebook.exception.InvalidRecipeDataException;
import springboot.recipebook.exception.ResourceNotFoundException;
import springboot.recipebook.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class RecipeServiceImpl implements RecipeService {
	@Autowired
	private RecipeRepository rr;
	@Autowired
	private IngredientRepository ir;
	@Override
	public List<RecipeRequestDTO> getRecipeDetails(Long recipeId) {
        List<Object[]> results = rr.getRecipeDetails(recipeId);               
	        List<RecipeRequestDTO> recipeDetails = new ArrayList<>();
	        for (Object[] result : results) {
	            String recipeName = (String) result[0];
	            String instructions = (String) result[1];
	            String ingredientName = (String) result[2];
	            Double price = (Double) result[3];

	            RecipeRequestDTO recipeDTO = new RecipeRequestDTO(recipeName, instructions, ingredientName, price);
	            recipeDetails.add(recipeDTO);
	        }

	        return recipeDetails;
	    }


	@Override
	public void AddNewRecipe(RecipeDTO recipeDTO) throws InvalidRecipeDataException {
		try {
		    Recipe recipe = new Recipe();
	        recipe.setRecipeName(recipeDTO.getRecipeName());
	        recipe.setInstructions(recipeDTO.getInstructions());

	        Set<IngredientsInRecipe> recipeIngredients = new HashSet<>();

	        for (IngredientDTO ingredientDTO : recipeDTO.getIngredients()) {
	            Ingredient existingIngredient =ir.findByName(ingredientDTO.getIngredientName());
	            if (existingIngredient!=null) {           		
	            	IngredientsInRecipe recipeIngredient = new IngredientsInRecipe();
	            	recipeIngredient.setIngredient(existingIngredient);
	            	recipeIngredient.setRecipe(recipe);
	            	recipeIngredients.add(recipeIngredient);
	            	}
	            else {
	            	throw new ResourceNotFoundException("The ingredient: "+ingredientDTO.getIngredientName()+" isn't exists!!" );
	            }
	        }
	        recipe.setIngredientsInRecipe(recipeIngredients);
	        rr.save(recipe);   
		}
		catch (Exception e) {
			throw new InvalidRecipeDataException("The recipe data are invalid!");
		}
	}
}


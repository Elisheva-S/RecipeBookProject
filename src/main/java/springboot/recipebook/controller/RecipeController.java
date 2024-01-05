package springboot.recipebook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import springboot.recipebook.service.RecipeService;
import springboot.recipebook.exception.InvalidRecipeDataException;
import springboot.recipebook.dto.RecipeDTO;
import springboot.recipebook.dto.RecipeRequestDTO;
@RestController

public class RecipeController {
	@Autowired
	private RecipeService recipe;
	
	    @GetMapping("/recipes/all/{recipeId}")
	    public List<RecipeRequestDTO> getRecipeDetails(@PathVariable Long recipeId)
	    {
			return recipe.getRecipeDetails(recipeId);
	    	
	    }
	    @PostMapping("/recipes/new")
	    public ResponseEntity<String> createRecipe(@Valid @RequestBody RecipeDTO requestDTO) throws InvalidRecipeDataException {
	    	recipe.AddNewRecipe(requestDTO);
	        return ResponseEntity.ok("Recipe created with ingredients.");
	    }  
}

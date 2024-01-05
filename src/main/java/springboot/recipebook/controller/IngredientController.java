package springboot.recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import springboot.recipebook.service.IngredientService;
import springboot.recipebook.exception.ResourceNotFoundException;
import springboot.recipebook.model.Ingredient;

@RestController
public class IngredientController {
	   @Autowired
	   private IngredientService ingredientService;
	   
	 
	    @GetMapping("/ingredients")
	    public List<Ingredient> getIngredients() {
	        return ingredientService.getAllIngredients();
	    }
	    @PutMapping("/ingredients/{ingredientId}")
	    public Ingredient updateIngredient(@PathVariable Long ingredientId,
	                               @Valid @RequestBody Ingredient ingredientRequest) {
	        Ingredient i= ingredientService.getIngredientById(ingredientId);
	        if(i!=null)
	        {
	                	i.setIngredientName(ingredientRequest.getIngredientName());
	                	i.setPrice(ingredientRequest.getPrice());
	                     return ingredientService.updateIngredient(i);
	        }
	        else { 
	        	throw new ResourceNotFoundException("Ingredient not found with id " + ingredientId);
	        }
	    }
	    
	    @DeleteMapping("/ingredients/delete/{ingredientId}")
	    public boolean deleteIngredient(@PathVariable Long ingredientId) {
	        ingredientService.deleteIngredient(ingredientId);   
	        return true;
	    }
}

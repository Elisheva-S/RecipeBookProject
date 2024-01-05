package springboot.recipebook.service;

import java.util.List;


import springboot.recipebook.model.*;
public interface IngredientService {
	List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long id);
    void saveIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Ingredient ingredient);
    void deleteIngredient(Long id);  

}

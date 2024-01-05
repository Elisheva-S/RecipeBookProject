package springboot.recipebook.dto;

import java.util.List;

import springboot.recipebook.dto.IngredientDTO;

public class RecipeDTO {

	private Long recipeId;
	private String recipeName;
    private String instructions;
    private List<IngredientDTO> ingredients;
    private Double priceTotal;
    public RecipeDTO() {
    	
    }   
    public RecipeDTO(String recipeName, String instructions, List<IngredientDTO> ingredients,Double priceTotal) {
        this.recipeName = recipeName;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.setPriceTotal(priceTotal);
    }

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	public Double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}
}



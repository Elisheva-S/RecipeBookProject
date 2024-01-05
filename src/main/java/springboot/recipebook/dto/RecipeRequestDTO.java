package springboot.recipebook.dto;


public class RecipeRequestDTO {
	private String recipeName;
    private String instructions;
    private String ingredientsName;
    private Double price;

    public RecipeRequestDTO(String recipeName, String instructions, String ingredientsName, Double price) {
        this.recipeName = recipeName;
        this.instructions = instructions;
        this.ingredientsName = ingredientsName;
        this.price = price;
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

	public String getIngredientsName() {
		return ingredientsName;
	}

	public void setIngredientsName(String ingredientName) {
		this.ingredientsName = ingredientName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

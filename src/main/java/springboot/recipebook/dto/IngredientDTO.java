package springboot.recipebook.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class IngredientDTO {
	
	private Long ingredientId;
	private String ingredientName;
	@JsonCreator
  public IngredientDTO(String ingredientName) {
		this.ingredientName=ingredientName;
	}
  

public String getIngredientName() {
	return ingredientName;
}

public void setIngredientName(String ingredientName) {
	this.ingredientName = ingredientName;
}


public Long getIngredientId() {
	return ingredientId;
}


public void setIngredientId(Long ingredientId) {
	this.ingredientId = ingredientId;
}
  

}

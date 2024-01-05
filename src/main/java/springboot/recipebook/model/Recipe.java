package springboot.recipebook.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "instructions")
    private String instructions;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<IngredientsInRecipe> ingredientsInRecipe;
    
    @Transient
    private double priceTotal;
    public Recipe() {
        
    }

    public Recipe(String recipeName, String instructions,double priceTotal) {
        this.recipeName = recipeName;
        this.instructions = instructions;
        this.priceTotal=priceTotal;
        		
    }
  
    public Long getRecipeId() {
        return id;
    }

    public void setRecipeId(Long recipeId) {
        this.id = recipeId;
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

	public void setIngredientsInRecipe(Set<IngredientsInRecipe> ingredientsRecipe) {
		    this.ingredientsInRecipe = ingredientsRecipe;
		}
	 public double getPriceTotal() {
	        return priceTotal;
	    }

	    public void setPriceTotal(double priceTotal) {
	        this.priceTotal = priceTotal;
	    }
		
	}

package springboot.recipebook.model;



import java.util.Set;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "price")
    private double price;

    public Ingredient() {
    }
    public Ingredient(String ingredientName, double price) {
        this.ingredientName = ingredientName;
        this.price = price;
    }
    @OneToMany(mappedBy = "ingredient", fetch = FetchType.EAGER )
    @Fetch(FetchMode.JOIN)
    private Set<IngredientsInRecipe> ingredientsInRecipe;
    
    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
	

   
}
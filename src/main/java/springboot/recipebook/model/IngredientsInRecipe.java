package springboot.recipebook.model;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "ingredients_recipe")
public class IngredientsInRecipe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ingredients_recipe_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public IngredientsInRecipe() {
    }

    public IngredientsInRecipe(Recipe recipe, Ingredient ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}


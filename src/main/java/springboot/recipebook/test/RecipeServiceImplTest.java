package springboot.recipebook.test;

import springboot.recipebook.repository.RecipeRepository;
import springboot.recipebook.service.RecipeServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import springboot.recipebook.dto.RecipeRequestDTO;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {
	@Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;
    @Test
    public void testGetRecipeDetails_WithValidRecipeId_ReturnsListOfRecipeRequestDTO() {
        List<Object[]> results = new ArrayList<>();
        Object[] result1 = {"Recipe1", "Instructions1", "Ingredient1", 10.0};
        results.add(result1);
        when(recipeRepository.getRecipeDetails(anyLong())).thenReturn(results);

        List<RecipeRequestDTO> recipeDetails = recipeService.getRecipeDetails(1L);

        assertEquals(1, recipeDetails.size());

        RecipeRequestDTO recipeDTO1 = recipeDetails.get(0);
        assertEquals("Recipe1", recipeDTO1.getRecipeName());
        assertEquals("Instructions1", recipeDTO1.getInstructions());
        assertEquals("Ingredient1", recipeDTO1.getIngredientsName());
        assertEquals(Double.valueOf(10.0), recipeDTO1.getPrice());

        verify(recipeRepository).getRecipeDetails(1L);
    }
    @Test
    public void testGetRecipeDetails_WithInvalidRecipeId_ReturnsEmptyList() {
        when(recipeRepository.getRecipeDetails(anyLong())).thenReturn(new ArrayList<>());
        List<RecipeRequestDTO> recipeDetails = recipeService.getRecipeDetails(100L);

        assertTrue(recipeDetails.isEmpty());

        verify(recipeRepository).getRecipeDetails(100L);
    }

}


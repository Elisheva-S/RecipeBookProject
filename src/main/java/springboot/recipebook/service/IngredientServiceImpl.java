package springboot.recipebook.service;

import java.util.List;
import springboot.recipebook.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.recipebook.model.*;
@Service
public class IngredientServiceImpl implements IngredientService{
@Autowired
private IngredientRepository ir;

@Override
public List<Ingredient> getAllIngredients() {
    return ir.findAll();
}

@Override
public Ingredient getIngredientById(Long id) {
    return ir.findById(id).orElse(null);
}

@Override
public void saveIngredient(Ingredient ingredient) {
    ir.save(ingredient);
}

@Override
public Ingredient updateIngredient(Ingredient ingredient) {
    return ir.save(ingredient);
}

@Override
public void deleteIngredient(Long id) {
    ir.deleteById(id);
}

}




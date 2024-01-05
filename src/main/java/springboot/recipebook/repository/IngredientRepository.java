package springboot.recipebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.recipebook.model.*;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
@Query(value ="select ingredient_id from ingredient where ingredient_name=:ingredientNames",nativeQuery = true)
	List<Ingredient> findAllByNameIn(@Param("ingredientNames") List<String> ingredientNames);
@Query(value ="select * from ingredient where ingredient_name=:ingredientName",nativeQuery = true)
	Ingredient findByName(@Param("ingredientName") String ingredientName);
}


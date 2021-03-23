package com.cameronsmith.chefToolkit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.chefToolkit.models.Ingredient;
import com.cameronsmith.chefToolkit.models.Recipe;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, Long>{
	List<Ingredient> findAll();
	List<Ingredient> findByRecipe(Recipe recipe);
	Ingredient findByRecipeIdAndProductId(Long recipeId, Long productId);
}

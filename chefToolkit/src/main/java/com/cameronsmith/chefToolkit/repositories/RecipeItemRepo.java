package com.cameronsmith.chefToolkit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.models.RecipeItem;
@Repository
public interface RecipeItemRepo extends CrudRepository<RecipeItem, Long>{
	List<RecipeItem> findByRecipe(Recipe recipe);
}

package com.cameronsmith.chefToolkit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.chefToolkit.models.Recipe;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Long>{
	List<Recipe> findAll();
}

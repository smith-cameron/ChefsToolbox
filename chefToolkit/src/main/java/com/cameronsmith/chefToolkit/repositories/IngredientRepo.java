package com.cameronsmith.chefToolkit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.chefToolkit.models.Ingredient;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, Long>{
	List<Ingredient> findAll();
}

package com.cameronsmith.chefToolkit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.models.RecipeItem;
import com.cameronsmith.chefToolkit.repositories.RecipeItemRepo;
@Service
public class RecipeItemService {
	@Autowired
	private RecipeItemRepo rItemRepo;
	
	public RecipeItem updateEntry(RecipeItem toUpdate, Recipe recipe) {
		return this.rItemRepo.save(toUpdate);
	}
	public List<RecipeItem> findByRecipeId(Recipe recipe){
		return this.rItemRepo.findByRecipe(recipe);
	}
	public RecipeItem getById(Long id) {
		return this.rItemRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.rItemRepo.deleteById(id);
	}
}

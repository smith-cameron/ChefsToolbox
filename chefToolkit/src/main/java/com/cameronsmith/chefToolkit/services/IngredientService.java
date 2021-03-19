package com.cameronsmith.chefToolkit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.models.Ingredient;
import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.repositories.IngredientRepo;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepo iRepo;
	
	public Ingredient createEntry(Ingredient toUpdate) {
		return this.iRepo.save(toUpdate);
	}
	public Ingredient updateEntry(Ingredient toUpdate) {
		return this.iRepo.save(toUpdate);
	}
	public List<Ingredient> getAll(){
		return this.iRepo.findAll();
	}
	public Ingredient getById(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.iRepo.deleteById(id);
	}
	public List<Ingredient> ingredientsInRecipe(Recipe recipe){
		List<Ingredient> ingredients = this.iRepo.findByRecipe(recipe);
		return ingredients;
	}
}

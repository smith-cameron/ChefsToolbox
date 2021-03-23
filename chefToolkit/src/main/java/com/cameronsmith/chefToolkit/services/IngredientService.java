package com.cameronsmith.chefToolkit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.models.Ingredient;
import com.cameronsmith.chefToolkit.models.Product;
import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.repositories.IngredientRepo;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepo iRepo;
	
	public Ingredient createEntry(Recipe recipe, Product product, double amount) {
		Ingredient newIng = new Ingredient();
		newIng.setProduct(product);
		newIng.setRecipe(recipe);
		newIng.setAmount(amount);
		return this.iRepo.save(newIng);
	}
	public Ingredient updateEntry(Long ingredient, Recipe recipe, Product product, double amount) {
		Ingredient thisIng = this.getById(ingredient);
		thisIng.setProduct(product);
		thisIng.setRecipe(recipe);
		thisIng.setAmount(amount);
		return this.iRepo.save(thisIng);
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
	public void deleteEntry(Recipe recipe, Product product) {
		Long recipeId = recipe.getId();
		Long productId = product.getId();
		Ingredient todelete = this.iRepo.findByRecipeIdAndProductId(recipeId, productId);
		Long ingredientId = todelete.getId();
		this.deleteById(ingredientId);
	}
	public List<Ingredient> ingredientsInRecipe(Recipe recipe){
		List<Ingredient> ingredients = this.iRepo.findByRecipe(recipe);
		return ingredients;
	}
	
}

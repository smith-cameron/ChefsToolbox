package com.cameronsmith.chefToolkit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.models.Product;
import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.repositories.ProductRepo;
import com.cameronsmith.chefToolkit.repositories.RecipeRepo;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepo rRepo;
	@Autowired
	private ProductRepo pRepo;
	
	public Recipe createEntry(Recipe toUpdate) {
		return this.rRepo.save(toUpdate);
	}
	public Recipe updateEntry(Recipe toUpdate) {
		return this.rRepo.save(toUpdate);
	}
	public List<Recipe> getAll(){
		return this.rRepo.findAll();
	}
	public Recipe getById(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.rRepo.deleteById(id);
	}
	public List<Product> getProductsInRecipe(Recipe recipe){
		List<Product> products = recipe.getProductsinRec();
		return products;
	}
	public List<Product> findProductsNotInRecipe(Recipe recipe) {
		return pRepo.findByRecipesNotContains(recipe);
	}
	public void addProductToRecipe(Product product, Recipe recipe) {
		List<Product> productsInRecipe = recipe.getProductsinRec();
		productsInRecipe.add(product);
		this.rRepo.save(recipe);
	}
	public void removeProductFromRecipe(Product product, Recipe recipe) {
		List<Product> productsInRecipe = recipe.getProductsinRec();
		productsInRecipe.remove(product);
		this.rRepo.save(recipe);
	}
}

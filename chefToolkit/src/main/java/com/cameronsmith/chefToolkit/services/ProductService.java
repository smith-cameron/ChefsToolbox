package com.cameronsmith.chefToolkit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.models.Product;
import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.repositories.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo iRepo;
	
	public Product createEntry(Product toUpdate) {
		return this.iRepo.save(toUpdate);
	}
	public List<Product> getAll(){
		return this.iRepo.findAll();
	}
	public Product getById(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.iRepo.deleteById(id);
	}
	public List<Recipe> getRecipes(Long id){
		List<Recipe> recipes = this.getById(id).getRecipes();
		return recipes;
	}
}

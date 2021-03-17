package com.cameronsmith.chefToolkit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.repositories.RecipeRepo;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepo rRepo;
	
	public Recipe createEntry(Recipe toUpdate) {
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
	
}

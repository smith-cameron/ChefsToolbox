package com.cameronsmith.chefToolkit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cameronsmith.chefToolkit.models.Ingredient;
import com.cameronsmith.chefToolkit.models.Product;
import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.services.IngredientService;
import com.cameronsmith.chefToolkit.services.RecipeService;

@Controller
@RequestMapping("/toolbox/ingredient")
public class IngredientController {
	@Autowired
	private IngredientService iService;
	@Autowired
	private RecipeService rService;
	
	@PostMapping("/adjust/{id}")
	public String addAmount(@Valid @ModelAttribute("ingredient")Ingredient ingredientInput, BindingResult result, @PathVariable("id")Long recipeid, Model viewModel) {
		Recipe currentRecipe = this.rService.getById(recipeid);
		List<Product> products = this.rService.getProductsInRecipe(currentRecipe);
		viewModel.addAttribute("recipe", currentRecipe);
		viewModel.addAttribute("products", products);
		if (result.hasErrors()) {
			viewModel.addAttribute("recipe", currentRecipe);
			viewModel.addAttribute("products", products);
			return "recipeEdit.jsp";
		}
		Ingredient newEntry = this.iService.createEntry(ingredientInput);
		newEntry.setRecipe(currentRecipe);
		return "redirect:/toolbox/recipe/show"+currentRecipe.getId();
	}
}

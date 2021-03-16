package com.cameronsmith.chefToolkit.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cameronsmith.chefToolkit.models.Ingredient;
import com.cameronsmith.chefToolkit.services.IngredientService;

@Controller
@RequestMapping("/toolbox/ingredient")
public class IngredientController {
//	@Autowired
//	private UserService uService;
//	@Autowired
//	private RecipeService rService;
	@Autowired
	private IngredientService iService;
//	@Autowired
//	private RecipeItemService riService;
	
	
	
	@GetMapping("/")
	public String allIngredients(Model viewModel) {
		viewModel.addAttribute("ingredients", this.iService.getAll());
		return "ingredientsAll.jsp";
	}
	@GetMapping("/create")
	public String newIngredient(@ModelAttribute("ingredient")Ingredient ingredientInput) {
		
		return "ingredientNew.jsp";
	}
	@PostMapping("/create")
	public String addIngredient(@Valid @ModelAttribute("ingredient")Ingredient ingredientInput, BindingResult result) {
		if (result.hasErrors()) {
			return "ingredientNew.jsp";
		}
		this.iService.createEntry(ingredientInput);
		return "redirect:/toolbox/ingredient/";
	}
	@GetMapping("/edit/{id}")
	public String showIngredient(@ModelAttribute("ingredient")Ingredient ingredientInput, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("ingredient", this.iService.getById(id));
		return "ingredientEdit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String editIngredient(@Valid @ModelAttribute("ingredient")Ingredient ingredientInput, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("ingredient", this.iService.getById(id));
		if (result.hasErrors()) {
			viewModel.addAttribute("ingredient", this.iService.getById(id));
			return "ingredientEdit.jsp";
		}
		this.iService.createEntry(ingredientInput);
		return "redirect:/toolbox/ingredient/";
	}
	@GetMapping("/delete/{id}")
	public String deleteIngredient(@PathVariable("id")Long id) {
		this.iService.deleteById(id);
		return "redirect:/toolbox/ingredient/";
	}
}

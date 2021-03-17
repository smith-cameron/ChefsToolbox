package com.cameronsmith.chefToolkit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.models.RecipeItem;
import com.cameronsmith.chefToolkit.services.IngredientService;
import com.cameronsmith.chefToolkit.services.RecipeItemService;
import com.cameronsmith.chefToolkit.services.RecipeService;
import com.cameronsmith.chefToolkit.services.UserService;

@Controller
@RequestMapping("/toolbox/recipe")
public class RecipeController {
	@Autowired
	private UserService uService;
	@Autowired
	private RecipeService rService;
	@Autowired
	private IngredientService iService;
	@Autowired
	private RecipeItemService riService;
	
	@GetMapping("/")
	public String allRecipes(Model viewModel) {
		viewModel.addAttribute("recipes", this.rService.getAll());
		return "recipeAll.jsp";
	}
	@GetMapping("/create")
	public String newRecipe(@ModelAttribute("recipe")Recipe recipeInput) {
		
		return "recipeNew.jsp";
	}
	@PostMapping("/create")
	public String addRecipe(@Valid @ModelAttribute("recipe")Recipe recipeInput, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "recipeNew.jsp";
		}
		Recipe newRecipe = this.rService.createEntry(recipeInput);
//		session.setAttribute("recipeId", newRecipe.getId());
		return "redirect:/toolbox/recipe/adding/"+newRecipe.getId();
	}
	@GetMapping("/adding/{id}")
	public String modifyRecipe(@ModelAttribute("recipeItem")RecipeItem recipeItemInput, @PathVariable("id")Long recipeid, Model viewModel) {
		Recipe currentRecipe = this.rService.getById(recipeid);
		viewModel.addAttribute("currentRecipe", currentRecipe);
		viewModel.addAttribute("ingredients", this.iService.getAll());
		//List<RecipeItem> currentRecipeItems = currentRecipe.getIngredientsInRecipe();
//		viewModel.addAttribute("currentRecipeItems", this.rService.);
		return "addRecipeIng.jsp";
	}
	@PostMapping("/adding/{id}")
	public String editRecipe(@Valid @ModelAttribute("recipeItem")RecipeItem recipeItemInput,  BindingResult result, @PathVariable("id")Long recipeid, Model viewModel) {
		Recipe currentRecipe = this.rService.getById(recipeid);
		viewModel.addAttribute("currentRecipe", currentRecipe);
		if (result.hasErrors()) {
			viewModel.addAttribute("currentRecipe", this.rService.getById(recipeid));
			return "addRecipeIng.jsp";
		}
		this.riService.updateEntry(recipeItemInput,currentRecipe);
		return "redirect:/toolbox/recipe/adding/"+currentRecipe.getId();
	}
	@GetMapping("/show")
	public String showRecipe() {
		
		return "recipeShow.jsp";
	}
}

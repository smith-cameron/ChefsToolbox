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
import org.springframework.web.bind.annotation.RequestParam;

import com.cameronsmith.chefToolkit.models.Ingredient;
import com.cameronsmith.chefToolkit.models.Product;
import com.cameronsmith.chefToolkit.models.Recipe;
import com.cameronsmith.chefToolkit.services.IngredientService;
import com.cameronsmith.chefToolkit.services.ProductService;
import com.cameronsmith.chefToolkit.services.RecipeService;

@Controller
@RequestMapping("/toolbox/recipe")
public class RecipeController {
	@Autowired
	private RecipeService rService;
	@Autowired
	private ProductService pService;
	@Autowired
	private IngredientService iService;
	
	
	@GetMapping("/")
	public String allRecipes(Model viewModel) {
		viewModel.addAttribute("recipes", this.rService.getAll());
		return "recipesAll.jsp";
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
		return "redirect:/toolbox/recipe/adding/"+newRecipe.getId();
	}
	@GetMapping("/adding/{id}")
	public String recipeContent(@PathVariable("id")Long id, Model viewModel) {
		Recipe thisRecipe = rService.getById(id);
		List<Product> thisRecipesProducts = thisRecipe.getProductsinRec();
		List<Product> others = rService.findProductsNotInRecipe(thisRecipe);
		viewModel.addAttribute("productsIn", thisRecipesProducts);
		viewModel.addAttribute("recipe", thisRecipe);
		viewModel.addAttribute("productsNotIn", others);
		return "addRecipeIng.jsp";
	}
	@PostMapping("/adding/{id}")
	public String addProductToRecipe(@RequestParam("product")Long productId, @PathVariable("id")Long id) {
		Product productToAdd= this.pService.getById(productId);
		Recipe thisRecipe = rService.getById(id);
		this.rService.addProductToRecipe(productToAdd, thisRecipe);
		return "redirect:/toolbox/recipe/adding/"+thisRecipe.getId();
	}
	@GetMapping("/{rId}/{pId}/removeproduct")
	public String removeProductFromRecipe(@PathVariable("rId")Long recipeId,@PathVariable("pId")Long productId) {
		Product productToRemove = this.pService.getById(productId);
		Recipe thisRecipe = rService.getById(recipeId);
		this.rService.removeProductFromRecipe(productToRemove, thisRecipe);
		return "redirect:/adding/"+productId;
	}
	@PostMapping("edit/adding/{id}")
	public String ProductToRecipe(@RequestParam("product")Long productId, @PathVariable("id")Long id) {
		Product productToAdd= this.pService.getById(productId);
		Recipe thisRecipe = rService.getById(id);
		this.rService.addProductToRecipe(productToAdd, thisRecipe);
		return "redirect:/toolbox/recipe/edit/"+thisRecipe.getId();
	}
	@GetMapping("edit/{rId}/{pId}/removeproduct")
	public String ProductFromRecipe(@PathVariable("rId")Long recipeId,@PathVariable("pId")Long productId) {
		Product productToRemove = this.pService.getById(productId);
		Recipe thisRecipe = rService.getById(recipeId);
		this.rService.removeProductFromRecipe(productToRemove, thisRecipe);
		return "redirect:/toolbox/recipe/edit/"+thisRecipe.getId();
		}
	@GetMapping("/delete/{id}")
	public String deleteRecipe(@PathVariable("id")Long id) {
		this.rService.deleteById(id);
		return "redirect:/toolbox/recipe/";
	}
	@GetMapping("/edit/{id}")
	public String showRecipe(@ModelAttribute("recipe")Recipe recipeInput, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		Recipe thisRecipe = rService.getById(id);
		List<Product> thisRecipesProducts = thisRecipe.getProductsinRec();
		List<Product> others = rService.findProductsNotInRecipe(thisRecipe);
		viewModel.addAttribute("productsIn", thisRecipesProducts);
		viewModel.addAttribute("recipe", thisRecipe);
		viewModel.addAttribute("productsNotIn", others);
		return "recipeEdit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String editRecipe(@Valid @ModelAttribute("recipe")Recipe recipeInput, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		Recipe thisRecipe = rService.getById(id);
		List<Product> thisRecipesProducts = thisRecipe.getProductsinRec();
		List<Product> others = rService.findProductsNotInRecipe(thisRecipe);
		viewModel.addAttribute("productsIn", thisRecipesProducts);
		viewModel.addAttribute("recipe", thisRecipe);
		viewModel.addAttribute("productsNotIn", others);
		if (result.hasErrors()) {
			viewModel.addAttribute("productsIn", thisRecipesProducts);
			viewModel.addAttribute("recipe", thisRecipe);
			viewModel.addAttribute("productsNotIn", others);
			return "recipeEdit.jsp";
		}
		this.rService.updateEntry(recipeInput);
		return "redirect:/toolbox/recipe/";
	}
	@GetMapping("/show/{id}")
	public String showRecipe( @ModelAttribute("ingredient")Ingredient ingredientInput,@PathVariable("id")Long id, Model viewModel) {
		Recipe currentRecipe = this.rService.getById(id);
		List<Product> products = this.rService.getProductsInRecipe(currentRecipe);
		
		viewModel.addAttribute("recipe", currentRecipe);
		viewModel.addAttribute("products", products);
		
		return "recipeShow.jsp";
	}
	@PostMapping("/show/{id}")
	public String addAmount(@Valid @ModelAttribute("ingredient")Ingredient ingredientInput, BindingResult result, @PathVariable("id")Long recipeid, Model viewModel) {
		Recipe currentRecipe = this.rService.getById(recipeid);
		List<Product> products = this.rService.getProductsInRecipe(currentRecipe);
		viewModel.addAttribute("recipe", currentRecipe);
		viewModel.addAttribute("products", products);
		if (result.hasErrors()) {
			viewModel.addAttribute("recipe", currentRecipe);
			viewModel.addAttribute("products", products);
			return "recipeShow.jsp";
		}
		Ingredient newEntry = this.iService.createEntry(ingredientInput);
		newEntry.setRecipe(currentRecipe);
		return "redirect:/toolbox/recipe/show/"+currentRecipe.getId();
	}
}

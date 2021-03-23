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

import com.cameronsmith.chefToolkit.models.Product;
import com.cameronsmith.chefToolkit.services.ProductService;

@Controller
@RequestMapping("/toolbox/product")
public class ProductController {
	@Autowired
	private ProductService pService;
	
	
	
	@GetMapping("/")
	public String allProduct(Model viewModel) {
		viewModel.addAttribute("products", this.pService.getAll());
//		List<Recipe> recipes = this.iService.getRecipes(null)
		return "productsAll.jsp";
	}
	@GetMapping("/create")
	public String newProduct(@ModelAttribute("product")Product productInput) {
		
		return "productNew.jsp";
	}
	@PostMapping("/create")
	public String addProduct(@Valid @ModelAttribute("product")Product productInput, BindingResult result) {
		if (result.hasErrors()) {
			return "productNew.jsp";
		}
		this.pService.createEntry(productInput);
		return "redirect:/toolbox/product/";
	}
	@GetMapping("/edit/{id}")
	public String showProduct(@ModelAttribute("product")Product ingredientInput, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("product", this.pService.getById(id));
		return "productEdit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String editProduct(@Valid @ModelAttribute("product")Product productInput, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("product", this.pService.getById(id));
		if (result.hasErrors()) {
			viewModel.addAttribute("product", this.pService.getById(id));
			return "productEdit.jsp";
		}
		this.pService.createEntry(productInput);
		return "redirect:/toolbox/product/";
	}
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id")Long id) {
		this.pService.deleteById(id);
		return "redirect:/toolbox/product/";
	}
}

package com.cameronsmith.chefToolkit.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
public class Product {
//	Attributes---------------------------------------------
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	@NotBlank
	@Size(min=3, message="Must Be Over 3 Characters")
	private String name;
	@NotNull
	@Column(precision=2)
	private double cost;
	@NotNull
	@Column(precision=2)
	private double quantity;
	@NotBlank
	private String unitOfMeasure;
//	Table Realationships ----------------------------------
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredientsMade;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "recipes_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipes;
//	Bean --------------------------------------------------
	public Product() {
		
	}
//	Getter/Setter Pairs------------------------------------
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return this.cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getQuantity() {
		return this.quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUnitOfMeasure() {
		return this.unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	public void setIngredientsInRecipe(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	public List<Ingredient> getIngredients() {
		return this.ingredientsMade;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredientsMade = ingredients;
	}
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	public List<Ingredient> getIngredientsMade() {
		return this.ingredientsMade;
	}
	public void setIngredientsMade(List<Ingredient> ingredientsMade) {
		this.ingredientsMade = ingredientsMade;
	}
	
}

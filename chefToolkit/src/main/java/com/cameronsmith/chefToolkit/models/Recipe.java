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
@Table(name="recipes")
public class Recipe {
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
	private float yield;
	@NotBlank
	private String unitOfMeasure;
	@NotNull
	@Column(precision=2)
	private float serving;
	@NotNull
	@Column(precision=2)
	private float costPercentage;
//	Table Realationships ----------------------------------
	@OneToMany(mappedBy="recipe",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredientsUsed;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "recipes_products", 
        joinColumns = @JoinColumn(name = "recipe_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productsinRec;
//	Bean --------------------------------------------------
	public Recipe() {
		
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
	public float getYield() {
		return this.yield;
	}
	public void setYield(float yield) {
		this.yield = yield;
	}
	public float getServing() {
		return this.serving;
	}
	public void setServing(float serving) {
		this.serving = serving;
	}
	public float getCostPercentage() {
		return this.costPercentage;
	}
	public void setCostPercentage(float costPercentage) {
		this.costPercentage = costPercentage;
	}
	public List<Product> getProductsinRec() {
		return this.productsinRec;
	}
	public void setProductsinRec(List<Product> productsinRec) {
		this.productsinRec = productsinRec;
	}
	public String getUnitOfMeasure() {
		return this.unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public List<Ingredient> getIngredientsUsed() {
		return this.ingredientsUsed;
	}
	public void setIngredientsUsed(List<Ingredient> ingredientsUsed) {
		this.ingredientsUsed = ingredientsUsed;
	}
	
}

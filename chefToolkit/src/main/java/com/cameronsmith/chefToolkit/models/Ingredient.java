package com.cameronsmith.chefToolkit.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ingredients")
public class Ingredient {
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
	@NotBlank
	@Size(min=1, max=3, message="Must Be 1-3 Characters")
	private String source;
	@NotBlank
	@Size(min=1, max=3, message="Must Be 1-3 Characters")
	private String department;
	@NotBlank
	private Float costPcase;
	@NotBlank
	@Size(min=1, message="Must Be 1 or More")
	private int units;
	@NotBlank
	@Size(min=1, message="Must Be 1 or More")
	private Float quantityPunit;
	@NotBlank
	private String unitOfMeasure;
//	Table Realationships ----------------------------------
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User ingredientCreator;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "recipes_ingredients", 
        joinColumns = @JoinColumn(name = "ingredient_id"), 
        inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipesIn;
//	Bean --------------------------------------------------
	public Ingredient() {
	}
//	Getter/Setter Pairs------------------------------------
}

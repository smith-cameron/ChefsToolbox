package com.cameronsmith.springbootuploadexcelfiles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {
	@Id
	  @Column(name = "id")
	  private long id;

	  @Column(name = "name")
	  private String name;

	  @Column(name = "source")
	  private String source;

	  @Column(name = "department")
	  private String department;
	  
	  @Column(name = "cost")
	  private double cost;
	  
	  @Column(name = "units")
	  private double units;
	  
	  @Column(name = "quantityPunit")
	  private double quantityPunit;
	  
	  @Column(name = "unitOfMeasure")
	  private String unitOfMeasure;
//	  ------------------------------
	public Ingredient() {
		
	}
	
	public Ingredient(String name, String source, String department, Float cost, int units, Float quantityPunit,
			String unitOfMeasure) {
		super();
		this.name = name;
		this.source = source;
		this.department = department;
		this.cost = cost;
		this.units = units;
		this.quantityPunit = quantityPunit;
		this.unitOfMeasure = unitOfMeasure;
	}
	
	public static void add(Ingredient ingredient) {
			
	}

//	  ------------------------------
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return this.source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDepartment() {
		return this.department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getCost() {
		return this.cost;
	}
	public void setCost(double d) {
		this.cost = d;
	}
	public double getUnits() {
		return this.units;
	}
	public void setUnits(double units) {
		this.units = units;
	}
	public double getQuantityPunit() {
		return this.quantityPunit;
	}
	public void setQuantityPunit(double d) {
		this.quantityPunit = d;
	}
	public String getUnitOfMeasure() {
		return this.unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	
	@Override
	  public String toString() {
	    return "Ingedients [Id=" + id + ", Name=" + this.name + ", Source=" + this.source + ", Department=" + this.department + ", Cost Per Case=" + this.cost + ", Units=" + this.units + ", Quantity Per Unit=" + this.quantityPunit + ", Unit Of Measure=" + this.unitOfMeasure + "]";
	  }
	
}

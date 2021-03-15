package com.cameronsmith.springbootuploadexcelfiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cameronsmith.springbootuploadexcelfiles.model.Ingredient;

public interface IngredientRepo extends JpaRepository<Ingredient, Long>{

}

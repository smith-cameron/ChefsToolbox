package com.cameronsmith.chefToolkit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.chefToolkit.models.Product;
import com.cameronsmith.chefToolkit.models.Recipe;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByRecipesNotContains(Recipe recipe);
}

package com.cameronsmith.chefToolkit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.repositories.IngredientRepo;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepo iRepo;
}

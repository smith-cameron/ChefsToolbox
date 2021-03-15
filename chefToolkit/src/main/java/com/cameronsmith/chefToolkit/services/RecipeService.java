package com.cameronsmith.chefToolkit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.chefToolkit.repositories.RecipeRepo;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepo rRepo;
}

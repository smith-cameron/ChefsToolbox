package com.cameronsmith.springbootuploadexcelfiles.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cameronsmith.springbootuploadexcelfiles.helper.ExcelHelper;
import com.cameronsmith.springbootuploadexcelfiles.model.Ingredient;
import com.cameronsmith.springbootuploadexcelfiles.repository.IngredientRepo;

@Service
public class ExcelService {
	@Autowired
	  IngredientRepo repository;

	  public void save(MultipartFile file) {
	    try {
	      List<Ingredient> ingredients = ExcelHelper.excelToDb(file.getInputStream());
	      repository.saveAll(ingredients);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<Ingredient> getAllTutorials() {
	    return repository.findAll();
	  }
	}

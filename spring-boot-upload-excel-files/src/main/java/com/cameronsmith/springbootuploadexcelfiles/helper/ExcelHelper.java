package com.cameronsmith.springbootuploadexcelfiles.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.cameronsmith.springbootuploadexcelfiles.model.Ingredient;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Name", "Source", "Department", "Cost", "Units", "quantityInUnit", "uOm" };
	  static String SHEET = "Ingredients";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<Ingredient> excelToDb(InputStream is) {
	    try {
	      Workbook workbook = new XSSFWorkbook(is);

	      Sheet sheet = workbook.getSheet(SHEET);
	      Iterator<Row> rows = sheet.iterator();

	      List<Ingredient> ingredients = new ArrayList<Ingredient>();

	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();

	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }

	        Iterator<Cell> cellsInRow = currentRow.iterator();

	        Ingredient ingredient = new Ingredient();

	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();

	          switch (cellIdx) {
	          case 0:
	        	  ingredient.setId((long) currentCell.getNumericCellValue());
	            break;

	          case 1:
	        	  ingredient.setName(currentCell.getStringCellValue());
	            break;

	          case 2:
	        	  ingredient.setSource(currentCell.getStringCellValue());
	            break;

	          case 3:
	        	  ingredient.setDepartment(currentCell.getStringCellValue());
	            break;

	          case 4:
	        	  ingredient.setCost(currentCell.getNumericCellValue());
	            break;
	            
	          case 5:
	        	  ingredient.setUnits(currentCell.getNumericCellValue());
	            break;
	            
	          case 6:
	        	  ingredient.setQuantityPunit(currentCell.getNumericCellValue());
	            break;
	            
	          case 7:
	        	  ingredient.setUnitOfMeasure(currentCell.getStringCellValue());
	            break;
	            
	          default:
	            break;
	          }

	          cellIdx++;
	        }

	        Ingredient.add(ingredient);
	      }

	      workbook.close();

	      return ingredients;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	}

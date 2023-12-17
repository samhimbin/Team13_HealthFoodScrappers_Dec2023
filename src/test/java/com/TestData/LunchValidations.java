package com.TestData;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.driverFactory.InitClass;
import com.Utilities.ExcelReader;

public class LunchValidations extends InitClass {

	@Test
	public void scrapeLunchRecipe() throws InterruptedException, IOException {

		//declaring variables
		String prep_Time=null;
		String ingredients=null;
		String cook_Time=null;
		String method=null;
		String nutrientValue = null;
		Instant timer_end;
		Instant timer_start = Instant.now();
		
		// xlsheet path 
		String path = ".//src//test//resources//TestData//RecipeTestData.xlsx";
		ExcelReader excelReader = new ExcelReader(path);

		// write headers in xlsheet
		try {
			excelReader.setCellData("LunchRecipes", 0, 0, "Recipe Id");
			excelReader.setCellData("LunchRecipes", 0, 1, "Recipe Name");
			excelReader.setCellData("LunchRecipes", 0, 2, "Recipe Category(Breakfast/lunch/snack/dinner)");
			excelReader.setCellData("LunchRecipes", 0, 3, "Food Category(Veg/non-veg/vegan/Jain)");
			excelReader.setCellData("LunchRecipes", 0, 4, " Ingredients");
			excelReader.setCellData("LunchRecipes", 0, 5, "Preparation Time");
			excelReader.setCellData("LunchRecipes", 0, 6, "Cooking Time");
			excelReader.setCellData("LunchRecipes", 0, 7, "Preparation method");
			excelReader.setCellData("LunchRecipes", 0, 8, "Nutrient values");
			excelReader.setCellData("LunchRecipes", 0, 9,
					"Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
			excelReader.setCellData("LunchRecipes", 0, 10, "Recipe URL");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// Search Lunch recipe from recipe search box on Home page
		WebElement recipeSearchBox = driver.findElement(By.id("ctl00_txtsearch"));
		WebElement searchButton = driver.findElement(By.id("ctl00_imgsearch"));

		recipeSearchBox.sendKeys("lunch");
		searchButton.click();
		
		
		//fetching all urls in List
		List<WebElement> recipes_url = driver.findElements(By.className("rcc_recipename"));
		int total_cards = recipes_url.size();
		System.out.println("Total cards ="+total_cards);
		ArrayList link = new ArrayList<String>();
		
		//Adding all recipe urls in arraylist
		for (WebElement e : recipes_url)
		  {
		   // .findElement -----> finds the tag <a> inside the current WebElement
		   // .getAttribute ----> returns the href attribute of the <a> tag in the current WebElement
		   link.add(e.findElement(By.tagName("a")).getAttribute("href"));
		   
		  }
		
		//Clicking each recipe card and fetching all required information an writing in excel
		for(Object each_recipe: link )
		{
			Document doc = Jsoup.connect((String) each_recipe).get(); //clicking each recipe
			
			//fetching preperation time
			Elements prep_TimeElement = doc.selectXpath("//time[@itemprop='prepTime']");
			 prep_Time = prep_TimeElement.text();
			System.out.println("Preparation time="+prep_Time);
			
			
			//fetching cooking time
			Elements cook_TimeElement = doc.selectXpath("//time[@itemprop='cookTime']");
			 cook_Time = cook_TimeElement.text();
			System.out.println("Cooking time ="+cook_Time);
			
			//Fetching ingredients list
			Elements ingredient_listElement = doc.selectXpath("//div[@id='rcpinglist']");
			 ingredients = ingredient_listElement.text();
			System.out.println("Ingredients list="+ingredients);
			
			//fetching methods of the recipe
			Elements method_Element = doc.selectXpath("//div[@id='recipe_small_steps']");
			 method = method_Element.text();
			System.out.println("Method ="+method);
			
			//Fetching nutrient values
			Elements nutrient_Element = doc.selectXpath("//div[@id='accompaniments']");
			 nutrientValue= nutrient_Element.text();
			System.out.println("Nutrient Value="+nutrientValue);
		}
		System.out.println("Done!!!!");
		
		timer_end = Instant.now();
		
		System.out.println("Time taken to scrape this webpage = "+Duration.between(timer_start,timer_end).toSeconds());
		for(int i =0 ; i<total_cards;i++)
		{
			//recipe URL
			excelReader.setCellData("LunchRecipes", i+1, 10,(String)link.get(i));
			System.out.println("Recipe"+i+link.get(i));
			String recipe_Url = (String)link.get(i); 
			System.out.println("RecipeURL ="+recipe_Url);
			
			//recipe id 
			int index = recipe_Url.lastIndexOf("-")+1;
			String recipe_id = recipe_Url.substring(recipe_Url.lastIndexOf("-")+1, recipe_Url.lastIndexOf("r"));
			System.out.println("Recipe ID ="+recipe_id);
			excelReader.setCellData("LunchRecipes", i+1, 0, recipe_id);
			
			//recipe name
			int indexOfName = recipe_Url.lastIndexOf("/")+1; 
			String recipe_name = recipe_Url.substring(indexOfName,recipe_Url.lastIndexOf("-"));
			System.out.println("Recipe name --"+recipe_name);
			excelReader.setCellData("LunchRecipes", i+1, 1, recipe_name);
			
			//prep_Time
			excelReader.setCellData("LunchRecipes", i+1, 5,prep_Time);
			excelReader.setCellData("LunchRecipes", i+1, 6,cook_Time);
		    excelReader.setCellData("LunchRecipes", i+1, 4,ingredients);
		    excelReader.setCellData("LunchRecipes", i+1, 7,method);
		    excelReader.setCellData("LunchRecipes", i+1, 8,nutrientValue);
		
	}
	}
}

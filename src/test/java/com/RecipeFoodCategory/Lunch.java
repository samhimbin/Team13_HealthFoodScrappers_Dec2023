package com.RecipeFoodCategory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.LoggerLoad;

public class Lunch {
	
	public Lunch(WebDriver driver) {
		PageFactory.initElements(driver, this);
		LoggerLoad.info("In Lunch Recipecategory");
	}
	
	@FindBy(xpath = "//div[@id=\"toplinks\"]/a")
	List<WebElement> toplinks;
	
	@FindBy(xpath = "//p[text()=\"Recipes A to Z\"]")
	WebElement pageTitle;
	
	// list of WebElements that store all the links
	@FindBy(xpath = "//*[@class=\"rcc_recipename\"]/a")
	List<WebElement> raw_recipes;
	
	public void get_toplinks() throws MalformedURLException, IOException, URISyntaxException {
		for(int i=0;i<toplinks.size();i++) {
			 String url=toplinks.get(i).getAttribute("href");
			 
			 System.out.println(url);
			 
			 if(url.contains("RecipeAtoZ")) {
				URI url_link=new URI(url);
				url_link.toURL().openConnection().connect();
					
				 
			 }
			}
	}
	
	public void getAll_recipesLink() {
		  ArrayList<String> links = new ArrayList<>();

		  // loop through raw_recipes to fill the links array list
		  for (WebElement e : raw_recipes)
		  {
			  System.out.println(e.getAttribute("href"));
		       links.add(e.getAttribute("href"));
		  }
		  links.stream().forEach(l->System.out.println(l));
		  

		// List<WebElement> raw_ids = driver.findElements((By.className("rcc_rcpno")));
}
}

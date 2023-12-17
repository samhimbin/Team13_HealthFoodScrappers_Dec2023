package com.RecipeFoodCategory;

public class Lunch {
<<<<<<< HEAD
	
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
		  ArrayList<String> links = new ArrayList<String>();

		  // loop through raw_recipes to fill the links array list
		  for (WebElement e : raw_recipes)
		  {
			  System.out.println(e.getAttribute("href"));
		       links.add(e.getAttribute("href"));
		  }
		 
		  

		// List<WebElement> raw_ids = driver.findElements((By.className("rcc_rcpno")));
}
=======

>>>>>>> 3ed9a5a863dfdbf45dd167578f4360308e32c8eb
}

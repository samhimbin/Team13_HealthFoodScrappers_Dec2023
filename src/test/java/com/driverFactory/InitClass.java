package com.driverFactory;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
<<<<<<< HEAD
=======

import com.RecipeFoodCategory.Lunch;
>>>>>>> d5c4de118c157389bd84beb9238bb085bc003762
import com.Utilities.LoggerLoad;
import com.Utilities.PropertyReader;

public class InitClass {
	// we will give the initialization of web driver + initializing objects
	public static WebDriver driver;
	
<<<<<<< HEAD
=======
	//public static Lunch lunch;
>>>>>>> d5c4de118c157389bd84beb9238bb085bc003762

	@BeforeClass
	public void beforeclass() throws IOException {
		LoggerLoad.info("Launching WebDriver:");
		driver = DriverClass.webDriverLaunch();
		createPageObject();
	}

	public static void createPageObject() {
		LoggerLoad.info("Creating Objects:");
		// All the page objects will be called here
		
<<<<<<< HEAD
=======
		
>>>>>>> d5c4de118c157389bd84beb9238bb085bc003762

	}

	@BeforeMethod
	public void beforemethod() throws IOException {
		String urlName = PropertyReader.getPropFromProperty("config", "url");
		LoggerLoad.info("from prop file url = " + urlName);
		driver.get(urlName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterClass
	public void afterclass() {

		driver.close();

	}
}

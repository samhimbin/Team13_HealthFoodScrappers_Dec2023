package com.driverFactory;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
<<<<<<< HEAD
=======
<<<<<<< HEAD

//import com.PageObjects.HomePage;
=======
>>>>>>> 8f57850daeb46455ee35419cc1edfa14144bf33c
>>>>>>> e7eba61fd1005eb7b99431d1015939b93ad3358d
import com.Utilities.LoggerLoad;
import com.Utilities.PropertyReader;
public class InitClass {
	// we will give the initialization of web driver + initializing objects
	public static WebDriver driver;
<<<<<<< HEAD
	//public static HomePage hp;
=======
<<<<<<< HEAD
//	public static HomePage hp;
=======
>>>>>>> 8f57850daeb46455ee35419cc1edfa14144bf33c
>>>>>>> e7eba61fd1005eb7b99431d1015939b93ad3358d

	@BeforeClass
	public void beforeclass() throws IOException {
		LoggerLoad.info("Launching WebDriver:");
		driver = DriverClass.webDriverLaunch();
<<<<<<< HEAD
		//createPageObject();
=======
<<<<<<< HEAD
//		createPageObject();
>>>>>>> e7eba61fd1005eb7b99431d1015939b93ad3358d
	}

	/*public static void createPageObject() {
		LoggerLoad.info("Creating Objects:");
		// All the page objects will be called here
<<<<<<< HEAD
		//hp = new HomePage(driver);
=======
//		hp = new HomePage(driver);
=======
>>>>>>> 8f57850daeb46455ee35419cc1edfa14144bf33c
>>>>>>> e7eba61fd1005eb7b99431d1015939b93ad3358d

	}*/

	@BeforeMethod
	public void beforemethod() throws IOException {
		String urlName = PropertyReader.getPropFromProperty("config", "url");
		LoggerLoad.info("from prop file url = " + urlName);
		driver.get(urlName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

<<<<<<< HEAD
	@AfterClass
	public void afterclass() {

		// driver.close(); uncomment 

	}
=======
//	@AfterClass
//	public void afterclass() {
//
//		driver.close();
//
//	}
>>>>>>> e7eba61fd1005eb7b99431d1015939b93ad3358d
}

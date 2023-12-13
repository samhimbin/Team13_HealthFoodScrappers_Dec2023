package com.driverFactory;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.PageObjects.HomePage;
import com.Utilities.LoggerLoad;
import com.Utilities.PropertyReader;

public class InitClass {
	// we will give the initialization of web driver + initializing objects
	public static WebDriver driver;
	public static HomePage hp;

	@BeforeClass
	public void beforeclass() throws IOException {
		LoggerLoad.info("Launching WebDriver:");
		driver = DriverClass.webDriverLaunch();
		createPageObject();
	}

	public static void createPageObject() {
		LoggerLoad.info("Creating Objects:");
		// All the page objects will be called here
		hp = new HomePage(driver);

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

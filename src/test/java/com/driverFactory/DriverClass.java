package com.driverFactory;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeOptions;
import com.Utilities.LoggerLoad;
import com.Utilities.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverClass {
	
	public static WebDriver driver;
	
	public static WebDriver webDriverLaunch() throws IOException {

		String browserName = PropertyReader.getPropFromProperty("config", "browser");
		System.out.println("browser Name : "+ browserName);

		LoggerLoad.info("We are launching: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
<<<<<<< HEAD
			ChromeOptions options = new ChromeOptions();
			 options.addArguments("--headless");
			  driver = new ChromeDriver(options);
			
			//driver= new ChromeDriver();
=======
<<<<<<< HEAD
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);		
//			driver= new ChromeDriver();	
=======
			ChromeOptions options = new ChromeOptions();
			 options.addArguments("--headless");
			  driver = new ChromeDriver(options);
			//driver= new ChromeDriver();

>>>>>>> 8f57850daeb46455ee35419cc1edfa14144bf33c
>>>>>>> e7eba61fd1005eb7b99431d1015939b93ad3358d
		} 
		else if (browserName.equalsIgnoreCase("edge")) {
			LoggerLoad.info("We are launching: " + browserName);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			LoggerLoad.info("We are launching: " + browserName);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		return driver;
	}
}



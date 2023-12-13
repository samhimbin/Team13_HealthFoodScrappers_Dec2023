package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.LoggerLoad;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		LoggerLoad.info("In HomePage");
	}

	@FindBy(xpath = "//div[@id=\"logo\"]/img")
	WebElement homePageTiltle;

	public void getHomePageTitle() {
		System.out.println(homePageTiltle.getAttribute("alt"));

	}
}

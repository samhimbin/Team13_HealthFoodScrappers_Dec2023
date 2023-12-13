package com.TestScripts;

import org.testng.annotations.Test;

import com.driverFactory.InitClass;

public class HomePageValidation extends InitClass{

	@Test
	public void CheckElements() {
		hp.getHomePageTitle();
	}
}

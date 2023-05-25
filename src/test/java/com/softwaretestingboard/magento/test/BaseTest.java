package com.softwaretestingboard.magento.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.softwaretestingboard.magento.factory.DriverFactory;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.Searchs;
import com.softwaretestingboard.magento.pages.SigninScreen;
import com.softwaretestingboard.magento.pages.WhatsNew;
import com.softwaretestingboard.magento.pages.YogaShop;

public class BaseTest {
	
	
	DriverFactory drfact;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	WhatsNew whatsNew;
	Searchs searchs;
	YogaShop yogaShop;
	SoftAssert softAssert;
	SigninScreen signinScreen;
	

	
	@BeforeTest
	public void setUp() {
		drfact= new DriverFactory();
		
		prop = drfact.set_Prop();
		driver=drfact.setup(prop);
		homepage=new HomePage(driver);
		searchs =new Searchs(driver);
		softAssert=new SoftAssert();
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

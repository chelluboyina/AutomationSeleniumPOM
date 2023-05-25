package com.softwaretestingboard.magento.pages;

import org.openqa.selenium.WebDriver;

import com.softwaretestingboard.magento.utils.ElementUtil;

public class Mens {
	 private WebDriver driver;
	 private ElementUtil eleUtil;
	 
	 public Mens(WebDriver driver) {
		 this.driver=driver;
		 eleUtil = new ElementUtil(driver);
		 
	 }

}

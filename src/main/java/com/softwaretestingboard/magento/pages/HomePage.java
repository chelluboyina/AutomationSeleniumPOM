package com.softwaretestingboard.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softwaretestingboard.magento.utils.ElementUtil;




public class HomePage {

 private WebDriver driver;
 private ElementUtil eleUtil;
 
 public HomePage(WebDriver driver) {
	 this.driver=driver;
	 eleUtil = new ElementUtil(driver);
	 
 }
 
 private By newArrivals=By.id("ui-id-3");
 private By men=By.id("ui-id-5");
 private By women=By.id("ui-id-4");	
 private By search=By.id("search");	
 private By sale=By.id("ui-id-8");
 private By Signin=By.linkText("Sign In");
 
 
 
 public String getHomePageTitle() {
	String HomeTitile= driver.getTitle();
		System.out.println(HomeTitile);
	
 		return HomeTitile;
 }
 
 public String getHomePageURL() {
	
	
 		return driver.getCurrentUrl();
 }
 
 
 public WhatsNew navigateWhatsnew()  {
	//	driver.findElement(newArrivals).click();
	 System.out.println("before New");
	 eleUtil.waitForElementPresence(newArrivals, 3000);
		 eleUtil.doClick(newArrivals);	
		
		 System.out.println("After New");
	 return new WhatsNew(driver);		 		
	 }
 
 
 public void navigateMens() {
	// driver.findElement(men).click();
	 eleUtil.doClick(men);			
	 }
 
 
 public boolean isSearchElementPresent() {
	 
	 return eleUtil.doElementIsDisplayed(search);
 }
 
 
public boolean isMenElementPresent() {
	 
	 return eleUtil.doElementIsDisplayed(men);
 }
 
 
public boolean isWomenElementPresent() {
	 
	 return eleUtil.doElementIsDisplayed(women);
}
 
 
public boolean isSaleElementPresent() {
	 
	 return eleUtil.doElementIsDisplayed(sale);
}
 
 
 public void navigateWomens() {
	// driver.findElement(women).click();
	 eleUtil.doClick(women);
		
	 }
 
 
 public void navigateSale() {
		 eleUtil.doClick(sale);
			
		 }
 
 
public void doSearch(String item) { 
	 
	 driver.findElement(search).sendKeys(item);
	 driver.findElement(search).submit();
 }
 
  
public SigninScreen signinPage()  {
	
	 eleUtil.doClick(Signin);
		
	 return new SigninScreen(driver);		 		
	 }

}

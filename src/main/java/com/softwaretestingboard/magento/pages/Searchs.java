package com.softwaretestingboard.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softwaretestingboard.magento.utils.ElementUtil;

public class Searchs {

	private WebDriver driver;
	 private ElementUtil eleUtil;
	 
	 
	 public Searchs(WebDriver driver) {
		 this.driver=driver;
		 eleUtil = new ElementUtil(driver);
		 
	 }
	 
	 private By searchInput= By.xpath("//input[@id='search']");
	 private By searchButton= By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[2]/form/div[2]/button");
	 
	 private By searchResult=By.xpath("//span[contains(text(),'Search results for:')]");
	 private By advSearch=By.linkText("Advanced Search");
	 
	
	 public void searchItem(String item) {
			// driver.findElement(women).click();
		
			 
			 System.out.println(item);
			 eleUtil.doSendKeys(searchInput, item);
			 
			 eleUtil.doClick(searchButton);
			
		//		eleUtil.wait(3000);
		
				
			 
			 
			 }
	 
	
 public boolean isResultDisplayed() {
		 
		return eleUtil.doElementIsDisplayed(searchResult);
		
		
	 }
 
	
}

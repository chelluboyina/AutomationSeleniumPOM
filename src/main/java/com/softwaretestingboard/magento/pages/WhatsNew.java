package com.softwaretestingboard.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softwaretestingboard.magento.utils.ElementUtil;

public class WhatsNew {
	
	 private WebDriver driver;
	 private ElementUtil eleUtil;
	 
	 public WhatsNew(WebDriver driver) {
		 this.driver=driver;
		 eleUtil = new ElementUtil(driver);
		 
	 }
	 
	
	 private By hoodies=By.partialLinkText("Hoodies & Sweatshir");
	 private By jacket=By.partialLinkText("Jacke");
	 private By newInWomen=By.xpath("//span[contains(text(),'New in women')]");
	 private By newInmen=By.xpath("//span[contains(text(),'New in men')]");
	  
	 private By shopYoga=By.xpath("//span[contains(text(),'Shop New Yoga')]");
	 
	 
	 
	 public String getWhatsNewPageTitle() {
			String WhatsNewTitile= driver.getTitle();
				System.out.println(WhatsNewTitile);
			
		 		return WhatsNewTitile;
		 }
		 
	 public boolean isHoodiesDisplayed() {
		 
		 return eleUtil.doElementIsDisplayed(hoodies);
	 }
	 
	 public boolean isJacketDisplayed() {
		 
		 return eleUtil.doElementIsDisplayed(jacket);
	 }
	 
	 public boolean isNewWomenDisplayed() {
		 
		 return eleUtil.doElementIsDisplayed(newInWomen);
	 }
	 
	 
	 public boolean isNewMenDisplayed() {
		 
		 return eleUtil.doElementIsDisplayed(newInmen);
	 }
	 
	  public YogaShop navigateShopYoga() {
			// driver.findElement(women).click();
			 eleUtil.doClick(shopYoga);
				
			 return new YogaShop(driver);
			 }
	 
	 

}

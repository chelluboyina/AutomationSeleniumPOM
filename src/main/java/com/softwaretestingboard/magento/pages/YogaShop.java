package com.softwaretestingboard.magento.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softwaretestingboard.magento.utils.ElementUtil;

public class YogaShop {
	
	 private WebDriver driver;
	 private ElementUtil eleUtil;
	 
	 public YogaShop(WebDriver driver) {
		 this.driver=driver;
		 eleUtil = new ElementUtil(driver);
		 
	 }
	 
	 private By produts= By.xpath("//a");
	 
	 public String getYogaPageTitle() {
			String yogashopPageTitile= driver.getTitle();
				System.out.println("Title is:"+yogashopPageTitile);
			
		 		return yogashopPageTitile;
		 }
	 
	  public int getProductsCount() {
		 int count=eleUtil.waitForElementsVisible(produts, 200).size();
		 System.out.println("Count of links are: "+count);
		return count; 
	 }
	 
	 public void selectProduct(String itemselect) {
		 System.out.println("item is : "+itemselect);
		 List<WebElement> procuctsList=eleUtil.getElements(produts);
		 for(WebElement e:procuctsList) {
			 
			 String txt= e.getText();
			 
			 if(txt.equals(itemselect)) {
			 System.out.println(txt);
			 e.click();
			 break;
			 }
			 
		 }
		 
		 
		 
	 }
	 
}

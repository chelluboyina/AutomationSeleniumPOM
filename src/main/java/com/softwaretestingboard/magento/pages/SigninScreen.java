package com.softwaretestingboard.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softwaretestingboard.magento.utils.ElementUtil;

public class SigninScreen {
	 private WebDriver driver;
	 private ElementUtil eleUtil;
	 
	 public SigninScreen(WebDriver driver) {
		 this.driver=driver;
		 eleUtil = new ElementUtil(driver);
		 
	 }

	 private By user=By.id("email");
	 private By pass=By.id("pass");
	 private By signin=By.name("send");	
	 private By incorrectCap=By.cssSelector("body.customer-account-login.page-layout-1column:nth-child(2) div.page-wrapper:nth-child(4) main.page-main div.page.messages:nth-child(3) div:nth-child(2) div.messages div.message-error.error.message > div:nth-child(1)");

	 public boolean logIn(String user,String pass) {
		 
		 eleUtil.doSendKeys(this.user, user);
		 eleUtil.doSendKeys(this.pass, pass);
		 
		 eleUtil.doClick(signin);
		String s= eleUtil.doElementGetText(incorrectCap);
		
		System.out.println(s);
		if(s.contains("CAPTCHA")) {
		return true;
		}else
		return false;
		 
	 }
	 
	 
}

package com.softwaretestingboard.magento.test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.utils.Constants;

public class HomePageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void HomePageTitleTest() {
		
	String Homepage_title=	homepage.getHomePageTitle();
	//System.out.println(Homepage_title);
	AssertJUnit.assertEquals(Homepage_title, Constants.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void HomePageURLTest() {
		
		String Homepage_URL=	homepage.getHomePageURL();
		System.out.println(Homepage_URL);
		AssertJUnit.assertTrue(Homepage_URL.contains(Constants.HOME_PAGE_URL));
		}
	@Test(priority=3)
	public void isSearchExisted() {
		
		
		AssertJUnit.assertTrue(homepage.isSearchElementPresent());
		}
	@Test(priority=4)
	public void istypeOfSalesExisted() {
		
	//	softAssert.assertTrue(homepage.isMenElementPresent());
		AssertJUnit.assertTrue(homepage.isSaleElementPresent());
	//	softAssert.assertTrue(homepage.isWomenElementPresent());
		}
	
	
}

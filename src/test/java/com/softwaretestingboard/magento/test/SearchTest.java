package com.softwaretestingboard.magento.test;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
	
	
	@DataProvider
	public Object[][] searchData(){
		
		return new Object[][] {
			{"Jacket"},{"Top"},{"Hoodies"}
			
		};
	}
	
	
	@Test(priority=1, dataProvider="searchData")
	public void verifySearch(String itemsdata) {
		
		
		searchs.searchItem(itemsdata);
		
		
		AssertJUnit.assertTrue(searchs.isResultDisplayed());
		}
	
	
}

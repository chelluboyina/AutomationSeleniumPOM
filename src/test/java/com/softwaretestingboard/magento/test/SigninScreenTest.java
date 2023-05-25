package com.softwaretestingboard.magento.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.utils.Constants;
import com.softwaretestingboard.magento.utils.ExcelCode;


public class SigninScreenTest extends BaseTest{
	@BeforeClass
	public void NavigatetoSignInPage()  {
		signinScreen=	homepage.signinPage();
		
		
	}
	
	
	
	/*
	 * //@Test(priority=1) public void doLoginTest() {
	 * 
	 * Assert.assertTrue(signinScreen.logIn("roni_cost@example.com",
	 * "roni_cost3@example.com")); }
	 */
	
	@DataProvider
	public Object[][] getLoginData() {
		
	return ExcelCode.getTestData(Constants.LOGIN_EXCEL_SHEETNAME);
		
	}
	
	@Test(dataProvider="getLoginData")
	public void doLoginTestWithExcel(String user,String pass) {
		
		Assert.assertTrue(signinScreen.logIn( user, pass));	
	}
	
}

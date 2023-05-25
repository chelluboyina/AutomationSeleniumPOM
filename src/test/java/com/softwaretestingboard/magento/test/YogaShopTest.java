package com.softwaretestingboard.magento.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.utils.Constants;

public class YogaShopTest extends BaseTest{
	
	
	@BeforeClass
	public void NavigatetoWhatsNewPage()  {
		whatsNew=	homepage.navigateWhatsnew();
		yogaShop=	whatsNew.navigateShopYoga();
		
		
	}


@Test 
public void yogaShopTileTest() {
	
	String yogaPageTitle=yogaShop.getYogaPageTitle();
	Assert.assertEquals(yogaPageTitle, Constants.YOGASHOP_PAGE_TITLE);
}
//@Test 
public void yogaShopProducts() {
	
	yogaShop.selectProduct("Echo Fit Compression Short");
	yogaShop.getProductsCount();
	
}
}

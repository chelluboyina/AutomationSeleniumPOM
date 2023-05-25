package com.softwaretestingboard.magento.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softwaretestingboard.magento.utils.Constants;

public class WhatsNewTest extends BaseTest{
	@BeforeClass
	public void NavigatetoWhatsNewPage()  {
		whatsNew=	homepage.navigateWhatsnew();
		
		
	}
	
	
	
	@Test(priority=1)
	public void whatsNewPageTitleTest() {
		
	String WhatsNew_title=	whatsNew.getWhatsNewPageTitle();
	AssertJUnit.assertEquals(WhatsNew_title, Constants.WHATSNEW_PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void isHoodiesExisted() {
		
		
		AssertJUnit.assertTrue(whatsNew.isHoodiesDisplayed());
		}
	
	
	@Test(priority=3)
	public void isJacketExisted() {
		
		
		AssertJUnit.assertTrue(whatsNew.isJacketDisplayed());
		}
	
	
	@Test(priority=5)
	public void isNewMenExisted() {
		
		
		AssertJUnit.assertTrue(whatsNew.isNewMenDisplayed());
		}
	
	
	@Test(priority=4)
	public void isNewWomenExisted() {
		
		
		AssertJUnit.assertTrue(whatsNew.isNewWomenDisplayed());
		}


}

package com.softwaretestingboard.magento.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({Listener.class})
public class NewTest {
  @Test(priority=1)
  public void f1() {
	  System.out.println("test ");
  }
  @Test(priority=2)
  public void f2() {
	  System.out.println("test2");
	  Assert.assertTrue(false);
  }
  @Test(priority=3)
  public void f3() {
	  System.out.println("test3");
  }
  @Test(priority=4)
  public void f4() {
	  System.out.println("test4");
	  Assert.assertTrue(false);
  }
}

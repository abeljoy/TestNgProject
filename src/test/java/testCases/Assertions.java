package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;



public class Assertions extends BaseClass{
	@Test(priority=1)
	  public void softAssertion() throws InterruptedException {
		  SoftAssert sa = new SoftAssert();
		  System.out.println("Soft Assert method started");
		  sa.assertTrue(false);
		  System.out.println("Soft Assert method executed");
		  sa.assertAll();
		  //assertAll  must include to capture the correct failure.
	  }
	@Test(priority=2)
	  public void hardAssertion() throws InterruptedException {
		  System.out.println("Hard Assert method started");
		  Assert.assertFalse(false, "System not working as expected");
		  System.out.println("Hard Assert method executed");
	  }

}

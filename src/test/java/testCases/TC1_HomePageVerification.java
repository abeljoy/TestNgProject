package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.HomePage;

public class TC1_HomePageVerification extends BaseClass {
	HomePage homePage; //need to create object for every page
	@BeforeClass // every page have to create won object and browser init, conflict occur when base class and this class have @beforclass , so we remove only @beforeclass from baseclass
	public void setUp() {
		browserInitialization();
		homePage = new HomePage();
	}
	
  @Test
  public void verifyHomePage() {
	  homePage.verifyHomePageDisplayed();
  }
  //@afterclass already in baseclass, so no need to call here
}

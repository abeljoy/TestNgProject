package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.HomePage;
import pages.SearchPage;
import pages.SignInPage;
import utilities.ExcelUtil;
import org.openqa.selenium.JavascriptExecutor;


public class TC4_VerifyNavigation extends BaseClass {
	HomePage homePage;
	SearchPage searchPage;
	SignInPage signInpage;

	@BeforeClass
	public void setUp() throws IOException {
		browserInitialization();
		homePage = new HomePage();
		searchPage = new SearchPage();
		signInpage = new SignInPage();
		ExcelUtil.setExcelFile();
	  }

	 @Test
	  public void userSelectReprintTicket() throws InterruptedException  {
		 Thread.sleep(5000);
		 ((JavascriptExecutor) getWebDriver()).executeScript("window.scrollBy(0,1000)");
		  homePage.selectReprintTicket();
		  Thread.sleep(2000);
	  }
	 
	  @Test(dependsOnMethods = "userSelectReprintTicket")

	  public void verifySignin() throws InterruptedException {
          signInpage.verifySignInDisplayed();
		  Thread.sleep(2000);
	  }
		
	  
	  @Test(dependsOnMethods = "verifySignin")
	  public void getParentWindow() throws InterruptedException {
		  String window = homePage.getCurrentWindow();
		  getWebDriver().switchTo().window(window);
		  Thread.sleep(5000);
	  }
	  
	  @Test(dependsOnMethods = "getParentWindow")
	  public void verifyHomePage() {
		  homePage.verifyHomePageDisplayed();
	  }
}

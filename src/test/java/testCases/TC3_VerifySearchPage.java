package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.HomePage;
import pages.SearchPage;
import utilities.ExcelUtil;

public class TC3_VerifySearchPage extends BaseClass {
	HomePage homePage;
	SearchPage searchPage;

	public TC3_VerifySearchPage() { //constructor creation
		PageFactory.initElements(getWebDriver(), this);
	}
	@FindBy(xpath="//label[contains(text(),'One way')]")
	public WebElement oneWayLnk;

	

	@BeforeClass
	public void setUp() {
		browserInitialization();
		homePage = new HomePage();
	}
	 @Test
	  public void userSelectTravelType()  {
		  homePage.selectOneWay();
	  }
	  
	  @Test(dependsOnMethods = "userSelectTravelType")
	  public void userEntersTraveDetails() throws InterruptedException {
		  homePage.sendToAndFrom(ExcelUtil.getCellData(1, 1),ExcelUtil.getCellData(1, 2));
		  homePage.selectTravelDate("SEPTEMBER", "20");
		  homePage.selectAdultCount(ExcelUtil.getCellData(1, 5));
	  }
	  
	  @Test(dependsOnMethods = "userEntersTraveDetails")
	  public void userClickSearch() throws InterruptedException {
		  homePage.clickFindFlight();
	  }
	  

	  @Test(dependsOnMethods = "userClickSearch")
	  public void userVerifyTravelData() throws Exception {
		  searchPage.verifyTravelDetails(ExcelUtil.getCellData(1, 1),
				  ExcelUtil.getCellData(1, 2),ExcelUtil.getCellData(1, 3),
				  ExcelUtil.getCellData(1, 4),ExcelUtil.getCellData(1, 5));
		  takeScreenshot("TC2_TRN_Verify Travel Data");
		  
	  }
	  
	  
	  
}
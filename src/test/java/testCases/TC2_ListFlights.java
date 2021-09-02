package testCases;

import java.io.IOException;
import org.testng.annotations.Parameters;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pages.HomePage;
import pages.SearchPage;
import utilities.ExcelUtil;

public class TC2_ListFlights extends BaseClass {
	HomePage homePage;
	SearchPage searchPage;

	@BeforeClass
	public void setUp() throws IOException {
		browserInitialization();
		homePage = new HomePage();
		searchPage = new SearchPage();
		ExcelUtil.setExcelFile();
	  }
	
	 @Test
	  public void userSelectTravelType()  {
		  homePage.selectOneWay();
		  
	  }
	  
	  @Test(dependsOnMethods = "userSelectTravelType")
	  @Parameters({"source","destination"})
	  public void userEntersTraveDetails(String src,String dst) throws InterruptedException {
		 homePage.sendToAndFrom(src,dst);
		 // homePage.sendToAndFrom(ExcelUtil.getCellData(1, 1),ExcelUtil.getCellData(1, 2));

		  homePage.selectTravelDate(ExcelUtil.getCellData(1, 3),ExcelUtil.getCellData(1, 4));
		  homePage.selectAdultCount(ExcelUtil.getCellData(1, 5));
		  //homePage.selectChildCount();
		  //homePage.selectInfantCount();
	  }
	  
	  @Test(dependsOnMethods = "userEntersTraveDetails")
	  public void userClickSearch() throws InterruptedException {
		  homePage.clickFindFlight();
	  }
	  
	  @Test(dependsOnMethods = "userClickSearch")
	  public void userVerifyFlightsListed() throws Exception {
		  int count = searchPage.getNumberOfFlightsListed();
		  System.out.println("Number of Flights listed is "+count);
		  Assert.assertTrue(count>0);
		  takeScreenshot("TC2_ListFlights verify flights");
	  }
 
}

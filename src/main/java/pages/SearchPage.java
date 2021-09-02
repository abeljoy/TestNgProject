package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClass.BaseClass;

public class SearchPage extends BaseClass {
	
	public SearchPage() {
		PageFactory.initElements(getWebDriver(), this);
	}
	
	
	@FindBy(xpath = "//li[contains(@class,'flightItem')]")
	public List<WebElement> flightsList;
	@FindBy(xpath = "//label[contains(text(),'IndiGo')]/preceding-sibling::input")
	public List<WebElement> checkBx1;
	@FindBy(xpath = "//h1[contains(@class,'lightDetailHeading')]/span")
	public WebElement headingTxt;
	@FindBy(xpath = "//div[contains(@class,'travellers')]/em")
	public WebElement dateTxt;
	@FindBy(xpath = "//div[contains(@class,'travellers')]/span")
	public WebElement adultCountTxt;
	
	
	
	
	public int getNumberOfFlightsListed() {
		int numberOfFlights = flightsList.size();
		return numberOfFlights;
	}
	public void verifyTravelDetails(String source, String destination, String monthYear, String day,
			String adultCountVal) {
		String sourceExp = source.replaceAll(",.*", "");
		String destExp = destination.replaceAll(",.*", "");
		String monthYearExp = monthYear.replaceAll("[0-9]", "");
		String dayMonthExp = day+" "+monthYearExp.substring(0,3);
		Assert.assertTrue(headingTxt.getText().contains(sourceExp),"Source is not showing as expected in search page");
		Assert.assertTrue(headingTxt.getText().contains(destExp),"Destination is not showing as expected in search page");
		Assert.assertTrue(dateTxt.getText().toUpperCase().contains(dayMonthExp),"Month is not showing as expeccted in search page");
		Assert.assertTrue(adultCountTxt.getText().contains(adultCountVal),"No.of adults is not showing as expeccted in search page");
	
	}
	
}	

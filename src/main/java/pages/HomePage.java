package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import java.lang.*;


import baseClass.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() { //constructor creation
		PageFactory.initElements(getWebDriver(), this);
	}
	@FindBy(xpath="//label[contains(text(),'Round trip')]")
	public WebElement roundTripLnk;
	
	@FindBy(xpath="//label[contains(text(),'One way')]")
	public WebElement oneWayLnk;
	
	@FindBy(xpath="//label[contains(text(),'Multi-city')]")
	public WebElement multiCityLnk;
	@FindBy(xpath="//input[@name ='Origin']")
	public WebElement origin;
	@FindBy(xpath="//input[@name ='Destination']")
	public WebElement destination;
	@FindBy(xpath="//input[@name='StartDate']")
	public WebElement startDate;
	@FindBy(xpath="//div[@id='calendar']//h3")
	public WebElement currentMonthYear;
	@FindBy(xpath="//div[@id='calendar']//a[@class='forward']")
	
	public WebElement forwardOptionCalender;
	@FindBy(xpath="//select[@name='AdultsFlight']")
	public WebElement numberOfAdults;
	@FindBy(xpath="//i[contains(text(),'flights')]")
	public WebElement findFlights;
	@FindBy(xpath = "//select[@name='ChildrenFlight']")
	public WebElement numberOfChildren;
	@FindBy(xpath = "//select[@name='InfantsFlight']")
	public WebElement numberOfInfants;
	@FindBy(xpath = "//div[@class='loader']")
	public WebElement loaderImg;
	public By dateCal = By.xpath("//li[contains(text(),'%s')]");
	@FindBy(xpath = "//a[contains(text(),'my trip')]")
	public WebElement reprintTicket;

	
	public void verifyHomePageDisplayed() {
		Assert.assertTrue(roundTripLnk.isDisplayed(),"Round trip Not Displayed as expected");
		//return type boolean false/true
		//true - pass, false - error message will display
		Assert.assertTrue(oneWayLnk.isDisplayed(),"Oneway link Not Displayed as expected");
		Assert.assertTrue(multiCityLnk.isDisplayed(),"Multicity link Not Displayed as expected");
	}
	public void selectOneWay() {
		oneWayLnk.click();
	}
	public void sendToAndFrom(String src,String dst) {
		origin.clear();
		origin.sendKeys(src);
		destination.clear();
		destination.sendKeys(dst);
		
	}
//	public void selectTravelDate() throws InterruptedException {
//		startDate.click();
//		Thread.sleep(2000);
//	//	do {
//		//	forwardOptionCalender.click();
//		//} while (!currentMonthYear.getText().contentEquals("JUNE 2021"));
//		//WebElement datesel = getWebDriver().findElement(By.xpath("//li[contains(text(),'"+"15"+"')]"));
//		//datesel.click();
//		//WebElement currentMonth = driver.findElement(By.xpath("//div[@class='month current']//h3"));
//		System.out.println("Current month: "+currentMonthYear.getText());
//		while(!currentMonthYear.getText().contains("SEPTEMBER 2021")) {
//			Thread.sleep(2000);
//			forwardOptionCalender.click();
//	}
	
//		WebElement datesel = getWebDriver().findElement(By.xpath("//li[contains(text(),'"+"16"+"')]"));
	//	datesel.click();

		
	//}
	public void selectTravelDate(String monthYear, String day) throws InterruptedException {
		startDate.click();
		Thread.sleep(2000);
		
//		System.out.println("Current Month & Year.." + curMnthYr.getText());
		if (!currentMonthYear.getText().contentEquals(monthYear)) {
			do {
				forwardOptionCalender.click();
			} while (!currentMonthYear.getText().contentEquals(monthYear));
		}
		
//		WebElement dateSel = getWebDriver().findElement(By.xpath("//li[contains(text(),'"+day+"')]"));
//		dateSel.click();
		getWebDriver().findElement(dynamic(dateCal, day)).click();
		
	}

	public void selectAdultCount(String adultCount) {
		Select dropDown = new Select(numberOfAdults);
		dropDown.selectByVisibleText(adultCount);
	}
	
	public void selectChildCount() {
		Select dropDown = new Select(numberOfChildren);
		dropDown.selectByValue("2");
	}
	
	public void selectInfantCount() {
		Select dropDown = new Select(numberOfInfants);
		dropDown.selectByIndex(0);
	}
	public void clickFindFlight() {
		findFlights.click();
		waitForElementInvisible(loaderImg);
	}
	public void selectReprintTicket() throws InterruptedException {
		reprintTicket.click();
		Thread.sleep(2000);
	}
	
	public String getCurrentWindow() throws InterruptedException {
		String currentWindow = getWebDriver().getWindowHandle();
		return currentWindow;
	}
}

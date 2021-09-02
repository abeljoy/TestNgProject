package baseClass;


import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	//@BeforeClass 
	public void browserInitialization() {
		WebDriverManager.chromedriver().setup();
		setWebDriver(new ChromeDriver());
		getWebDriver();
		getWebDriver().manage().window().maximize();
		String url = "https://in.musafir.com/";
		getWebDriver().get(url);
	}
	public void setWebDriver(RemoteWebDriver driverValue) {
		driver.set(driverValue);
	}

	public RemoteWebDriver getWebDriver() {
		return driver.get();
	}
	
	

	@AfterClass
	public void closeBrowser() {
		getWebDriver().quit();
	}
	public void waitForElementInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getWebDriver(),30);
     	                    wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public By dynamic(By path,String dynamicPath) {
		By dynamicXpath = null;
		String locatorString = path.toString();
		String locatorType = "";
		String locatorPath = "";
		String[] locatorArray = locatorString.split(":");
		if (locatorArray.length<=2) {
			locatorPath = locatorArray[1].toString();
		}
		else {
			locatorType = locatorArray[0].toString();
			locatorPath = locatorString.replace(locatorType+":","");
		}
		locatorPath = String.format(locatorPath, dynamicPath);
		dynamicXpath = By.xpath(locatorPath);
		return dynamicXpath;
		
	}
	public void takeScreenshot(String stepName) throws Exception {
		Date date = new Date();
		String timestamp = stepName + date.getTime();
		String fileWithPath = System.getProperty("user.dir") + 
				"\\screenshots\\" + timestamp + ".png";

		TakesScreenshot scrShot = ((TakesScreenshot)getWebDriver());

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
}

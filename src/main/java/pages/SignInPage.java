package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClass.BaseClass;

public class SignInPage extends BaseClass{
	public SignInPage() {
		PageFactory.initElements(getWebDriver(), this);
	}
	@FindBy(xpath = "//input[@id='SignIn_btnLogin']")
	public WebElement signInLnk;
	
	public void verifySignInDisplayed() {
		Assert.assertTrue(signInLnk.isDisplayed(), "Sign in link Not Displayed as expected");
	}

}

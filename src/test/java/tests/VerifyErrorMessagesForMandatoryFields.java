package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;
import pages.LoginPage;
import pages.MainPage;
import util.BrowserFactory;

/*Test Case - Verify error messages for mandatory fields.

Steps to Automate:
1. Open url
2. Click on sign in link.
3. Enter email address and click Register button.
4. Leave the mandatory fields (marked with *) blank and click Register button.
5. Verify that error has been displayed for the mandatory fields.*/

public class VerifyErrorMessagesForMandatoryFields {

	WebDriver driver;

	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.LaunchBrowser();
	}

	@Test
	public void TestVerifyErrorMessagesForMandatoryFields() {
		MainPage mainp = PageFactory.initElements(driver, MainPage.class);
		mainp.ClickOnSignInButton();

		LoginPage loginp = PageFactory.initElements(driver, LoginPage.class);
		loginp.Fill_CreatAccountEmail_Field();
		loginp.Click_CreateAnAccount_Button();

		CreateAnAccountPage createaccp = PageFactory.initElements(driver, CreateAnAccountPage.class);
		createaccp.Click_Register_Button();
		createaccp.VerifyErrorAlertForMandatoryFields();

	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.CloseBrowser();
	}

}

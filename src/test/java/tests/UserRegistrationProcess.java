package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import util.BrowserFactory;
import util.ExcelReader;

/*Test Case - Automate User Registration Process

Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter your email address in 'Create and account' section.
4. Click on Create an Account button.
5. Enter your Personal Information, Address and Contact info.
6. Click on Register button.
7. Validate that user is created.*/

public class UserRegistrationProcess {
	WebDriver driver;

	// 1. Open this url http://automationpractice.com/index.php
	// 2. Click on sign in link.
	// Starting browser and navigating to website
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.LaunchBrowser();
	}

	@Test
	public void TestUserRegistrationProcess() {

		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String FirstName = reader.getCellData("Sheet3", "FirstName", 2);
		String LastName = reader.getCellData("Sheet3", "LastName", 2);
		String Password = reader.getCellData("Sheet3", "Password", 2);
		String day = reader.getCellData("Sheet3", "day", 2);
		String month = reader.getCellData("Sheet3", "month", 2);
		String year = reader.getCellData("Sheet3", "year", 2);
		String Company = reader.getCellData("Sheet3", "Company", 2);
		String Address = reader.getCellData("Sheet3", "Address", 2);
		String City = reader.getCellData("Sheet3", "City", 2);
		String State = reader.getCellData("Sheet3", "State", 2);
		String ZipCode = reader.getCellData("Sheet3", "ZipCode", 2);
		String Country = reader.getCellData("Sheet3", "Country", 2);
		String alias = reader.getCellData("Sheet3", "alias", 2);

		MainPage MainP = PageFactory.initElements(driver, MainPage.class);
		MainP.ClickOnSignInButton();

		LoginPage LoginP = PageFactory.initElements(driver, LoginPage.class);
		// 3. Enter your email address in 'Create and account' section.
		LoginP.Fill_CreatAccountEmail_Field();
		// 4. Click on Create an Account button.
		LoginP.Click_CreateAnAccount_Button();

		CreateAnAccountPage CreateAcc = PageFactory.initElements(driver, CreateAnAccountPage.class);
		// 5. Enter your Personal Information, Address and Contact info.
		CreateAcc.Click_Mr_RadioButton();
		CreateAcc.Fill_FirstName_Field(FirstName);
		CreateAcc.Fill_LastName_Field(LastName);
		CreateAcc.Fill_Password_Field(Password);
		CreateAcc.SelectDay_Selection(day);
		CreateAcc.SelectMonth_Selection(month);
		CreateAcc.SelectYear_Selection(year);
		CreateAcc.Click_Newsletter_CheckBox();
		CreateAcc.Click_SpecialOffer_CheckBox();
		CreateAcc.Fill_Address_Company_Field(Company);
		CreateAcc.Fill_Address1_Field(Address);
		CreateAcc.Fill_City_Field(City);
		CreateAcc.Select_State_Field(State);
		CreateAcc.Fill_ZipCode_Field(ZipCode);
		CreateAcc.Select_Country_Field(Country);
		CreateAcc.Fill_CellPhone_Field();
		CreateAcc.Fill_AliasAddress_Field(alias);
		// 6. Click on Register button.
		CreateAcc.Click_Register_Button();

		// 7. Validate that user is created.
		MyAccountPage MyAccP = PageFactory.initElements(driver, MyAccountPage.class);
		MyAccP.Assert_NameOnAccount(FirstName, LastName);
	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.CloseBrowser();
	}
}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.OrderPage;
import pages.ProductPage;
import pages.TshirtsPage;
import util.BrowserFactory;
import util.ExcelReader;

/*Test Case - Automate End to End Buy Order functionality.

Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the second product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Increase quantity to 2.
8. Select size 'L'
9. Select color.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Complete the buy order process till payment.
13. Make sure that Product is ordered.*/

public class BuyOrderFunctionality {

	WebDriver driver;

	// Starting browser and navigating to website
	// 1. Open link http://automationpractice.com/index.php
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.LaunchBrowser();
	}

	// The actual Test
	@Test
	public void TestBuyOrderFunctionality() throws InterruptedException {
		
		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String username = reader.getCellData("LoginInfo", "username", 2);
		String password = reader.getCellData("LoginInfo", "password", 2);

		MainPage MainP = PageFactory.initElements(driver, MainPage.class);
		MainP.ClickOnSignInButton();

		// 2. Login to the website.
		LoginPage LoginP = PageFactory.initElements(driver, LoginPage.class);
		LoginP.Enter_EMail_Address(username);
		LoginP.Enter_Password(password);
		LoginP.Click_Signin_Button();

		MyAccountPage MyAcc = PageFactory.initElements(driver, MyAccountPage.class);
		// 3. Move your cursor over Women's link.
		MyAcc.Hover_Over_Women_Button();
		// 4. Click on sub menu 'T-shirts'.
		MyAcc.Click_Tshirts_Button();

		TshirtsPage ts = PageFactory.initElements(driver, TshirtsPage.class);
		// 5. Mouse hover on the first product displayed.
		ts.Hover_Over_Product();
		// 6. 'More' button will be displayed, click on 'More' button.
		ts.Click_More_Button_Product_One();

		ProductPage ProdP = PageFactory.initElements(driver, ProductPage.class);
		// 7. Increase quantity to 2.
		ProdP.Enter_Quantity("2");
		// 8. Select size 'L'
		ProdP.Select_Size("L");
		// 9. Select color.
		ProdP.Select_Color();
		// 10. Click 'Add to Cart' button.
		ProdP.Click_AddToCart_Button();
		// 11. Click 'Proceed to checkout' button.
		ProdP.Click_ProceedToCheckout_Button();

		// 12. Complete the buy order process till payment.
		OrderPage OrderP = PageFactory.initElements(driver, OrderPage.class);
		OrderP.Click_ProceedToCheckout();
		OrderP.Click_ProceedToCheckout_Address_Page();
		OrderP.Click_CheckBox_AgreeToTerms_Shipping_Page();
		OrderP.Click_ProceedToCheckout_Shipping_Page();
		OrderP.Click_PayByBankWire_Payment_Page();
		OrderP.Click_IConfirmMyOrder_Page();
		// 13. Make sure that Product is ordered.
		OrderP.Assert_Order_Confirmation();

	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.CloseBrowser();
	}

}
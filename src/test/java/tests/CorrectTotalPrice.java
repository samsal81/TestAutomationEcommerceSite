package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.TshirtsPage;
import util.BrowserFactory;
import util.ExcelReader;

/*Test Case - Verify that Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page.
Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the second product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Make sure quantity is set to 1.
8. Select size 'M'
9. Select color of your choice.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Change the quantity to 2.
13. Verify that Total price is changing and reflecting correct price.*/

public class CorrectTotalPrice {
	WebDriver driver;

	// Starting browser and navigating to website
	// 1. Open link http://automationpractice.com/index.php
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.LaunchBrowser();
	}

	@Test
	public void TestCorrectTotalPrice() throws InterruptedException {

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
		// 7. Make sure quantity is set to 1.
		ProdP.Enter_Quantity("1");
		// 8. Select size 'L'
		ProdP.Select_Size("L");
		// 9. Select color.
		ProdP.Select_Color();
		// 10. Click 'Add to Cart' button.
		ProdP.Click_AddToCart_Button();
		// 11. Click 'Proceed to checkout' button.
		ProdP.Click_ProceedToCheckout_Button();
		// 12. Change the quantity to 2.
		// 13. Verify that Total price is changing and reflecting correct price.
		ProdP.TestTotalCalculation();

		Thread.sleep(5000);
	}

	// Closing browser
	@AfterMethod
	public void CloseBrowser() {
		BrowserFactory.CloseBrowser();
	}
}

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

public class test {
	
	WebDriver driver;
	
	@BeforeMethod
	public void StartBrowser() {
		driver = BrowserFactory.LaunchBrowser();
	}
		
	@Test
	public void testclick() throws InterruptedException {
		
		MainPage MainP = PageFactory.initElements(driver, MainPage.class);
		MainP.ClickOnSignInButton();
		
		LoginPage LoginP = PageFactory.initElements(driver, LoginPage.class);
		LoginP.Enter_EMail_Address("samsal81@usa.com");
		LoginP.Enter_Password("abc123");
		LoginP.Click_Signin_Button();
		
		MyAccountPage MyAcc = PageFactory.initElements(driver, MyAccountPage.class);
		MyAcc.Hover_Over_Women_Button();
		MyAcc.Click_Tshirts_Button();
		
		TshirtsPage ts = PageFactory.initElements(driver, TshirtsPage.class);
		ts.Hover_Over_Product();
		ts.Click_More_Button_Product_One();
		
		ProductPage ProdP = PageFactory.initElements(driver, ProductPage.class);
		ProdP.Enter_Quantity("3");
		ProdP.Select_Size("L");
		ProdP.Select_Color();
		ProdP.Click_AddToCart_Button();
		ProdP.Click_ProceedToCheckout_Button();
		
		OrderPage OrderP = PageFactory.initElements(driver, OrderPage.class);
		OrderP.Click_ProceedToCheckout();
		OrderP.Click_ProceedToCheckout_Address_Page();
		OrderP.Click_CheckBox_AgreeToTerms_Shipping_Page();
		OrderP.Click_ProceedToCheckout_Shipping_Page();
		OrderP.Click_PayByBankWire_Payment_Page();
		OrderP.Click_IConfirmMyOrder_Page();
		System.out.println(OrderP.Get_OrderReference_Text());
		OrderP.Click_MyAccount_Button();
		
		MyAcc.Click_OrderHistoryAndDetails_Button();
		
		Thread.sleep(4000);
		
	}
	
	
	  @AfterMethod public void CloseBrowser() { 
		  BrowserFactory.CloseBrowser(); 
		  }
	 
}
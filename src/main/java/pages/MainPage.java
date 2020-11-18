package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Sign in')]")
	WebElement Sign_in_Button;
	@FindBy(how = How.XPATH, using = "//a[@title='Women']")
	WebElement Women_Button;
	@FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement Tshirts_Button;
	@FindBy(how = How.XPATH, using = "//div/a[@title='Contact Us']")
	WebElement ContactUs_Button;

	// InteractiveMethods
	public void ClickOnSignInButton() {
		Sign_in_Button.click();
	}
	
	public void Hover_Over_Women_Button() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Women_Button).perform();
	}

	public void Click_Tshirts_Button() {
		Tshirts_Button.click();
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public void Click_ContactUS_Button() {
		ContactUs_Button.click();
	}

}

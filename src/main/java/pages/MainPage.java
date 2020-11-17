package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
	
	WebDriver driver;
	
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Sign in')]")WebElement Sign_in_Button;
	
	public void ClickOnSignInButton() {
		Sign_in_Button.click();
	}

}

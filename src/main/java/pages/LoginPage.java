package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement Email_Address_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']") WebElement SignIn_Button;
	
	public void Enter_EMail_Address(String Email) {
		Email_Address_Field.sendKeys(Email);
	}
	
	public void Enter_Password(String Password) {
		Password_Field.sendKeys(Password);
	}
	
	public void Click_Signin_Button() {
		SignIn_Button.click();
	}
}

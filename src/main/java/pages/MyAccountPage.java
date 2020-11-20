package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	//Element Library
	@FindBy(how = How.XPATH, using = "//a[@title='Women']")
	WebElement Women_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement Tshirts_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='center_column']/div/div[1]/ul/li[1]/a")
	WebElement OrderHistoryAndDetails_Button;
	@FindBy(how = How.XPATH, using = "//a[@class='account']/span")
	WebElement NameOnAccount;

	//InteractiveMethods
	public void Hover_Over_Women_Button() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Women_Button).perform();
	}

	public void Click_Tshirts_Button() {
		Tshirts_Button.click();
	}

	public void Click_OrderHistoryAndDetails_Button() {
		OrderHistoryAndDetails_Button.click();
	}
	
	public void Assert_NameOnAccount(String FirstName, String LastName) {
		String FullName = FirstName + " " + LastName;
		assertEquals(FullName, NameOnAccount.getText());
	}
}

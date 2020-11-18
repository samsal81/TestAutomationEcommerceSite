package pages;

import org.openqa.selenium.WebDriver;

public class ContactUsPage {

	WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
}

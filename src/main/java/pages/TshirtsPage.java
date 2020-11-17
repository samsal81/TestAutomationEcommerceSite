package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TshirtsPage {
	
	WebDriver driver;
	
	public TshirtsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")WebElement More_Button_Product_One;
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")WebElement Product_Image;
	
	//InteractiveMethods
	public void Hover_Over_Product() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Product_Image).perform();
	}
	
	public void Click_More_Button_Product_One() {
		More_Button_Product_One.click();
	}

}

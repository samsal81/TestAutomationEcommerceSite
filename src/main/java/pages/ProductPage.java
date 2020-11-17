package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='quantity_wanted']")WebElement Quantity_Wanted;
	@FindBy(how = How.XPATH, using = "//select[@id='group_1']")WebElement Size_Selection;
	@FindBy(how = How.XPATH, using = "//a[@id='color_14']")WebElement Select_Color;
	@FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button")WebElement AddToCart_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")WebElement ProceedToCheckout_Button;
	
	public void Enter_Quantity(String quantity) {
		Quantity_Wanted.clear();
		Quantity_Wanted.sendKeys(quantity);
	}
	
	public void Select_Size(String Size) {
		Select dropdown = new Select(Size_Selection);
		dropdown.selectByVisibleText(Size);
	}
	
	public void Select_Color() {
		Select_Color.click();
	}
	
	public void Click_AddToCart_Button() {
		AddToCart_Button.click();
	}
	
	public void Click_ProceedToCheckout_Button(){
		ProceedToCheckout_Button.click();
	}

}

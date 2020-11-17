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
	@FindBy(how = How.XPATH, using = "//a[@class='addToWishlist wishlistProd_1']")WebElement wishlistProduct;
	@FindBy(how = How.XPATH, using = "//p[@class='fancybox-error']")WebElement wishlist_ErrorBox;
	
	//InteractiveMethods
	public void Hover_Over_Product() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Product_Image).perform();
	}
	
	public void Click_More_Button_Product_One() {
		More_Button_Product_One.click();
	}
	
	public void Click_wishlistProduct() {
		wishlistProduct.click();
	}
	
	public void Verify_wishlist_ErrorBox() {
		if(wishlist_ErrorBox.getText().contains("You must be logged in to manage your wishlist.")) {
			System.out.println("Success! Error message displayed");
		}else {
			System.out.println("Failure, Error message didn't display");
		}
	}

}

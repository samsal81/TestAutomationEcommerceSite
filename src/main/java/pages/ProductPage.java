package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	WebDriver driver;
	double OldTotal;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='quantity_wanted']")WebElement Quantity_Wanted;
	@FindBy(how = How.XPATH, using = "//select[@id='group_1']")WebElement Size_Selection;
	@FindBy(how = How.XPATH, using = "//a[@id='color_14']")WebElement Select_Color;
	@FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button")WebElement AddToCart_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")WebElement ProceedToCheckout_Button;
	@FindBy(how = How.XPATH, using = "//a[@class='cart_quantity_up btn btn-default button-plus']")WebElement IncreaseQuantity_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='total_product_price_1_1_407271']")WebElement TotalProductPrice;
	@FindBy(how = How.XPATH, using = "//*[@id='product_price_1_1_407271']/span")WebElement ProductPrice;
	
	//InteractiveMethods
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
	
	public void Click_IncreaseQuantity_Button() {
		IncreaseQuantity_Button.click();
	}
	
	public void StoreCurrentTotal() {
		String CurrentTotal;
		CurrentTotal = TotalProductPrice.getText();
		double DblCurrentTotal = Double.parseDouble(CurrentTotal);
		double OldTotal = DblCurrentTotal;
	}
	public void TestCalculation() {
		String ModifiedTotal;
		ModifiedTotal = TotalProductPrice.getText();
		double DblModifiedTotal = Double.parseDouble(ModifiedTotal);
		String ProductPrc;
		ProductPrc = ProductPrice.getText();
		double DblProductPrc = Double.parseDouble(ProductPrc);
		if(OldTotal + DblProductPrc == DblModifiedTotal) {
			System.out.println("Success! the calculation is correct");
		}else{
			System.out.println("Failure, the calculation is wrong");
		}
	}
	

}

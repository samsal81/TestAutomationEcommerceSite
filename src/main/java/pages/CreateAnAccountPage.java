package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAnAccountPage extends BasePage {

	WebDriver driver;
	
	public CreateAnAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='id_gender1']") WebElement Mr_RadioButton;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']") WebElement FirstName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']") WebElement LastName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']") WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='days']") WebElement Day_Selection;
	@FindBy(how = How.XPATH, using = "//select[@id='months']") WebElement Month_Selection;
	@FindBy(how = How.XPATH, using = "//select[@id='years']") WebElement Year_Selection;
	@FindBy(how = How.XPATH, using = "//input[@id='newsletter']") WebElement Newsletter_CheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='optin']") WebElement SpecialOffer_CheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='firstname']") WebElement Address_FirstName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='lastname']") WebElement Address_LastName_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='company']") WebElement Address_Company_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='address1']") WebElement Address1_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='address2']") WebElement Address2_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement City_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='id_state']") WebElement State_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='postcode']") WebElement ZipCode_Field;
	@FindBy(how = How.XPATH, using = "//select[@id='id_country']") WebElement Country_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']") WebElement CellPhone_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='alias']") WebElement AliasAddress_Field;
	@FindBy(how = How.XPATH, using = "//button[@id='submitAccount']") WebElement Register_Button;
	@FindBy(how = How.XPATH, using = "//div[@id=\"center_column\"]/div/p") WebElement ErrorAlertForMandatoryFields;
	
	public void Click_Mr_RadioButton() {
		Mr_RadioButton.click();
	}
	
	public void Fill_FirstName_Field(String FirstName) {
		FirstName_Field.sendKeys(FirstName);
	}
	
	public void Fill_LastName_Field(String LastName) {
		LastName_Field.sendKeys(LastName);
	}
	
	public void Fill_Password_Field(String Password) {
		Password_Field.sendKeys(Password);
	}
	
	public void SelectDay_Selection(String day) {
		
		SelectFromDropdownByValue(Day_Selection, RemoveDecimalPoint(day));
	}
	
	public void SelectMonth_Selection(String month) {
		SelectFromDropdownByValue(Month_Selection, month);
	}
	
	public void SelectYear_Selection(String year) {
		SelectFromDropdownByValue(Year_Selection, RemoveDecimalPoint(year));
	}
	
	public void Click_Newsletter_CheckBox() {
		Newsletter_CheckBox.click();
	}
	
	public void Click_SpecialOffer_CheckBox() {
		SpecialOffer_CheckBox.click();
	}
	
	public void Fill_Address_FirstName_Field(String aFirstName) {
		Address_FirstName_Field.sendKeys(aFirstName);
	}
	
	public void Fill_Address_LastName_Field(String aLastName) {
		Address_LastName_Field.sendKeys(aLastName);
	}
	
	public void Fill_Address_Company_Field(String Company) {
		Address_Company_Field.sendKeys(Company);
	}

	public void Fill_Address1_Field(String Address) {
		Address1_Field.sendKeys(Address);
	}

	public void Fill_City_Field(String City) {
		City_Field.sendKeys(City);
	}

	public void Select_State_Field(String State) {
		SelectFromDropdownByVisibleText(State_Field, State);
	}

	public void Fill_ZipCode_Field(String ZipCode) {
		ZipCode_Field.sendKeys(RemoveDecimalPoint(ZipCode));
	}

	public void Select_Country_Field(String Country) {
		SelectFromDropdownByVisibleText(Country_Field, Country);
	}

	public void Fill_CellPhone_Field() {
		CellPhone_Field.sendKeys(Phone_Number_Generator());
	}
	
	public void Fill_AliasAddress_Field(String alias) {
		AliasAddress_Field.clear();
		AliasAddress_Field.sendKeys(alias);
	}

	public void Click_Register_Button() {
		Register_Button.click();
	}

	public void VerifyErrorAlertForMandatoryFields() {
		
		if(ErrorAlertForMandatoryFields.isDisplayed() == true) {
			System.out.println("Success! Error Alert For Mandatory Fields is displayed");
		}else {
			System.out.println("Failure, Error Alert For Mandatory Fields is not displayed");
		}
	}
}

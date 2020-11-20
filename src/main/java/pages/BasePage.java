package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int Random_Number_Generator() {
		int RandNum = (int) (Math.random() * 999 + 100);
		return RandNum;
	}

	public int Date_Number_Generator() {
		int RandNum = (int) (Math.random() * 31 + 1);
		return RandNum;
	}

	public String Phone_Number_Generator() {
		int areaCode = (int) (Math.random() * 999 + 100);
		int firstThree = (int) (Math.random() * 999 + 100);
		int lastfour = (int) (Math.random() * 9999 + 1000);
		String PhoneNum = areaCode + " " + firstThree + " " + lastfour;
		return PhoneNum;
	}

	public void SelectFromDropdownByVisibleText(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(input);
	}

	public void SelectFromDropdownByValue(WebElement element, String input) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(input);
	}

	public String RemoveDecimalPoint(String str) {
		return str.substring(0, str.length() - 2);
	}

	public double ConvertStringToDouble(WebElement element) {
		String StringElement = element.getText().substring(1);
		double DoubleElement = Double.parseDouble(StringElement);
		return DoubleElement;
	}

	public void WaitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}

package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	//Open Browser
	public static WebDriver LaunchBrowser() {
		
		ExcelReader reader = new ExcelReader("./data/testdata.xlsx");
		String url = reader.getCellData("Sheet2", "url", 2);
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	//Close Browser
	public static void CloseBrowser() {
		
		driver.close();
		driver.quit();
		
	}
	
	

}

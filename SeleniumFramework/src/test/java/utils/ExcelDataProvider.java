package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest () {
		String projectPath = System.getProperty("user.dir");				
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
		driver =  new ChromeDriver();	
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username + " | " + password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Wait for the username field
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		usernameField.sendKeys(username);

		// Wait for the password field
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		passwordField.sendKeys(password);

		Thread.sleep(2000);		
		
	}
	
	@DataProvider(name = "test1data")
	public static Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/excel/data.xlsx";		
		Object data[][] = testData(excelPath, "Sheet1");	
		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount]; 
		
		for (int i = 1; i < rowCount; i++) {
			
			for (int j = 0; j < colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData + " | ");
				data[i-1][j] = cellData;				
				
			}
			System.out.println();
		}
		
		return data;
		
		
		
	}
	

}

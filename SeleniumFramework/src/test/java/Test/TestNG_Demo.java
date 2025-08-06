package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo {
	
	WebDriver driver = null;
	public static String browserName = null;
	
	@BeforeTest
	public void setUpTest () {
		String projectPath = System.getProperty("user.dir");	
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
			driver =  new ChromeDriver();	
			driver.manage().window().maximize();
			
		} else if(browserName.equalsIgnoreCase("firefox")) {			
			System.setProperty("webdriver.geckodriver.driver",projectPath + "/drivers/geckodriver/geckodriver.exe");		
			driver =  new FirefoxDriver();
			driver.manage().window().maximize();
		} 
		
		
	}
	
	@Test
	public void googleSearch() {		
		
		//goto google 
		driver.get("https://www.google.com/");
		
		//enter text in textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		//click on search
		//driver.findElement(By.name("iblpc")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		//delay by 3 sec
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		//close browser
		driver.close();
		driver.quit();		
		System.out.println("Test Completed Successfully!");		
		PropertiesFile.setProperties();
	}

}

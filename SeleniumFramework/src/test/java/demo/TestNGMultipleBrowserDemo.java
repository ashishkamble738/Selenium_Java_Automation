package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultipleBrowserDemo {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest	
	public void setup(String browserName) {
		
		System.out.println("Browser Name is: " +browserName);
		System.out.println("Thread id is: " +Thread.currentThread().getId());
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
			driver =  new ChromeDriver();
			driver.manage().window().maximize();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.geckodriver.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");		
			driver =  new FirefoxDriver();
			driver.manage().window().maximize();
			
		} else if (browserName.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", projectPath+ "/drivers/iedriver/IEDriverServer.exe");		
			driver =  new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		}		
		
	}
	
	@Test
	public void test1() throws Exception {
		
		driver.get("https://google.com/");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		System.out.println("Test completed successfully!");
	}

}

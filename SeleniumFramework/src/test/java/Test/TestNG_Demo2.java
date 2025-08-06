package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

	WebDriver driver = null;

	@BeforeTest
	public void setUpTest () {
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
		driver =  new ChromeDriver();	
		driver.manage().window().maximize();
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

	public void googleSearch3() {		

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
	}

}

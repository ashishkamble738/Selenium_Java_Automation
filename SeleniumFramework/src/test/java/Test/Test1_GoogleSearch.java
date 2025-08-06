package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {
	
	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
		
		WebDriver driver =  new ChromeDriver();		
		driver.manage().window().maximize();
		
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
		
		//close browser
		driver.close();
		
		System.out.println("Test Completed Successfully!");
		
	}

}

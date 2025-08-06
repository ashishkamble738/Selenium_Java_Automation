package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) {
		seleniumWaits();
	}
	
	public static void seleniumWaits() {
		
		String projectPath = System.getProperty("user.dir");	  
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");	
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //default frequecy polling time 250 ms 
	    
	    driver.get("https://www.google.com/");
	    driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
	    driver.findElement(By.name("q")).sendKeys(Keys.RETURN);    
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
	    
	    driver.findElement(By.name("abcd")).click();
	    
	    driver.close();
	    driver.quit();
	}

}

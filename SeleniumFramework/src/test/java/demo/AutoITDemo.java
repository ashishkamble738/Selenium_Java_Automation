package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		
		driver.get("https://filebin.net/");
//		driver.findElement(By.id("fileField")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("fileField")));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
//		element.click();
		
		Thread.sleep(1000);
		
		Runtime.getRuntime().exec("D:\\AutoIT\\FileUploadScript.exe");
		
		Thread.sleep(3000);
		driver.close();
		
	}

}

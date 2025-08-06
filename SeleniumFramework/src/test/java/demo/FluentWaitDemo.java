package demo;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		fluentWait();
	}
	
	public static void fluentWait() throws Exception {
		
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
		driver =  new ChromeDriver();		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN); 
		
//		driver.findElement(By.linkText("Automation Testing Tutorial: Ultimate Guide")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(2L))
			       .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			   public WebElement apply(WebDriver driver) {
			       WebElement linkElement = driver.findElement(By.linkText("Learn Automation Testing Step By Step"));
			       
			       if(linkElement.isEnabled()) {
			    	   System.out.println("Element is found");			    	   
			       }
			       
			       return linkElement;
			   }
		});
		
		element.click();		
		
		driver.close();
		driver.quit();
		
		Thread.sleep(3000);
		
	}

}

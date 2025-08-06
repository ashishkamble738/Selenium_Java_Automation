package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside test1");
	}
	@Test
	public void test2() {
		System.out.println("I am inside test2");
		
		String projectPath = System.getProperty("user.dir");		
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
		ChromeDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium Automation");
		driver.findElement(By.xpath("//textarea[@name='abc']")).sendKeys("Selenium Automation");
		
		driver.close();
		
	}
	@Test
	public void test3() {
		System.out.println("I am inside test3");
		throw new SkipException("This test is skipped");
	}	
	

}

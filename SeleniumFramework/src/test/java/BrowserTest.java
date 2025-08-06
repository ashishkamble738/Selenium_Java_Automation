import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
//		System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\ASUS\\eclipse-workspace\\SeleniumFramework\\drivers\\geckodriver\\geckodriver.exe");		
//		FirefoxDriver driver =  new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.selenium.dev/");
//		Thread.sleep(3000);
//		driver.close();
//		driver.quit();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
		ChromeDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
//		WebElement textBox = driver.findElement(By.id("APjFqb"));
//		textBox.sendKeys("Automation Selenium");
		
//		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium Automation");
		
		List<WebElement> listofInputElements = driver.findElements(By.xpath("//input"));
		
		int count = listofInputElements.size();
		
		System.out.println("Count of Input Elements: "+count);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
//		System.setProperty("webdriver.ie.driver", "C:\\Users\\ASUS\\eclipse-workspace\\SeleniumFramework\\drivers\\iedriver\\IEDriverServer.exe");		
//		InternetExplorerDriver iedriver =  new InternetExplorerDriver();
//		iedriver.manage().window().maximize();
//		iedriver.get("https://www.selenium.dev/");
//		Thread.sleep(3000);
//		iedriver.close();
		
	}

}
package demo;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SauceLabsDemo {

    public static void main(String[] args) throws Exception {
        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Linux");
        options.setBrowserVersion("latest");
        
        System.out.println("Username: " + System.getenv("SAUCE_USERNAME"));
        System.out.println("Access Key: " + System.getenv("SAUCE_ACCESS_KEY"));

        // Sauce Labs options
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.put("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.put("build", "selenium-build-MZN1N");        
        sauceOptions.put("name", "MySauceLabsTest"); // Or any test name       

        options.setCapability("sauce:options", sauceOptions);

        // Sauce Labs Remote URL
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        // Start the remote driver
        WebDriver driver = new RemoteWebDriver(url, options);
        
//        String projectPath = System.getProperty("user.dir");	  
//		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();

        // Run your test
        driver.get("https://www.google.com/");
        
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
	    driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	    System.out.println(driver.getTitle());

        // Add your test steps here

        // Quit after your test
        driver.quit();
        System.out.println("Test Completed!");
    }
}
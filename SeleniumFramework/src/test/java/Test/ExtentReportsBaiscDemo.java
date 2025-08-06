package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBaiscDemo {
	
	private static WebDriver driver =  null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter ("extendReports.html");
		
		//create ExtendReports and attach reporters
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
		
		ExtentReports extent = new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		
		extent.attachReporter(spark);
		
		//create a toggle for the given test , adds all log events under all log events under it
		ExtentTest test1 = extent.createTest("Google search test one","this is the test to validate google search functionality");
		
		String projectPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
		driver =  new ChromeDriver();	 
		driver.manage().window().maximize();
		
		test1.log(Status.INFO,"Starting test Case");
			
		driver.get("https://google.com/");
		test1.pass("Navigated to Google.com");
	
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Enter test in Searchbox");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		
		driver.close();		
		driver.quit();	
		test1.pass("Closed the browser");
		
		test1.pass("Test Completed");
		
		extent.flush();

	}

}

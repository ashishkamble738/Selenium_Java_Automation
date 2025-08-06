package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {	

		ExtentSparkReporter spark;
		ExtentReports extent;
		
		WebDriver driver;

		// TODO Auto-generated method stub
		@BeforeSuite
		public void setUp() {
			// initialize the HtmlReporter
			spark = new ExtentSparkReporter("target/Spark.html");

			// initialize ExtentReports and attach the HtmlReporter
			extent = new ExtentReports();

			// attach only HtmlReporter
			extent.attachReporter(spark);
			
		}
		
		@BeforeTest
		public void setUpTest () {
			String projectPath = System.getProperty("user.dir");		
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chormedriver/chromedriver.exe");		
			driver =  new ChromeDriver();	
			driver.manage().window().maximize();
		}

		@Test
		public void test1() {			

			ExtentTest test = extent.createTest("Google search test one","this is the test to validate google search functionality");
			
			driver.get("https://google.com/");
			test.pass("Navigated to Google.com");
		
			
			driver.findElement(By.name("q")).sendKeys("Automation");
			test.pass("Enter test in Searchbox");
			
			driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
			test.pass("Pressed keyboard enter key");

			//log(Status, details)
			test.log(Status.INFO, "This step shows usage of log(status, details )");

			//info(details)
			test.info("This step shows usage of info(details)");

			//log with snapshot
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			//test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

		}
		
		@Test
		public void test2() {

			ExtentTest test = extent.createTest("Google search test one","this is the test to validate google search functionality");
			
			driver.get("https://google.com/");
			test.pass("Navigated to Google.com");		
			
			driver.findElement(By.name("q")).sendKeys("Automation By Java Selenium");
			test.pass("Enter test in Searchbox");
			
			driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
			test.pass("Pressed keyboard enter key");

			//log(Status, details)
			test.log(Status.INFO, "This step shows usage of log(status, details )");

			//info(details)
			test.info("This step shows usage of info(details)");

			//log with snapshot
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			//test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

		}
		
		@AfterTest
		public void tearDownTest() {
			
			//close browser
			driver.close();
			driver.quit();		
			System.out.println("Test Completed Successfully!");		
		}


		@AfterSuite
		public void tearDown() {
			
			extent.flush();
			
		}

}

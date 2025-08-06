package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener, ISuiteListener {	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("******* Test is successfull : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("******* Test is failed : "+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("******* Test is skipped : "+result.getName());
	}
	
	public void onTestStart(ITestResult context) {
		
	}
	
	public void onTestFinish(ITestResult context) {
		System.out.println("******* Tests Completed  : "+context.getName());
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onStart(ISuite suite) {
		
	}
	
	public void onFinish(ISuite suite) {
		
	}	

}

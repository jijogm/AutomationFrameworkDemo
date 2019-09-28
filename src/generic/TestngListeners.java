package generic;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngListeners implements ISuiteListener, ITestListener{
    // At a suite level
	
	@Override
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName() +"--> is started..", true);
		
	}
	@Override
	public void onFinish(ISuite suite) {

		Reporter.log(suite.getName() +"--> is finished...", true);
		
	}
	
	// At a test block level
	
	@Override
	public void onStart(ITestContext testblock) {
		Reporter.log(testblock.getName() +"-->  block is started.....", true);
		
	}
	@Override
	public void onFinish(ITestContext testblock) {
		Reporter.log(testblock.getName() +"-->  block is finished.....", true);
		
	}
	//At a test method level
	@Override
	public void onTestStart(ITestResult testMethod) {
		Reporter.log(testMethod.getName() +"-->  test method is started.....", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	@Override
	public void onTestFailure(ITestResult testMethod) {
		Reporter.log(testMethod.getName() +"-->  test method is FAILED.....", true);
	}
	@Override
	public void onTestSkipped(ITestResult testMethod) {
		Reporter.log(testMethod.getName() +"-->  test method is SKIPPED.....", true);
		
	}

	@Override
	public void onTestSuccess(ITestResult testMethod) {
		Reporter.log(testMethod.getName() +"-->  test method is PASS.....", true);
		
	}
	
	

}

package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
	@BeforeMethod
	public void launchApplication() {
		//launch the browser
		driver = new ChromeDriver();
		//enter the url
		driver.get(Lib.getPropertyValue("URL"));
		//Set the implicit time wait to be 10 seconds
		String timeout = Lib.getPropertyValue("IMPLICIT_WAIT");
		//long implicitwait = Long.parseLong(timeout);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res) {
		/*
		 ITestResult is an interface from Testng, using which we
		can fetch all the possible execution status of a particular
		test using getName() method..
		*/
		//call screenshot method only and only if the test case fails
		if (ITestResult.FAILURE==res.getStatus()) {
			Lib.captureScreenshot(driver, res.getName());
		}
		
		//close the browser
		driver.close();
		
	}

}

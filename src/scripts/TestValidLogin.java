package scripts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin() {
		//enter username
		LoginPage login = new LoginPage(driver);
		String username = Lib.getCellValue("logindata", "ValidLogin", 1, 0);
		String password = Lib.getCellValue("logindata", "ValidLogin", 1, 1);
		login.setUsername(username);
		//enter password
		login.setPassword(password);
		//click on login button
		login.clickLogin();
		
		//Expected Condition : wait till the title of the homepage is displayed..
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		//Assert.fail();
		//Verify that the home page is displayed 
		String aHPTitle = driver.getTitle();
		/*if (aHPTitle.equals("I dont know..")) {
			System.out.println("Login success");
		} else {
			System.out.println("Login failed");
		}*/
		
		Assert.assertEquals(aHPTitle, "actiTIME - Enter Time-Track");
	}
}

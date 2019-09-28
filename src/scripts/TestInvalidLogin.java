package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	@Test()
	public void testInvalidLogin() {
		LoginPage login = new LoginPage(driver);
		
		for (int i = 1; i < Lib.getRowCount("logindata", "InvalidLogin"); i++) {
			//enter username
			String username = Lib.getCellValue("logindata", "InvalidLogin", i, 0);
			String password = Lib.getCellValue("logindata", "InvalidLogin", i, 1);
			login.setUsername(username);
			//enter password
			login.setPassword(password);
			//click on login
			login.clickLogin();
		}
		
	}

}

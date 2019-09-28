package scripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;

public class Demo extends BaseTest{
	@Test()
	public void createUser() {
		System.out.println("createUser");
		Assert.fail();
		}
		
	@Test(dependsOnMethods="createUser")
	public void deleteUser() {
		System.out.println("createUser");
		}

}

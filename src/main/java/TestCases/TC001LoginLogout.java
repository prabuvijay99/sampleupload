package TestCases;

import org.testng.annotations.Test;

import FrameWork.design.Selenium.commonMethods;
import Pages.LoginPage;

public class TC001LoginLogout extends commonMethods{

	@Test	
	public void VerifyLoginLogoutStatus() {
		try {
		new LoginPage()
		.typeUsername(prop.getProperty("username"))
		.typeUserpassword(prop.getProperty("password"))
		.clickLoginBtn()
		.verifyLogin("Leaftaps - TestLeaf Automation Platform");
		
//		.clickLogOut()
//		.verifyLogOut();
//		Assert.fail();
		
		}
		catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		}
	}
	
	
}

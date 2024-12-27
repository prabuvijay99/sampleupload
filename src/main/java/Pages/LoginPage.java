package Pages;

import org.testng.Assert;

import FrameWork.design.Inerface.Locators;
import FrameWork.design.Selenium.commonMethods;

public class LoginPage extends commonMethods{
	
	public LoginPage typeUsername(String user) {
		clearandType(locateElements(Locators.ID, "username"), user);
		return this;
	}

	public LoginPage typeUserpassword(String pass) {
		clearandType(locateElements(Locators.ID, "password"), pass);
		return this;
	}
	
	public WelcomePage clickLoginBtn() {
		click(locateElements(Locators.CLASS, "decorativeSubmit"));
		return new WelcomePage();

	}	
	
	public LoginPage verifyLogOut(String title) {
		String verfiyTitle = verfiyTitle();
		Assert.assertEquals(verfiyTitle, title,"Page title is not matching");
		return this;
	}
	
	//"Leaftaps - TestLeaf Automation Platform"
}

package Pages;

import org.testng.Assert;

import FrameWork.design.Inerface.Locators;
import FrameWork.design.Selenium.commonMethods;

public class WelcomePage extends commonMethods {
	
	
	public WelcomePage verifyLogin(String title) {
		String PageTitle = verfiyTitle();
		Assert.assertEquals(PageTitle, title,"Welcome Page title is not matching");		
		return this;
	}
	
	public MyHomePage clickCrmSfa() {
		click(locateElements(Locators.LINKTEXT, "CRM/SFA"));
		return new MyHomePage();

	}
	
	public LoginPage clickLogOut() {
		click(locateElements(Locators.ID,"logout"));
		return new LoginPage();

	}
	
	
	
	

}

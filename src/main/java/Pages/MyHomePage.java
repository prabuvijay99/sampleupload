package Pages;

import org.testng.Assert;

import FrameWork.design.Inerface.Locators;
import FrameWork.design.Selenium.commonMethods;

public class MyHomePage extends commonMethods{

	
	public MyHomePage verifyHomePage(String Title) {
		String myHomePageTitle = verfiyTitle();
		Assert.assertEquals(myHomePageTitle, Title,"My home page title is not matching");
		return this;
	}
	
	
	public MyLeadsPage clickLeads() {
		click(locateElements(Locators.LINKTEXT, "Leads"));
		return new MyLeadsPage();

	}
	
}

package Pages;

import org.testng.Assert;

import FrameWork.design.Inerface.Locators;
import FrameWork.design.Selenium.commonMethods;

public class MyLeadsPage extends commonMethods {

	
	public MyLeadsPage verifyMyLeadPage(String title) {
		String myLeadPageTitle = verfiyTitle();
		Assert.assertEquals(myLeadPageTitle, title);
		return this;
	}
	
	public CreateLeadPage clickCreateLead() {
		click(locateElements(Locators.LINKTEXT, "Create Lead"));
		return new CreateLeadPage();
	}
	
	
	public  MergeLeadPage clickMergeLead() {
		click(locateElements(Locators.LINKTEXT, "Merge Leads"));
		return new MergeLeadPage();
	}
	
	
	public  FindLeadsPage clickFindLead() {
		click(locateElements(Locators.LINKTEXT, "Find Leads"));
		return new FindLeadsPage();
	}
	
	
}

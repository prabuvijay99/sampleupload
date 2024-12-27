package Pages;

import org.testng.Assert;

import FrameWork.design.Inerface.Locators;
import FrameWork.design.Selenium.commonMethods;

public class ViewLeadPage extends commonMethods {

	public ViewLeadPage verifyPage(String title) {
		String pageTitle = verfiyTitle();
		Assert.assertTrue(pageTitle.equals(title),"Page title is not matching");
		return this;
	}
	
	public ViewLeadPage verifyCreatedLead(String fname) {
		String actualFirstName = verifyGetText(locateElements(Locators.ID, "viewLead_firstName_sp")); 
		Assert.assertEquals(actualFirstName, fname, "Lead First name is not matching");
		return this;

	}
	
	public ViewLeadPage verifyFindLeadName() {
		String text = getText(locateElements(Locators.ID, "viewLead_firstName_sp"));
		System.out.println("The lead Name :"+text);
		Assert.assertFalse(text.isEmpty());
		return this;
		

	}
	
	public ViewLeadPage verifyMergeLeadID() {
		String mergedToLead = FindLeadsPage.LeadID;
		String text = getText(locateElements(Locators.ID, "viewLead_companyName_sp"));
		String leadId = text.substring(text.indexOf('(')+1,text.indexOf(')'));
		Assert.assertEquals(leadId, mergedToLead,"Merge id is not matching");
		return this;	
		

	}
	
	public WelcomePage clickOpenTaps() {
		click(locateElements(Locators.XPATH, "//a[normalize-space()='opentaps']"));
		return new WelcomePage();

	}
	
}

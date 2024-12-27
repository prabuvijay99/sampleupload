package TestCases;

import org.testng.annotations.Test;

import FrameWork.design.Selenium.commonMethods;
import Pages.LoginPage;

public class TC003MergeLead extends commonMethods {
	@Test(invocationCount = 3)
	public void verifyMergeLeads() throws InterruptedException {
		// TODO Auto-generated method stub
		new LoginPage()
		.typeUsername(prop.getProperty("username"))
		.typeUserpassword(prop.getProperty("password"))
		.clickLoginBtn()
		.clickCrmSfa()
		.clickLeads()
		.clickMergeLead()
		.clickFromLead()
		.switchToFindLeads("Find Leads")
//		.sendLeadid("10284")//
		.takeForFromLead_FirstLeadId()
//		.selectSearchedLeadID()
		.switchToMergeLeads("Merge Leads | opentaps CRM")
		.clickToLead()
		.switchToFindLeads("Find Leads")
//		.sendLeadid("10285")
		.takeFortoLead_SecondLeadId()
//		.selectSearchedLeadID()
		.switchToMergeLeads("Merge Leads | opentaps CRM")
		.clickMergeBtn()
		.verifyMergeLeadID();
		
		
		
	}

}

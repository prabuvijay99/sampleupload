package TestCases;

import org.testng.annotations.Test;

import FrameWork.design.Selenium.commonMethods;
import Pages.LoginPage;
import Utils.DataProviders;

public class TC005CreateLead_TDD extends commonMethods{
	
	@Test(dataProvider="leadData",dataProviderClass=DataProviders.class)
	public void verifyCreateLead(String cmp,String fname,String lname,String src) {
	// TODO Auto-generated method stub
		
		new LoginPage()
		.typeUsername(prop.getProperty("username"))
		.typeUserpassword(prop.getProperty("password"))
		.clickLoginBtn()
		.clickCrmSfa()
		.verifyHomePage("My Home | opentaps CRM")
		.clickLeads()
		.verifyMyLeadPage("My Leads | opentaps CRM")
		.clickCreateLead()
		.typeCompanyName(cmp)
		.typeFirstName(fname)
		.typeLastName(lname)
		.selectSource(src)
		.clickCreateLeadBtn()
		.verifyPage("View Lead | opentaps CRM")
		.verifyCreatedLead(fname);
		

}

}
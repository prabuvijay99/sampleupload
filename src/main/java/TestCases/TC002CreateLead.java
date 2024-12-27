package TestCases;

import org.testng.annotations.Test;

import FrameWork.design.Selenium.commonMethods;
import Pages.LoginPage;

public class TC002CreateLead extends commonMethods{
	
	@Test
	public void verifyCreateLead() {
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
		.typeCompanyName("Infosys")
		.typeFirstName("Dhana")
		.typeLastName("Prabha")
		.selectSource("Employee")
		.clickCreateLeadBtn()
		.verifyPage("View Lead | opentaps CRM")
		.verifyCreatedLead("Dhana");
		

}
}
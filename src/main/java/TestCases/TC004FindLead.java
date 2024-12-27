package TestCases;

import org.testng.annotations.Test;

import FrameWork.design.Selenium.commonMethods;
import Pages.LoginPage;

public class TC004FindLead extends commonMethods {
	@Test
	public void verifyFindLeads() throws InterruptedException {
		new LoginPage()
		.typeUsername(prop.getProperty("username"))
		.typeUserpassword(prop.getProperty("password"))
		.clickLoginBtn()
		.clickCrmSfa()
		.clickLeads()
		.clickFindLead()
		.sendLeadid("10283")
		.selectFindLeadID()
		.verifyFindLeadName();		

	}

}

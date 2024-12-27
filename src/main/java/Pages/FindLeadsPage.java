package Pages;

import FrameWork.design.Inerface.Locators;
import FrameWork.design.Selenium.commonMethods;

public class FindLeadsPage extends commonMethods{
	public static  String LeadID ;
	
	public FindLeadsPage switchToFindLeads(String title) {
		switchToWindowUsingName(title);
		return this;
	}
	
	public FindLeadsPage sendLeadid(String Leadid) {
		clearandType(locateElements(Locators.XPATH, "//input[@name='id']"), Leadid);
		click(locateElements(Locators.XPATH, "//button[@class='x-btn-text']"));
		return new FindLeadsPage();	

	}
	
	public MergeLeadPage selectSearchedLeadID() throws InterruptedException {
		Thread.sleep(1500);
		click(locateElements(Locators.XPATH, "//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
		return new MergeLeadPage();

	}
	
	public ViewLeadPage selectFindLeadID() throws InterruptedException {
		Thread.sleep(1500);
		click(locateElements(Locators.XPATH, "//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
		return new ViewLeadPage();

	}
	
	public MergeLeadPage takeForFromLead_FirstLeadId() {
		click(locateElements(Locators.XPATH, "//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a"));
		return new MergeLeadPage();

	}
	
	public String getMergedToLead() {
		LeadID = getText(locateElements(Locators.XPATH, "(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[2]"));
		return LeadID;
		

	}
	
	public MergeLeadPage takeFortoLead_SecondLeadId() throws InterruptedException {
		getMergedToLead();
		click(locateElements(Locators.XPATH, "(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[2]"));
		return new MergeLeadPage();

	}

}

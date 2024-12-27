package Pages;

import FrameWork.design.Inerface.Locators;

public class MergeLeadPage extends CreateLeadPage {
	
	
	

	public MergeLeadPage switchToMergeLeads(String title) {
		switchToWindowUsingName(title);
		return this;
		

	}
	
	public FindLeadsPage clickFromLead() throws InterruptedException {
		click(locateElements(Locators.XPATH, "//img[@alt='Lookup']"));
		return new FindLeadsPage();

	}
	
	
	
	public FindLeadsPage clickToLead() throws InterruptedException {
		click(locateElements(Locators.XPATH, "(//img[@alt='Lookup'])[2]"));
		return new FindLeadsPage();

	}
	
	public ViewLeadPage clickMergeBtn() {
		
		click(locateElements(Locators.XPATH, "//a[@class='buttonDangerous']"));
		acceptAlert();
		return new ViewLeadPage();

	}
	


}

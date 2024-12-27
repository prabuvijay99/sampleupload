package Pages;

import FrameWork.design.Inerface.Locators;
import FrameWork.design.Selenium.commonMethods;

public class CreateLeadPage extends commonMethods {
	
		
	
	public CreateLeadPage typeCompanyName(String cmpName) {
		clearandType(locateElements(Locators.ID, "createLeadForm_companyName"), cmpName);
		return this;
	}
	
	public CreateLeadPage typeFirstName(String fname) {
		clearandType(locateElements(Locators.ID, "createLeadForm_firstName"), fname);
		return this;
	}
	
	public CreateLeadPage typeLastName(String lname) {
		clearandType(locateElements(Locators.ID, "createLeadForm_lastName"), lname);
		return this;
	}
	
	
	public CreateLeadPage selectSource(String type) {		
		selectDropDownUsingText(locateElements(Locators.ID, "createLeadForm_dataSourceId"), type);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadBtn() {
		click(locateElements(Locators.NAME, "submitButton"));
		return new ViewLeadPage();

	}

}

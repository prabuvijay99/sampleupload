package FrameWork.design.Inerface;

import org.openqa.selenium.WebElement;

public interface BrowserElements {
		
	
	public void onStartApp(String url);
	
	public void onStartApp(String browser, String url);
	
	public void onTearDown();
	
	public WebElement locateElements(Locators locatorType,String value);
	
	public void clearandType(WebElement ele,String value);
	
	public void click(WebElement ele);
	
	public String verfiyTitle();
	
	public String verifyGetText(WebElement ele);
	
	public String getText(WebElement ele);	
	
	public void selectDropDownUsingText(WebElement ele,String value);
	
	public void selectDropDownUsingValue(WebElement ele, String value);
	
	public void selectDropDownUsingIndex(WebElement ele, int index);
	
	public void switchToAlert();
	
	
	public void acceptAlert();
	
	public void dismissAlert();
	
	public void switchToWindowUsingIndex(int index);
	
	public void switchToWindowUsingName(String name);

	public String captureSnap(String testName, Object instance);
	
}

package FrameWork.design.Selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class commonMethods extends SeleniumBase {
	
	protected Properties prop=new Properties();	
	
	@BeforeMethod	
	@Parameters({"browser"})
	public void preCondition(String browser) {				
		try {
			FileInputStream fis=new FileInputStream("./src/main/resources/config.properties");
			prop.load(fis);
			onStartApp(browser,prop.getProperty("url"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@AfterMethod
	public void postCondition() {
		onTearDown();

	}

}

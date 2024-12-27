package Utils;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import FrameWork.design.Selenium.SeleniumBase;



public class ExtentReportManager extends SeleniumBase implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String reportName;
	
	
	
	@Override
	public void onStart(ITestContext testcontext) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmm");
		Date dt=new Date();
		String timeStamp = sdf.format(dt);
		
		reportName="Test-Report"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter("./reports/"+reportName);
		
		sparkReporter.config().setDocumentTitle("Automation Testing");
		sparkReporter.config().setReportName("Automation Excercise Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Qualtiy Analyst", "Prabhakaran c");
		extent.setSystemInfo("Testing", "Functional Testing");
					
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" Test Case is Passes");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		Object instance = result.getInstance();
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" Test Case is Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		

		SeleniumBase sb=new SeleniumBase();
		
		try {
			String takeScreenShot = sb.captureSnap(result.getName(),instance);					
			test.addScreenCaptureFromPath(takeScreenShot);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" Test Case is Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		String Path = System.getProperty("user.dir")+"//reports//"+reportName;
		File finalPath=new File(Path);
		try {
		Desktop.getDesktop().browse(finalPath.toURI());
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}

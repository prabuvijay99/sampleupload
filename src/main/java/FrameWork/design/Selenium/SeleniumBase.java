package FrameWork.design.Selenium;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameWork.design.Inerface.BrowserElements;
import FrameWork.design.Inerface.Locators;

public class SeleniumBase implements BrowserElements {
    
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    // Helper method to return WebDriverWait with a default timeout
    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public void setDriver(WebDriver driver) {
        tlDriver.set(driver);
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }    
    
    @Override
    public void onStartApp(String br, String url) {
        // Start the appropriate browser based on the input parameter
       try {
    	switch (br.toLowerCase()) {
            case "chrome": setDriver(new ChromeDriver()); break;
            case "edge": setDriver(new EdgeDriver()); break;
            case "firefox": setDriver(new FirefoxDriver()); break;
            default: 
                System.err.println("Invalid Browser name"); 
                return;
        }

        // Configure WebDriver settings
//        setDriver(new ChromeDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().get(url);
        }
        catch (Exception e) {
			// TODO: handle exception
        	 System.err.println("Browser not initiated"+ e.getMessage());
		}
    }

    @Override
    public void onStartApp(String url) {
    	try {
    		        setDriver(new ChromeDriver());
    		        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    		        getDriver().manage().window().maximize();
    		        getDriver().get(url);
    		        }
    		        catch (Exception e) {
    					// TODO: handle exception
    		        	 System.err.println("Browser not initiated"+ e.getMessage());
    				}
    		    }

    @Override
    public void onTearDown() {
        // Close the browser properly after test execution
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    @Override
    public WebElement locateElements(Locators locatorType, String value) {
        WebDriverWait wait = getWait();
        WebElement element = null;

        try {
            switch (locatorType) {
                case ID:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
                    break;
                case XPATH:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                    break;
                case CLASS:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
                    break;
                case TAGNAME:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
                    break;
                case NAME:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
                    break;
                case CSS:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
                    break;
                case LINKTEXT:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
                    break;
                case PARTIAL_LINKTEXT:
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(value)));
                    break;
                default:
                    System.err.println("Invalid locator");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Error locating element with " + locatorType + ": " + e.getMessage());
        }

        return element;
    }

    @Override
    public void clearandType(WebElement ele, String value) {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.elementToBeClickable(ele));  // Wait for the element to be clickable
            ele.clear();
            ele.sendKeys(value);
        } catch (Exception e) {
            System.err.println("Error interacting with element: " + e.getMessage());
        }
    }

    @Override
    public void click(WebElement ele) {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.elementToBeClickable(ele));  // Wait for the element to be clickable
            ele.click();
        } catch (Exception e) {
            System.err.println("Error clicking element: " + e.getMessage());
        }
    }

    @Override
    public String verfiyTitle() {
    	String title="";
        try {    
        	WebDriverWait wait = getWait();
        	wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
			title = getDriver().getTitle(); 
			            
        } catch (Exception e) {
            System.err.println("Error while getting title: " + e.getMessage());
        }
        return title;
    }
    
    public String getTypedText(WebElement ele) {
		String attributeValue = null;
		try {
			attributeValue = ele.getAttribute("valuenow");
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return attributeValue;
    }	

    @Override
    public String verifyGetText(WebElement ele) {
    	String text =null;
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.visibilityOf(ele));  // Wait for the element to be visible
            text = ele.getText();
        }
        catch (Exception e) {
			// TODO: handle exception
        	System.err.println(e.getMessage());
        }
        return text;
    }

    @Override
    public void selectDropDownUsingText(WebElement ele, String value) {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.elementToBeClickable(ele));  // Wait for the dropdown to be clickable
            Select slt = new Select(ele);
            slt.selectByVisibleText(value);
        } catch (Exception e) {
            System.err.println("Error selecting dropdown by text: " + e.getMessage());
        }
    }

    @Override
    public void selectDropDownUsingValue(WebElement ele, String value) {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.elementToBeClickable(ele));  // Wait for the dropdown to be clickable
            Select slt = new Select(ele);
            slt.selectByValue(value);
        } catch (Exception e) {
            System.err.println("Error selecting dropdown by value: " + e.getMessage());
        }
    }

    @Override
    public void selectDropDownUsingIndex(WebElement ele, int index) {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.elementToBeClickable(ele));  // Wait for the dropdown to be clickable
            Select slt = new Select(ele);
            slt.selectByIndex(index);
        } catch (Exception e) {
            System.err.println("Error selecting dropdown by index: " + e.getMessage());
        }
    }

    @Override
    public void switchToAlert() {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.alertIsPresent());  // Wait for the alert to be present
            getDriver().switchTo().alert();
        } catch (Exception e) {
            System.err.println("Error switching to alert: " + e.getMessage());
        }
    }

    @Override
    public void acceptAlert() {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.alertIsPresent());  // Wait for the alert to be present
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.err.println("Error accepting alert: " + e.getMessage());
        }
    }

    @Override
    public void dismissAlert() {
        try {
            WebDriverWait wait = getWait();
            wait.until(ExpectedConditions.alertIsPresent());  // Wait for the alert to be present
            Alert alert = getDriver().switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            System.err.println("Error dismissing alert: " + e.getMessage());
        }
    }

    @Override
    public void switchToWindowUsingIndex(int index) {
        try {
            WebDriverWait wait = getWait();
            Set<String> windowHandles = getDriver().getWindowHandles();
            List<String> windowHandleList = new ArrayList<>(windowHandles);
            wait.until(ExpectedConditions.numberOfWindowsToBe(windowHandleList.size()));  // Wait for the correct number of windows
            getDriver().switchTo().window(windowHandleList.get(index));
        } catch (Exception e) {
            System.err.println("Error switching to window by index: " + e.getMessage());
        }
    } 

    @Override
    public void switchToWindowUsingName(String name) {
        try {
            Set<String> windowHandles = getDriver().getWindowHandles();
            for (String handle : windowHandles) {
                getDriver().switchTo().window(handle);
                if (getDriver().getTitle().equals(name)) {
                    System.out.println("Switched to window with title: " + name);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error switching to window by name: " + e.getMessage());
}
    }

	@Override
	public String getText(WebElement ele) {
		String text=null;
		try {
		WebDriverWait wait=getWait();		
		wait.until(ExpectedConditions.visibilityOf(ele));
		text = ele.getText();
		
	} catch (Exception e) {
		System.err.println("Error while getting the text: " + e.getMessage());
		
	}
		return text;	
	}
	
	@Override
	public String captureSnap(String testName, Object instance) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddhhmmss");
		Date dt=new Date();
		String TimeStamp = sdf.format(dt);
		String fileName="_scrshot_"+TimeStamp;
		TakesScreenshot ts= (TakesScreenshot) ((SeleniumBase) instance).getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String Filepath =System.getProperty("user.dir")+"//Screenshots//"+testName+fileName+".png";
		File destination=new File(Filepath);
		source.renameTo(destination);
		return Filepath;
				

	}


}



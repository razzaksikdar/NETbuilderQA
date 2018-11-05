package NetB.com.qa.bypassValidation;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestCase {
	 private static final LogStatus LogStatus = null;
		WebDriver driver;
	    private static ExtentReports  reports = new ExtentReports(Constants.report, true);
	    public ExtentTest test;
	
	    @Before
	    public void setup()
	    {
	        System.setProperty("webdriver.chrome.driver", "/Users/ARSIKDAR/Desktop/NETbuilder/BypassValidation/chromedriver");
	        driver = new ChromeDriver();
	     // driver.manage().window().maximize();
	    }
	    
	    @After
	    public void teardown()
	    {
	        driver.quit();
	        reports.endTest(test);
	        reports.flush();
	    }
	
	@Test
	public void browserTest() {
		driver.get(Constants.url);
    	test=reports.startTest("NETbuilder Challenges-2 Test Report");
    	test.log(LogStatus.INFO,"Browser Started");
    	
        if (driver.getCurrentUrl().equals(Constants.url)) {
        	test.log(LogStatus.PASS, "web page accessed correctly");
        }
        else {
        	test.log(LogStatus.FAIL, "Web Page not accessed correctly");
        }
    	
        assertEquals(driver.getCurrentUrl(), Constants.url);
	}


	
	
	
	@Test
	public void firstDateBefore2017() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-2 Test Report");
   
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementsByClassName(\"inputbox\")[0].type = \"\";");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("bYpASS ! BYpass");
		
		   if (TestPage.confirmation("YOU HAVE DONE IT. Please enter your name.")) {
	        	test.log(LogStatus.PASS, "Bypass Validation Successful");
	        	test.log(LogStatus.PASS, "You have just entered Text and Not Text element instead of numbers");
	        	test.log(LogStatus.PASS, "YOU HAVE DONE IT! Please enter your name.");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "Bypass Validation unsuccessful");
	        }

			assertTrue(TestPage.confirmation("YOU HAVE DONE IT. Please enter your name."));	
          }
	
}

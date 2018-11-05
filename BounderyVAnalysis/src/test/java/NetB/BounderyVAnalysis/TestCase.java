package NetB.BounderyVAnalysis;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
	        System.setProperty("webdriver.chrome.driver", "/Users/ARSIKDAR/Desktop/NETbuilder/BounderyVAnalysis/chromedriver");
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
    	test=reports.startTest("NETbuilder Challenges-6 Test Report");
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
		test=reports.startTest("NETbuilder Challenges-6 Test Report");
   

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("31/12/2016 23:59");
		
		   if (TestPage.confirmation("First date before 2017, December 2016 23:59")) {
	        	test.log(LogStatus.PASS, "31/12/2016 23:59 is an invalid boundary");
	        	test.log(LogStatus.PASS, "First date before 2017, December 2016 23:59");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "31/12/2016 23:59 is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("First date before 2017, December 2016 23:59"));
	}
	
	
	@Test
	public void firstDateAfter2017() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("01/01/2018 00:00");
		
		   if (TestPage.confirmation("First date after 2017, January 2018 00:00")) {
	        	test.log(LogStatus.PASS, "01/01/2018 00:00 is an invalid boundary");
	        	test.log(LogStatus.PASS, "First date after 2017, January 2018 00:00");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "01/01/2018 00:00 is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("First date after 2017, January 2018 00:00"));
	}
	
	
	@Test
	public void inexistentDate() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("29/02/2017 00:00");
		
		   if (TestPage.confirmation("Inexistent date 29 for February 2017")) {
	        	test.log(LogStatus.PASS, "29/02/2017 00:00 is an invalid boundary");
	        	test.log(LogStatus.PASS, "Inexistent date 29 for February 2017");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "29/02/2017 00:00 is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Inexistent date 29 for February 2017"));
	}
	
	@Test
	public void dateWithDayZero() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("00/01/2017 00:00");
		
		   if (TestPage.confirmation("Date with day = zero")) {
	        	test.log(LogStatus.PASS, "00/01/2017 00:00 is an invalid boundary");
	        	test.log(LogStatus.PASS, "Date with day = zero");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "00/01/2017 00:00 is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Date with day = zero"));
	}
	
	
	@Test
	public void dateLessThan1Hour() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("31/12/2017 23:00");
		
		   if (TestPage.confirmation("Date less than 1 hour")) {
	        	test.log(LogStatus.PASS, "31/12/2017 23:00 is an invalid boundary");
	        	test.log(LogStatus.PASS, "Date less than 1 hour");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "31/12/2017 23:00 is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Date less than 1 hour"));
	}
	
	@Test
	public void higherLimitForTheMonth() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("04/13/2017 23:00");
		
		   if (TestPage.confirmation("Higher limit for the month 13")) {
	        	test.log(LogStatus.PASS, "04/13/2017 23:00 is an invalid boundary");
	        	test.log(LogStatus.PASS, "Higher limit for the month 13");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "04/13/2017 23:00 is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Higher limit for the month 13"));
	}
	
	@Test
	public void thirty1Daysfor30DaysMonths() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("31/04/2017 23:16");
		
		   if (TestPage.confirmation("31 days for 30 days months")) {
	        	test.log(LogStatus.PASS, "31/04/2017 23:16 is an invalid boundary");
	        	test.log(LogStatus.PASS, "31 days for 30 days months");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "31/04/2017 23:16 is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("31 days for 30 days months"));
	}
	
	
	@Test
	public void LowerLimitForTheMonth() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("01/00/2017 23:15");
		
		   if (TestPage.confirmation("Lower limit for the month 00")) {
	        	test.log(LogStatus.PASS, "\"01/00/2017 23:15\" is an invalid boundary");
	        	test.log(LogStatus.PASS, "Lower limit for the month 00");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "\"01/00/2017 23:15\" is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Lower limit for the month 00"));
	}
	
	@Test
	public void thirty2DaysFor31DaysMonths() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("32/01/2017 23:17");
		
		   if (TestPage.confirmation("32 days for 31 days months")) {
	        	test.log(LogStatus.PASS, "\"32/01/2017 23:17\" is an invalid boundary");
	        	test.log(LogStatus.PASS, "32 days for 31 days months0");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "\"32/01/2017 23:17\" is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("32 days for 31 days months"));
	}
	
	@Test
	public void marchDaylight() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("26/03/2017 02:00");
		
		   if (TestPage.confirmation("March daylight saving time lowest invalid hour 02:00")) {
	        	test.log(LogStatus.PASS, "\"26/03/2017 02:00\" is an invalid boundary");
	        	test.log(LogStatus.PASS, "March daylight saving time lowest invalid hour 02:00");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "\"26/03/2017 02:00\" is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("March daylight saving time lowest invalid hour 02:00"));
	}
	
	@Test
	public void twiceHour() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("29/10/2017 03:00");
		
		   if (TestPage.confirmation("Hour that exists twice during daylight saving time")) {
	        	test.log(LogStatus.PASS, "\"29/10/2017 03:00\" is an invalid boundary");
	        	test.log(LogStatus.PASS, "Hour that exists twice during daylight saving time");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "\"29/10/2017 03:00\" is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Hour that exists twice during daylight saving time"));
	}
	
	@Test
	public void dayLightSaving() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("26/03/2017 02:59");
		
		   if (TestPage.confirmation("March daylight saving time highest invalid hour 02:59")) {
	        	test.log(LogStatus.PASS, "\"26/03/2017 02:59\" is an invalid boundary");
	        	test.log(LogStatus.PASS, "March daylight saving time highest invalid hour 02:59");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "\"26/03/2017 02:59\" is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("March daylight saving time highest invalid hour 02:59"));
	}
	
	@Test
	public void bigHour() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("28/02/2017 24:00");
		
		   if (TestPage.confirmation("Hour bigger then maxim valid 24")) {
	        	test.log(LogStatus.PASS, "\"28/02/2017 24:00\" is an invalid boundary");
	        	test.log(LogStatus.PASS, "Hour bigger then maxim valid 24");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "\"28/02/2017 24:00\" is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Hour bigger then maxim valid 24"));
	}
	
	@Test
	public void maxMin() {
		driver.get(Constants.url);
		test=reports.startTest("NETbuilder Challenges-6 Test Report");

		TestPage tp=PageFactory.initElements(driver, TestPage.class);
		tp.inputField("01/01/2017 00:60");
		
		   if (TestPage.confirmation("Maximum invalid value for minutes 60")) {
	        	test.log(LogStatus.PASS, "\"01/01/2017 00:60\" is an invalid boundary");
	        	test.log(LogStatus.PASS, "Maximum invalid value for minutes 60");
	        }
	        else {
	        	test.log(LogStatus.FAIL, "\"01/01/2017 00:60\" is a valid boundary");
	        }
		
		assertTrue(TestPage.confirmation("Maximum invalid value for minutes 60"));
	}

}

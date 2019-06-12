package MavenDemo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TrainingSelenium {

	ExtentTest logger;
	WebDriver driver;
	ExtentReports report;
	Logger log;
	
	//Report Initialization
		@BeforeTest
		public void reportInitiation() {
			report = new ExtentReports("./Test_Report.html", true);
			report.loadConfig(TrainingSelenium.class, "resources", "extent-config.xml");
			log = Logger.getLogger("devpinoyLogger");
		}
	@Test
	public void facebookPage() {
		// TODO Auto-generated method stub

		logger = report.startTest("login.......", "FacebookPage hitting").assignCategory("Functional.......");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubham.o.gupta\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		logger.log(LogStatus.PASS, "URL Loaded successufully for:" + "www.facebook.com/");
		
		
		Select drpCountry = new Select(driver.findElement(By.id("day")));
		drpCountry.selectByVisibleText("15");

		//Selecting Items in a Multiple SELECT elements
		
		Select fruits = new Select(driver.findElement(By.id("month")));
		//fruits.selectByVisibleText("May");
		fruits.selectByIndex(60);
	}

	//Error handling
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.INFO, "Test Case Completed");
		logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(Utility.captureScreenShot(driver, result.getName())));
			Utility.captureScreenShot(driver, result.getName());
			logger.log(LogStatus.INFO,result.getName()+"_Completed");
		} else {
			
			logger.log(LogStatus.FAIL,result.getName()+"_failed and error is '"+result.getThrowable()+"'");
			logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(Utility.captureScreenShot(driver,result.getName()+"_failed")));
			Utility.captureScreenShot(driver,result.getName()+"_failed");
		}
		report.endTest(logger);
		report.flush();
	}


}

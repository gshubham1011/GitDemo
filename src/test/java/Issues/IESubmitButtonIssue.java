package Issues;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jayway.restassured.internal.assertion.Assertion;

public class IESubmitButtonIssue {
	/*
  @SuppressWarnings("deprecation")
@Test
  public void IESubmitButton() throws InterruptedException {
	  
	  System.out.println("Starting ");

	  
	
	  SoftAssert assertion = new SoftAssert();
	//it is used to define IE capability 
	 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	  
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
	capabilities.setCapability(InternetExplorerDriver.
	  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
	capabilities.setCapability("requireWindowFocus", false);

	System.setProperty("webdriver.ie.driver", "C:\\Users\\shubham.o.gupta\\Downloads\\chromedriver_win32\\IEDriverServer.exe");
	  
	 //it is used to initialize the IE driver
	WebDriver driver = new InternetExplorerDriver(capabilities);
	WebDriverWait wait = new WebDriverWait(driver, 90);
	  
	// driver.manage().window().maximize();

	 driver.get("http://www.isaca.org/certification/pages/default.aspx#Verify");
	  
	 Thread.sleep(3000);
	 WebElement element= driver.findElement(By.xpath("//*[text()='Submit']"));
	 wait.until(ExpectedConditions.visibilityOfAllElements(element));
	 //assertion.assertTrue(driver.findElement(By.xpath("//*[text()='Submit']")).isDisplayed();
	  
  }*/
	
	@SuppressWarnings("deprecation")
	@Test
	public void IESubmitButtonTest() throws InterruptedException {
	
		 System.out.println("Starting ............");
		      System.setProperty("webdriver.ie.driver", "C:\\Users\\shubham.o.gupta\\Downloads\\chromedriver_win32\\IEDriverServer.exe");
		      DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		      ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
		      ieCapabilities.setCapability("requireWindowFocus", true);
		      ieCapabilities.setCapability(CapabilityType.VERSION, "10");
	          //  ieCapabilities.setCapability("browserAttachTimeout",5000);
		      WebDriver  driver = new InternetExplorerDriver(ieCapabilities);
		      WebDriverWait wait = new WebDriverWait(driver, 90);
			  
			  // driver.manage().window().maximize();

			  driver.get("http://www.isaca.org/certification/pages/default.aspx#Verify");			  
			  Thread.sleep(5000);
			  System.out.println("Version "+ieCapabilities.getVersion());				
			  List<WebElement> iframes = driver.findElements(By.tagName("iframe"));			  
			  System.out.println("IFrame Size  ="+iframes.size());
			 
			  WebElement element= driver.findElement(By.xpath("//*[text()='Submit']"));
			  wait.until(ExpectedConditions.visibilityOfAllElements(element));
			  driver.findElement(By.xpath("//div[@class='certName']/input")).sendKeys("shubham");
			
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", element);
			 
			 //element.click();
			
			 //assertion.assertTrue(driver.findElement(By.xpath("//*[text()='Submit']")).isDisplayed();
		  System.out.println("End......");
		   
		  
	}
	
}

package MavenDemo;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Utility.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testfacebook {
	
	
	
	
	@BeforeSuite
	public  static void main() {
		
		System.out.println("Staring Program");
		
	}
	
	
@Test
public void TestFireFox() throws IOException{

	  System.setProperty("webdriver.chrome.driver","C:\\Users\\shubham.o.gupta\\Downloads\\chromedriver_win32\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();

             driver.manage().window().maximize();
             driver.get("http://www.facebook.com");
             
             
    //Create an object of File class to open xlsx file

             File file =    new File("C:\\Users\\shubham.o.gupta\\Desktop\\OPEN DEMAND RHL_Y.xlsx");

             //Create an object of FileInputStream class to read excel file

             FileInputStream inputStream = new FileInputStream(file);

             Workbook guru99Workbook = null;
             String fileName ="OPEN DEMAND RHL_Y";

           
             guru99Workbook = new XSSFWorkbook(inputStream);


             Sheet guru99Sheet = guru99Workbook.getSheet("OPEN DEMAND RHL_Y");

             //Find number of rows in excel file

             int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
             System.out.println("Row count ="+rowCount);
             System.out.println(" Value   ="+guru99Sheet.getRow(5).getCell(5).getStringCellValue());

             //Create a loop over all the rows of excel file to read it
/*
             for (int i = 0; i < rowCount+1; i++) {

                 Row row = guru99Sheet.getRow(i);

                 //Create a loop to print cell values in a row

                 for (int j = 0; j < row.getLastCellNum(); j++) {

                     //Print Excel data in console

                     System.out.print(row.getCell(j).getStringCellValue()+"|| ");

                 }

                 System.out.println();
             } 
*/
             }  

    




//  driver.quit();
 /*           

@AfterSuite
public void DriverKills() throws IOException{
	
	//kill chromedriver
	System.out.println("Killing the driver");
	Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");

}*/
/*
@Test(priority=1, enabled=false)
public void TestingMSTMT() throws Exception {
	  
	  JavascriptExecutor js = ((JavascriptExecutor) driver);
	  wait = new WebDriverWait(driver, 90);	  
	  driver.get(conf.getUrl());
	  login();
	  
	//Hamburger Menu
   Thread.sleep(2000);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='menu']")));
    WebElement btnMenu = driver.findElement(By.xpath("//a[@class='menu']"));
    btnMenu.click();
    WebDriverWait wait = new WebDriverWait(driver, 30); 
    Thread.sleep(4000);
    WebElement menuTimeTracker = driver.findElement(By.xpath("//a[text()='Time Tracker']"));
    Thread.sleep(1000);
    menuTimeTracker.click();
    WebElement menuTimeSheet = driver.findElement(By.xpath("//a[text()='Timesheet']"));
    menuTimeSheet.click();
   Thread.sleep(10000);
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='boxHeading']"))));		 
	 System.out.println(" Title ="+driver.getTitle());
	  System.out.println("Current URL ="+driver.getCurrentUrl());
	 ((JavascriptExecutor) driver).executeScript("scroll(0,500);");
	 WebElement e0= driver.findElement(By.xpath("//div[@class='boxHeading']"));
	 js.executeScript("arguments[0].scrollIntoView(true);",e0);			 
	 WebElement e1= driver.findElement(By.xpath("//td[text()='Assignments']"));
	 js.executeScript("arguments[0].scrollIntoView(true);",e1);
	 Thread.sleep(2000);
	  List<WebElement> valueinput1 = driver.findElements(By.xpath("//td//input[@aria-label='dailyValue']"));		  	    
	  List<WebElement> dates =  driver.findElements(By.xpath("//table[@class='table borderTable fontTable']//tr[2]//td[@class='text-center']"));
	  List<String> newDate = new ArrayList<String>();
	    for(int i=0;i<dates.size();i++) {
			   System.out.println("Date ="+dates.get(i).getText());
			  String s1= dates.get(i).getText();
			  newDate.add(s1.substring(0,3));
  }  
	    for(int i=0;i<valueinput1.size();i++) {
		   System.out.println(i);
	       if(newDate.get(i).equals("Sat")||newDate.get(i).equals("Sun")) {
	    	   System.out.println("No need to fill for Sun and Sat");
	       }
	       else{
		   		Artlogin.getInputField().get(i).sendKeys("9");
		   		Thread.sleep(2000);
		  }
 }
	  
}*/





}
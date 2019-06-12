package MSPS_Script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Third_URL {
 
	
	@Test
	
  public void TimeSheetFilling() throws IOException, InterruptedException {
	  
        System.setProperty("webdriver.chrome.driver","C:\\Users\\shubham.o.gupta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        
		  
		driver.manage().window().maximize();  
        driver.get("https://adtppmind02ws2013stg.accenture.com/BV");
        WebDriverWait wait = new WebDriverWait(driver,90);    
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
        Email.sendKeys("Shubham.o.gupta@accenture.com");
        
        driver.findElement(By.xpath("//input[@type='submit']")).click();        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='passwordInput']")));
        WebElement password = driver.findElement(By.xpath("//input[@id='passwordInput']"));
        password.sendKeys("@Bestbuy8");        
        
        driver.findElement(By.xpath("//span[@id='submitButton']")).click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vipSkipBtn"))).click();
          }catch(Exception e) {
          	
            System.out.println("working");
          }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idBtn_Back"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Timesheet']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Actual']")));
        Thread.sleep(2000);
        List<WebElement> dates =  driver.findElements(By.xpath("//table[contains(@id,'TimesheetPartJSGridControl_rightpane')]//div//div/div[@coltype='text']"));
        List<String> newDate = new ArrayList<String>();
        for(int p=1;p<dates.size();p++) {
            System.out.println("Date ="+dates.get(p).getText());
           String s1= dates.get(p).getText();
           newDate.add(s1.substring(0,3));
        }  
        System.out.println("list of days : "+newDate);
        
	    FileInputStream fis = new FileInputStream("C:\\Users\\shubham.o.gupta\\Desktop\\TimeSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.println("Row count ="+rowCount);   
        
        
        String TaskName;
        String ProjectName;
        String Day;
        String WorkingHr;
        System.out.println(" Row Count of Excel :"+rowCount);
        
      loop1:
      for(int i=1;i<=rowCount;i++) {
    	   Thread.sleep(3000);
    	   System.out.println("..............................Around"+i+".......................................");    	  
    	  
    	   List<WebElement> valueinput1 = driver.findElements(By.xpath("//span[@title='Actual']//parent::td//parent::tr//td"));   
           List<WebElement> TaskNameList = driver.findElements(By.xpath("//table[contains(@id,'TimesheetPartJSGridControl_leftpane')]/tbody//tr//td[3]"));
           List<WebElement> projectNameList = driver.findElements(By.xpath("//table[contains(@id,'TimesheetPartJSGridControl_leftpane')]/tbody//tr//td[4]"));
           int Acutallinputlist = (valueinput1.size())/(TaskNameList.size());
           System.out.println(" Divided Acutall coloumn to fill : "+Acutallinputlist);
    
    	  TaskName = sheet.getRow(i).getCell(1).toString();
    	  ProjectName = sheet.getRow(i).getCell(2).toString();
    	  Day = sheet.getRow(i).getCell(3).toString();
    	  WorkingHr =sheet.getRow(i).getCell(4).toString();
    	  
		  System.out.println("Task Name  ="+TaskName);
		  System.out.println("ProjectName  ="+ProjectName);
		  System.out.println("Day  ="+Day);
		  System.out.println("Workig Hr.  ="+WorkingHr);

		  loop2:
		  for(int j=0;j<TaskNameList.size();j++) {
			  System.out.println("J = "+j);
			  Thread.sleep(3000);
			
			  for(int a=0; a<=2;a++){
			    try{
			    System.out.println(" TaskName = "+TaskNameList.get(j).getText());
			    System.out.println(" Project Name  = "+projectNameList.get(j).getText());
			    break;
			    }
			    catch(Exception e){
			       System.out.println(e.getMessage());
			    }
			  }
			  if(TaskNameList.get(j).getText().equals(TaskName)&&projectNameList.get(j).getText().equals(ProjectName)) {
		        int m = j;
				   loop4:
					  for(int d=1;d<dates.size();d++) {// for loop for Dates  matching 
						
						  System.out.println("Selected day from Excel sheet  :"+Day);
						  System.out.println("new Date  : "+newDate.get(d-1));
						  
					      if(newDate.get(d-1).contains(Day)) {// condition for dates
					    	 
					    	  Thread.sleep(2000);					    	
					    	  int row= j+1;
					    	  int q= d+1;					    	 
					    	  List<WebElement> rowlist = driver.findElements(By.xpath("//span[@title='Actual']//parent::td//parent::tr[1]//td["+q+"]"));
					    	  for(int p1=0;p1<rowlist.size();p1++) {
					    	
					    	  if( p1==j ) {					    	
					    		  rowlist.get(j);
					    		  System.out.println("checking :" +rowlist.get(j));					    	
					    	      rowlist.get(j).click();
					    	      rowlist.get(j).click();
					    	  
					    	  Thread.sleep(2000);
					    	  driver.findElement(By.xpath("//input[@id='jsgrid_editbox']")).sendKeys(WorkingHr);
					    	  driver.findElement(By.xpath("//span[text()='Actual']")).click();
					    	  
					    	  break loop2;
					    	  }
					      }
		             }
	             }		  
		     }
		  }
	  }
    }

 }

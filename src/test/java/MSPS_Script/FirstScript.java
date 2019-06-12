package MSPS_Script;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstScript {
	
	
	
  @Test
  public void firstAutoamtioScript() throws InterruptedException {
	  
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\shubham.o.gupta\\Downloads\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();

            driver.manage().window().maximize();  
            driver.get("https://adtppmus01ws2013stg.accenture.com/ADC_Training");
            WebDriverWait wait = new WebDriverWait(driver,90);
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
            Email.sendKeys("Shubham.o.gupta@accenture.com");
            
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='passwordInput']")));
            WebElement password = driver.findElement(By.xpath("//input[@id='passwordInput']"));
            password.sendKeys("@Bestbuy8");
            
            
            driver.findElement(By.xpath("//span[@id='submitButton']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vipSkipBtn"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idBtn_Back"))).click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Timesheet']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Actual']")));
            Thread.sleep(2000);
            
            List<WebElement> valueinput1 = driver.findElements(By.xpath("//span[@title='Actual']//parent::td//parent::tr//td")); 
           // WebElement valueinput = driver.findElement(By.xpath("//input[@id='jsgrid_editbox']"));
            List<WebElement> dates =  driver.findElements(By.xpath("//table[contains(@id,'TimesheetPartJSGridControl_rightpane')]//div//div/div[@coltype='text']"));
            List<String> newDate = new ArrayList<String>();
            
            for(int i=1;i<dates.size();i++) {
                System.out.println("Date ="+dates.get(i).getText());
               String s1= dates.get(i).getText();
               newDate.add(s1.substring(0,3));
            }  
            
            for(int i=1;i<dates.size();i++) {
                System.out.println(i);
             if(newDate.get(i).equals("Sat")||newDate.get(i).equals("Sun")) {
                System.out.println("No need to fill for Sun and Sat");
             }
             else{
            	 Thread.sleep(2000);
            	           valueinput1.get(i).click();
            	           valueinput1.get(i).click();
            	           Thread.sleep(2000);
            	           try {
	            	       driver.findElement(By.xpath("//input[@id='jsgrid_editbox']")).sendKeys("9");
            	           }catch(Exception e) {
            	        	   driver.findElement(By.xpath("//input[@id='jsgrid_editbox']")).sendKeys("9");
            	           }
                          
               }
   }
            
	  
	  
	  
  }

public static void main(String[] args) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idBtn_Back"))).click();
}
}

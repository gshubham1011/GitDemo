package com.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static Date date; 
	
	public static String captureScreenShot(WebDriver ldriver,String screenShotName)
	{   date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(" dd-MMM-YYYY h.mma");
        String date1= dateFormat.format(date);
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshots\\" + screenShotName + date1 +".png";
		
		try {
			FileHandler.copy(src, new File(path)) ;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return path;
	}
	

}

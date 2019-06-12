package MavenDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.testng.annotations.Test;

import com.monitorjbl.xlsx.StreamingReader;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;

import org.junit.BeforeClass;

public class ReadExcel {
	
	 /**
 	 * @author Shubham.o.gupta
 	 *
 	 * ${tags}
 	 */  
  @Test
//How to read excel files using Apache POI
	public static void reading() throws IOException{
     
   
			//FileInputStream fis = new FileInputStream("C:\\OPEN DEMAND RHL_Y.xlsx");
	        FileInputStream fis = new FileInputStream("C:\\Users\\shubham.o.gupta\\Desktop\\Timesheet.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
             /*          
		    Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
                     System.out.println("Cell    :"+cell);*/
                     
			
			int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
            System.out.println("Row count ="+rowCount);  
             int count = sheet.getRow(1).getLastCellNum()-sheet.getRow(1).getFirstCellNum();
             int count1 = sheet.getRow(2).getLastCellNum()-sheet.getRow(2).getFirstCellNum();
             
             
             
             
             
            System.out.println("value --->"+count);
            System.out.println("value --->"+count1);
          
            String s1= sheet.getRow(2).getCell(1).toString();
			System.out.println("Value  ="+sheet.getRow(2).getCell(1).toString());
			System.out.println("Value  ="+sheet.getRow(2).getCell(2).toString());
			System.out.println("Value  ="+sheet.getRow(2).getCell(3).toString());
			System.out.println("Value  ="+sheet.getRow(2).getCell(4).toString());
			System.out.println("Value  ="+sheet.getRow(2).getCell(5).toString());
			
		
	  
//			InputStream is = new FileInputStream(new File("C:\\Users\\shubham.o.gupta\\Desktop\\CLOSURE REPORT - FY19.xlsx"));
//			Workbook workbook = StreamingReader.builder()
//			        .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
//			        .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
//			        .open(is);
//			
//	   org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("CLOSURE REPORT");
//			 System.out.println("woorkbook "+sheet.getWorkbook());
//			  
//			 System.out.println("Valueeeeee ="+sheet.getCellComment(2, 2));
//			System.out.println("Value ="+sheet.getRow(3).getCell(3).toString());
			 
			
          
		
}
}

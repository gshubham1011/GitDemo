package MavenDemo;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xml.serialize.XMLSerializer;
import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.Test;

import com.monitorjbl.xlsx.StreamingReader;

public class VeryLargeFileRead {
	
	@Test(priority =1,enabled=false)
	public void ReadDataTrick3() throws FileNotFoundException {
		
	/*	
		InputStream is1 = new FileInputStream(new File("C:\\Users\\shubham.o.gupta\\Desktop\\CLOSURE REPORT.xlsx"));
		StreamingReader reader = StreamingReader.builder()
		        .rowCacheSize(10000)    // number of rows to keep in memory (defaults to 10)
		        .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
		        .sheetIndex(0)        // index of sheet to use (defaults to 0)
		        .read(is1);            // InputStream or File for XLSX file (required)

		
		for (Row r : reader) {
		  for (Cell c : r) {
			  System.out.println("Size   ="+c.getRow());
		    System.out.println(c.getStringCellValue());
		    
		  }
		}     */
		
		try (
				  InputStream is = new FileInputStream(new File("C:\\Users\\shubham.o.gupta\\Desktop\\CLOSURE REPORT.xlsx"));
				  Workbook workbook = StreamingReader.builder()
				          .rowCacheSize(100)
				          .bufferSize(4096)
				          .open(is)) {
				  for (Sheet sheet : workbook){
				    System.out.println(sheet.getSheetName());
				   // System.out.println("value "+sheet.getRow(3).getCell(4).getStringCellValue());
				    for (Row r : sheet) {
				      for (Cell c : r) {
				        System.out.println(c.getStringCellValue());
				      }
				    }
				  }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	@Test(priority =1,enabled=true)
	public void ReadingDataFile() throws FileNotFoundException, IOException {
		System.out.println("Started ");
		
		long start = System.currentTimeMillis();    
		     
		      InputStream is = new FileInputStream(new File("C:\\Users\\shubham.o.gupta\\Desktop\\CLOSURE REPORT.xlsx"));   
		      Workbook wb = StreamingReader.builder()   
		          .sstCacheSize(100)    
		          .open(is);    
		   
		      
		      
		    Sheet sheet = wb.getSheetAt(0);   
		    long count = 0;   
		    System.out.println("Sheet ="+sheet);
		    System.out.println("Sheet Name "+sheet.getSheetName());
		    System.out.println("Active Cell"+sheet.getActiveCell());
		    System.out.println("Value ="+sheet.getRow(2));
		    Workbook wb1 = sheet.getWorkbook();
		    XSSFSheet sheet1 = (XSSFSheet) wb1.getSheetAt(0);
		    
		    
		    for(Row row : sheet) { 
		    	
		      count++;  
		      
		      
		    }   
		    System.out.println("Read "+count+" rows in "+(System.currentTimeMillis() - start)+"ms"); 
		    
		    System.out.println("last Row "+sheet.getLastRowNum());
		    System.out.println("Value  ="+sheet1.getRow(2).getCell(2).toString());
		    
		    
		    
		    System.out.println("Value ="+sheet.getRow(5).getCell(5).getStringCellValue());
		    System.out.println("Value  ="+sheet.getRow(2).getCell(2).toString());
		    System.out.println("Value  ="+sheet.getRow(2).getCell(3).toString());
		    System.out.println("Value  ="+sheet.getRow(2).getCell(4).toString());
	    
		    
		  
		   System.out.println(org.jopendocument.dom.spreadsheet.Sheet.toStr(1));
			//System.out.println("Value  ="+sheet.getRow(2).getCell(1).toString());
		
		  
		  System.out.println("End");
		}
	
	
	
	
	
@Test(priority=2, enabled=false)
	public static void main() throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Step Started ");
		String fileName = "C:\\Users\\shubham.o.gupta\\Desktop\\example_2.json";
        try {           
            File file = new File ("C:\\Users\\shubham.o.gupta\\Desktop\\CLOSURE REPORT.xlsx");  
            InputStream inputStream = new FileInputStream(file);  
            StringBuilder builder =  new StringBuilder();  
            int ptr = 0;  
            while ((ptr = inputStream.read()) != -1 ) {  
                builder.append((char) ptr); 
              //  System.out.println(ptr);
            }  

            String xml  = builder.toString();  
            JSONObject jsonObj = XML.toJSONObject(xml);   
            // System.out.println(jsonObj.toString()); 
            // System.out.println(jsonObj.toString().split(",").length);
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Always close files.

            for(int i= 0 ;i < jsonObj.toString().split(",").length; i ++) {
               System.out.println(jsonObj.toString().split(",")[i]);
               bufferedWriter.write(jsonObj.toString().split(",")[i]);
               bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        }

         /* 
            String xmlString  = "<?xml version=\"1.0\"?><ASF_Service_ResponseVO id=\"1\"><service type=\"String\">OnboardingV2</service><operation type=\"String\">start_onboarding_session</operation><requested_version type=\"String\">1.0</requested_version><actual_version type=\"String\">1.0</actual_version><server_info type=\"String\">onboardingv2serv:start_onboarding_session&CalThreadId=85&TopLevelTxnStartTime=13b40fe91c4&Host=L-BLR-00438534&pid=3564</server_info><result type=\"Onboarding::StartOnboardingSessionResponse\" id=\"2\"><onboarding_id type=\"String\">137</onboarding_id><success type=\"bool\">true</success></result></ASF_Service_ResponseVO>"; 

            JSONObject jsonObj = XML.toJSONObject(xmlString);  
            System.out.println(jsonObj.toString());  
            */
        catch(IOException ex) {
                System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            } catch(Exception e) {  
                e.printStackTrace();  
            }
        System.out.println("End");
    } 
	             
	




}
	






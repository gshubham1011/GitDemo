package DSCO_Excel;

import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DCSOIssue {
    
	
	@SuppressWarnings({ "resource", "unused" })
	@Test
	public static void DSCOEXCELWrite() throws IOException {
		// TODO Auto-generated method stub

		//FileInputStream fis = new FileInputStream("C:\\OPEN DEMAND RHL_Y.xlsx");
		
		String dir = "C:\\Users\\shubham.o.gupta\\Desktop\\Touchless";
		
		File newFileName = lastFileModified(dir);
		
		System.out.println("File Name =     "+newFileName);
		
        FileInputStream fis = new FileInputStream(newFileName);
        System.out.println("found file");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        System.out.println("in workbook");
        XSSFSheet sheet = workbook.getSheet("SupplyTemplate");
        System.out.println("got sheet");
        
        Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
                 System.out.println("Cell    :"+cell);
                 
		
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.println("Row count =       "+rowCount);
        
        String s1= sheet.getRow(2).getCell(1).toString();
		System.out.println("Value  ="+sheet.getRow(2).getCell(1).toString());
		System.out.println("Value  ="+sheet.getRow(2).getCell(2).toString());
		System.out.println("Value  ="+sheet.getRow(2).getCell(3).toString());
		System.out.println("Value  ="+sheet.getRow(2).getCell(4).toString());
		System.out.println("Value  ="+sheet.getRow(2).getCell(5).toString());
		
		
		//writing into excel file --
		
		  Row newRow = sheet.createRow(rowCount+1);
		//Create a loop over the cell of newly created Row

		  Cell cell0 = row.createCell(0);
		  cell0.setCellValue("BPS");
		  
		  Cell cell1 = row.createCell(1);
		  cell1.setCellValue("FS");
		  Cell cell4 = row.createCell(4);
		  cell4.setCellValue("Scalable");
		  Cell cell7 = row.createCell(7);
		  cell7.setCellValue("Brasilia52");
		  Cell cell8 = row.createCell(8);
		  cell8.setCellValue("A");
		  Cell cell9 = row.createCell(9);
		  cell9.setCellValue("Approved");
		  Cell cell10 = row.createCell(10);
		  cell10.setCellValue("Mothballed");
		  Cell cell12 = row.createCell(12);
		  cell12.setCellValue("12/1/2019");		  
		  Cell cell13 = row.createCell(13);
		  cell13.setCellValue("12/1/2019");
		  Cell cell14 = row.createCell(14);
		  cell14.setCellValue("12/1/2019");
		  
		  Cell cell15 = row.createCell(15);
		  cell15.setCellValue("2");
		  Cell cell19 = row.createCell(19);
		  cell19.setCellValue("1");
		  Cell cell22 = row.createCell(22);
		  cell22.setCellValue("Available");
		  
		  Cell cell23 = row.createCell(23);
		  cell23.setCellValue("Common");
		  
		  System.out.println("value filled ");
		//  cell.setCellValue("SoftwareTestingMaterial.com");
		  FileOutputStream fos = new FileOutputStream(newFileName);
		  workbook.write(fos);
		  fos.close();
		  System.out.println("END OF WRITING DATA IN EXCEL");

		    //Close input stream

		    ((Closeable) newFileName).close();
		
		
		
		
		
	}

	
	
	public static File lastFileModified(String dir) {
	    File fl = new File(dir);
	    File[] files = fl.listFiles(new FileFilter() {          
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	    return choice;
	}
}

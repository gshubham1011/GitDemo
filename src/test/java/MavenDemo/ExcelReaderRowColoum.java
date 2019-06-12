package MavenDemo;




import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.BeforeClass;

public class ExcelReaderRowColoum {
	
@Test
public void excelReader() {
    String data;
    try {
        InputStream is = new FileInputStream("C:\\Users\\shubham.o.gupta\\Desktop\\Timesheet.xlsx");
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheetAt(0);
        Iterator rowIter = sheet.rowIterator();
        Row r = (Row)rowIter.next();
        short lastCellNum = r.getLastCellNum();
        int[] dataCount = new int[lastCellNum];
        int col = 0;
        rowIter = sheet.rowIterator();
        while(rowIter.hasNext()) {
            Iterator cellIter = ((Row)rowIter.next()).cellIterator();
            while(cellIter.hasNext()) {
                Cell cell = (Cell)cellIter.next();
                col = cell.getColumnIndex();
                dataCount[col] += 1;
                /*DataFormatter df = new DataFormatter();
                data = df.formatCellValue(cell);
                System.out.println("Data: " + data);*/
            }
        }
        is.close();
        for(int x = 0; x < dataCount.length; x++) {
            System.out.println("col " + x + ": " + dataCount[x]);
        }
    }
    catch(Exception e) {
        e.printStackTrace();
        return;
    } 
    
  }
}
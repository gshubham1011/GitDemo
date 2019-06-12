package MavenDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PiyushCode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		FileInputStream file2 = new FileInputStream("C:\\Users\\shubham.o.gupta\\Desktop\\OPEN DEMAND RHL_Y.xlsx");

		FileOutputStream fos = null;
		//@SuppressWarnings("resource")
			
				//HSSFWorkbook wb = new HSSFWorkbook(file2);
			   XSSFWorkbook wb = new XSSFWorkbook(file2);
				
				XSSFSheet SheetOne = wb.getSheet("OPEN DEMAND RHL_Y");
				XSSFRow row = null;
				
				XSSFCell cell = null;
				row= SheetOne.getRow(1);
				
			if (row==null){
						row = SheetOne.createRow(1);
					}
					
				cell = row.getCell(138);
				
				
			
				
			if(cell==null)
					{
						
						cell =row.createCell(138);
					}
					
						
				String strFormula= "COUNTIFS(C:C,\"=YES\",EC:EC,\"<>Y\",DI:DI,\"=NO\",N:N,\"<>Infra-OSS\",N:N,\"<>IO-DC\",N:N,\"<>IS\")";
				cell.setCellFormula(strFormula);
								
				FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
				CellValue cellValue = evaluator.evaluate(cell);
					
				
				System.out.println("The value number in Excel Open Demand---"+cellValue.getNumberValue()+"\n");

	}

}

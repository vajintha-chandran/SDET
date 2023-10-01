package queation1;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAnWriteDate { //Question 01-a
	
	public static void main(String[] args)  {
		
		ArrayList<List> a=new ArrayList<List>();
		a=read_data (".\\Resources\\StudentDetails.xlsx", "Sheet1"); //Question 01 -b
		print_data(a);  //Question 01 -c
	}
	
	
	//"read_data" method will read the data from the excel file and return the data in arrayList
	public static ArrayList<List> read_data(String workbookPath, String sheetName){
		
		ArrayList<List> testdata = new ArrayList<List>();
		
		try
		{
			FileInputStream inputStream = new FileInputStream(workbookPath);
			
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet(sheetName); 
			
			FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
			
			int rowCount=sheet.getLastRowNum();
			int columnCount=sheet.getRow(0).getLastCellNum();
			
			
			for(int i=1; i<=rowCount; i++) {
				List <Object> rowData=new ArrayList<Object>();
				XSSFRow row = sheet.getRow(i);
				
				for(int j=0; j<columnCount;j++) {
					
					XSSFCell cell=row.getCell(j);
					switch(formulaEvaluator.evaluateInCell(cell).getCellType()) {
					case Cell.CELL_TYPE_STRING:
						rowData.add(cell);
						break; 
					case Cell.CELL_TYPE_NUMERIC: 
						rowData.add(cell);
						break;						
					}
				}	

				testdata.add(rowData);
			}	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return testdata;
		
	}
	
	
	// "print_data" method is used to print the arraylist
	public static void print_data(ArrayList<List> data)
	{
		for(int i=0;i<data.size(); i++) {
			List<Object> x = new ArrayList<>();
			x=data.get(i);
			
			for (int j=0;j<x.size(); j++){
				System.out.println(x.get(j));
			}
			System.out.println();
		}
	}

}

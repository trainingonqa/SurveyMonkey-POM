package dataProvider;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProvidesData 
{
	XSSFWorkbook wb;
	//Constructor
	public ProvidesData() {
		
		File src = new File("./TestData/AppTestData.xlsx");
		try {
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is : "+e.getMessage());
		}
		
	}
	
	public String getData(int sheetIndex,int rowNo,int colNo) 
	{
		String data = wb.getSheetAt(sheetIndex).getRow(rowNo).getCell(colNo).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetName,int rowNo,int colNo) 
	{
		String data = wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
		return data;
	}
}

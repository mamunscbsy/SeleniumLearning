package readExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {

		// Open/Enter into the workbook

		XSSFWorkbook wb = new XSSFWorkbook("./data/ExcelSheet.xlsx");

		// Get Sheet
		XSSFSheet sheet = wb.getSheet("Sheet1");

		//Get row count
		/*int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		
		//Get column count
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);*/
		
		// Get row
		XSSFRow row = sheet.getRow(2);
	
		// Get column
		XSSFCell cell = row.getCell(0);
		
		
		// Actions -> Read value
		String value = cell.getStringCellValue();
		System.out.println(value);

	}

}

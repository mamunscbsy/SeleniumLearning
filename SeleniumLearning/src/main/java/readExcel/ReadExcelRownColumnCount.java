package readExcel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelRownColumnCount {

	public static void main(String[] args) throws IOException {

		// Open/Enter into the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/ReadData.xlsx");

		// Get Sheet
		XSSFSheet sheet = wb.getSheet("MM");

		// row count
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		
		//column count
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);

		// open 'for loop' for rows
		for (int i = 1; i <= rowCount; i++) {
			// Get row
			XSSFRow row = sheet.getRow(i);

			// open 'for loop' for columns
			for (int j = 0; j <columnCount; j++) {

				// Get column
				XSSFCell cell = row.getCell(j);
				
				// Actions -> Read value
				String value = cell.getStringCellValue();
				System.out.println(value);
			
			}//ends columns for loop
		}//ends rows for loop

	}

}

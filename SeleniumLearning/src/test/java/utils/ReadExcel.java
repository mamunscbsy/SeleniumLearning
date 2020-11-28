package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	//public static String[][] main(String[] args) throws IOException {
	
	public String[][] readExcel() throws IOException {
	
	//public String[][] readExcel() throws IOException {
	
		//public String[][] readExcel() throws IOException {
		// Open/Enter into the workbook
				XSSFWorkbook wb = new XSSFWorkbook("./data/ReadData.xlsx");

				// Get Sheet
				//XSSFSheet sheet = wb.getSheet("MM");
												
				XSSFSheet sheet = wb.getSheetAt(0);

				// row count
				int rowCount = sheet.getLastRowNum();
				System.out.println(rowCount);
				
				//column count
				int columnCount = sheet.getRow(0).getLastCellNum();
				System.out.println(columnCount);
				
				//	String[][] data = new String[2][3];
				
				String[][] data = new String[rowCount][columnCount];

				// open 'for loop' for rows(this loop enter into the every row)
				for (int i = 1; i <= rowCount; i++) {
					// Get row
					XSSFRow row = sheet.getRow(i);

					// open 'for loop' for columns(this loop enter into the every column)
					for (int j = 0; j <columnCount; j++) {

						// Get column
						XSSFCell cell = row.getCell(j);
						
						// Actions -> Read value
						String value = cell.getStringCellValue(); //get the cell value
						System.out.println(value);
						
						//i=1; i=1-1=0
						//data[0][0] = "TCS";
						
						data[i-1][j] = value;
								
					}//ends columns for loop
				}//ends rows for loop

				return data;
	}

}

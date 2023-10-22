package com.sample.testng;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderWithExcel {

	@DataProvider(name = "Authentication")
	public Object[][] getAuthenticationData() throws Exception {

		Workbook workbook = new XSSFWorkbook("‪C:\\Users\\Admin\\Desktop\\Manikandan.xlsx");

		Sheet worksheet = workbook.getSheet("Sheet1");

		int rowCount = worksheet.getLastRowNum() + 1;

		// Get the number of columns in the Excel sheet
		int columnCount = worksheet.getRow(0).getLastCellNum();

		// Create a 2D array to store the Excel data
		Object[][] data = new Object[rowCount - 1][columnCount];

		// Iterate over the Excel sheet rows and columns to read the data
		for (int i = 1; i < rowCount; i++) {
			Row row = worksheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				data[i - 1][j] = row.getCell(j).getStringCellValue();
			}
		}
		workbook.close();

		return data;
	}
}
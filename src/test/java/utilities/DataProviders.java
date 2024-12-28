/*package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {
		
		String path=".\\src\\test\\resources\\loginData.xlsx";
		String sheetName="Sheet1";
		ExcelUtility excelUT= new ExcelUtility(path);
		int rowCount= excelUT.getRowCount(sheetName);
		

		String[][] str = new String[rowCount-1][2];

		
		for(int i =1; i<= rowCount; i++) {
			int getCellCount= excelUT.getCellCount(sheetName, i);
			
				
				String un=excelUT.getCellData(sheetName, i, 0);
				String pass=excelUT.getCellData(sheetName, i, 1);
				str[i-1][0]=un;
				str[i-1][1]=pass;
		}
		
		
		return str;
		
	}

}*/
package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {
		
		// Updated path to point to the correct Excel file
		String path = ".\\src\\test\\resources\\loginData.xlsx";
		String sheetName = "Sheet1";
		ExcelUtility excelUT = new ExcelUtility(path);
		
		// Adjusted to get the correct row count (excluding the header row)
		int rowCount = excelUT.getRowCount(sheetName);
		System.out.println("rowCount:"+rowCount);
		int colCount = excelUT.getCellCount(sheetName, 1); // Added to get column count
		
		// Updated to include all columns (username, password, validation)
		String[][] str = new String[rowCount][colCount]; // Adjusted array dimensions
		
		for (int i = 1; i <= rowCount; i++) { // Changed loop to start at 1 (excluding header row)
			for (int j = 0; j < colCount; j++) { // Loop through columns dynamically
				str[i - 1][j] = excelUT.getCellData(sheetName, i, j); // Fetch data for all columns
			}
		}
		
		return str;
	}
}


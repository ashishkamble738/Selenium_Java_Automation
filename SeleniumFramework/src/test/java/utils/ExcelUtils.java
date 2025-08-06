package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getRowCount();
//		getCellDataString(1,0);
//		getCellDataNumber(1,1);		
	}
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public int getRowCount() {		
		int rowCount = 0;
		try {						
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows: " + rowCount);

		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();			
		}
		return rowCount;

	}
	
	public int getColCount() {		
		int colCount = 0;
		try {						
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns: " + colCount);

		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();			
		}
		return colCount;

	}

	public String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {			
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//			System.out.println(cellData);

		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();			
		}
		return cellData;

	}
	
	public void getCellDataNumber(int rowNum, int colNum) {

		try {			
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);


		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();			
		}

	}



}

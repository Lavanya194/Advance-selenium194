package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	public String getExcelValues(String SheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet(SheetName);

		// step4:- Navigating expected row--->row value starts from 0
		Row row = sheet.getRow(rowNum);

		// step5:- Navigating expected cell--->cell value starts from 0
		Cell cell = row.getCell(cellNum);
		

		String Exceldata = cell.getStringCellValue();
		System.out.println(Exceldata);
		return Exceldata;
		
	}
	public String getExcelDataFormatter(String SheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis2);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet(SheetName);

		// step4:- Navigating expected row--->row value starts from 0
		Row row = sheet.getRow(rowNum);

		// step5:- Navigating expected cell--->cell value starts from 0
		Cell cell = row.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String Exceldata = format.formatCellValue(cell);

				return Exceldata;
	}

	public Object[][] readDataUsingDataProvider(String SheetName) throws Throwable
	{
		FileInputStream fis3 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		Workbook book = WorkbookFactory.create(fis3);

		// step3:- Navigating expected sheet
		Sheet sheet = book.getSheet(SheetName);
		
		int lastRow=sheet.getLastRowNum()+1;
		int lastCell=sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
			
		}
		return obj;
	}
}
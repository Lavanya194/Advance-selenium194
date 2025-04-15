package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FetchAllLinksFromExcelFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");

		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("Sheet2");
		int rowNum=sheet.getLastRowNum();
		
		for(int i=0;i<rowNum;i++)
		{
			Row row=sheet.getRow(i);
			Cell cell=row.getCell(0);
			String links = cell.getStringCellValue();
			System.out.println(links);
		}
						
			
			


	}

}

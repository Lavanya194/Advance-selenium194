package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.zip.DataFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;

public class FetchingNumAndCharFromExcel {

	public static void main(String[] args) throws Throwable {
		//step1:-path connection
				FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
				
				//step2:-keeps the workbook/excelfile in read mode
				Workbook book=WorkbookFactory.create(fis);
				
				//step3:- Navigating expected sheet
				Sheet sheet=book.getSheet("Sheet1");
				
				//step4:-Navigating expected row------>row value starts from 0
				Row row=sheet.getRow(1);
				Row row1=sheet.getRow(2);
				
				//step5:-Navigating expected cell------->cell value starts from 0
				Cell cell=row.getCell(1);
				Cell cell1=row1.getCell(1);
				//Data formatter will print any type of data
				DataFormatter format = new DataFormatter();
				String excelData = format.formatCellValue(cell);
				String excelData1 = format.formatCellValue(cell1);

				// long excelData = (long) cell.getNumericCellValue();
				//String excelData1=cell1.getStringCellValue();

				System.out.println(excelData);
				System.out.println(excelData1);

				

	}

}

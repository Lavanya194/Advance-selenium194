package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PrintAllAmazonLinksInExcelSheet {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");

		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("Sheet2");
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(int i=0;i<allLinks.size();i++)
		{
			Row row=sheet.createRow(i);
			Cell cell=row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
		}
			FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
			book.write(fos);
			book.close();
			
			
			

				

		
	}
}



package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import Generic_utilities.WebDriver_utility;
import Object_Repo.CreateProductDetails;
import Object_Repo.DeleteProduct;
import Object_Repo.Home_page;
import Object_Repo.LoginPage;
import Object_Repo.PrdLookUp;
import Object_Repo.ProductValidation;

public class CreateToDeleteProduct {

	public static void main(String[] args) throws Throwable {
		
		Excel_utility elib = new Excel_utility();
		Java_utility jlib = new Java_utility();
		WebDriver_utility wlib = new WebDriver_utility();

		File_utility flib = new File_utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");


		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);
		
		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		Home_page home = new Home_page(driver);
		home.clickPrdLink();
		
		//driver.findElement(By.xpath("//img[@alt=\"Create Product...\"].click();
		PrdLookUp lookUp = new PrdLookUp(driver);
		lookUp.ClickPrdLookUp();
		
		Java_utility jib = new Java_utility();
		int ranNum = jib.getRandomNum();

		// step1:- path connection
		//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		//Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
		//Sheet sheet = book.getSheet("Product");

		// step4:- Navigating expected row--->row value starts from 0
		//Row row = sheet.getRow(0);

		// step5:- Navigating expected cell--->cell value starts from 0
		//Cell cell = row.getCell(0);

		//String prdName = cell.getStringCellValue()+ranNum;
		//System.out.println(prdName);
		
		String prdName = elib.getExcelValues("Product", 0, 0)+ranNum;
		System.out.println(prdName);
		
		//driver.findElement(By.name("productname")).sendKeys(prdName);

		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateProductDetails prd = new CreateProductDetails(driver);
		prd.enterPrdName(prdName);

		//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		//if (actData.contains(prdName)) {
		//	System.out.println("Product Name is created");
		//} else {
		//	System.out.println("Product Name is not created");
		//}
		
		ProductValidation validate = new ProductValidation(driver);
		validate.validateprd(driver, prdName);

		//driver.findElement(By.linkText("Products")).click();
		home.clickPrdLink();
		//table[@class="lvt small"]//a[text()='Product Name']/../preceding-sibling::td//input[@type="checkbox"]
		//driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+prdName+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		//driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		DeleteProduct deletePrd = new DeleteProduct(driver);
		deletePrd.selectPrdCheckBox(driver, prdName);
		deletePrd.clickDeletePrdButton();
		driver.switchTo().alert().accept();
		//wlib.alertAccept(driver);
		//List<WebElement> allNames = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		//boolean flag=false;
		//for (WebElement name : allNames)
		//{
			//String actPrd = name.getText();
			//if(actPrd.equals(prdName))
			//{
			//flag=true;
			//break;
		//}
		//	}
		//if(flag)
		//{
		//	System.out.println("product name is deleted");
		//}
		//else
		//{
		//	System.out.println("Product name is not deleted");
		//}
		
	//}
		Home_page home1 = new Home_page(driver);
		home1.signOut();

}
}
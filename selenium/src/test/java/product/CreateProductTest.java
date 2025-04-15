package product;

	import java.io.FileInputStream;
	import java.io.IOException;
import java.util.Properties;


	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;


import org.openqa.selenium.By;
//org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Object_Repo.CampValidation;
import Object_Repo.CreateProductDetails;
import Object_Repo.Home_page;
import Object_Repo.LoginPage;
import Object_Repo.PrdLookUp;
import Object_Repo.ProductValidation;
@Listeners(Generic_utilities.ExtentReportImp.class)
	public class CreateProductTest extends BaseClass {
	@Test(retryAnalyzer = Generic_utilities.RetryImp.class)
		public void CreateProductTest() throws Throwable {
			//FileInputStream fis = new FileInputStream("./src/test/resources/browserfirefox.properties");

			// step2:-create an object to properties class to load all the keys
			//Properties pro = new Properties();
			//pro.load(fis);

			// step3:-read the value using getProperty()
			//String BROWSER = pro.getProperty("browser");
			//String URL = pro.getProperty("url");
			//String USERNAME = pro.getProperty("username");
			//String PASSWORD = pro.getProperty("password");
			Excel_utility Elib = new Excel_utility();
			 File_utility flib=new File_utility();
			//String BROWSER=flib.getKeyAndValuePair("browser");
//			String URL=flib.getKeyAndValuePair("url");
//			String USERNAME=flib.getKeyAndValuePair("username");
//			String PASSWORD=flib.getKeyAndValuePair("password");



//			WebDriver driver;
//
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//			} else if (BROWSER.equalsIgnoreCase("firefox")) {
//				driver = new FirefoxDriver();
//			} else if (BROWSER.equalsIgnoreCase("edge")) {
//				driver = new EdgeDriver();
//			} else {
//				driver = new ChromeDriver();
//			}

//			driver.get(URL);
//			
//			//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			//driver.findElement(By.id("submitButton")).click();
//			LoginPage login=new LoginPage(driver);
//			login.loginIntoApp(USERNAME, PASSWORD);



			//driver.findElement(By.linkText("Products")).click();
			Home_page home = new Home_page(driver);
			home.clickPrdLink();
			
			//driver.findElement(By.xpath("//img[@alt=\"Create Product...\"].click();
			PrdLookUp lookUp = new PrdLookUp(driver);
			lookUp.ClickPrdLookUp();
			// step1:- path connection
			//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

			// step2:-keeps the workbook/excelfile in read mode
			//Workbook book = WorkbookFactory.create(fis1);

			// step3:- Navigating expected sheet
			//Sheet sheet = book.getSheet("Product");

			// step4:- Navigating expected row--->row value starts from 0
			//Row row = sheet.getRow(0);

			// step5:- Navigating expected cell--->cell value starts from 0
		//	Cell cell = row.getCell(0);

			//String prdName = cell.getStringCellValue();
			//System.out.println(prdName);
			
			String prdName = Elib.getExcelValues("Product", 0, 0);
			System.out.println(prdName);

			//driver.findElement(By.name("productname")).sendKeys(prdName);

			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			CreateProductDetails prd = new CreateProductDetails(driver);
			prd.enterPrdName(prdName);

			//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

			//if (actData.contains(prdName)) {
				//System.out.println("Product Name is created");
			//} else {
				//System.out.println("Product Name is not created");
			//}
			Assert.assertEquals(true,true);
			prd.clickSaveButton();
			
			ProductValidation validate = new ProductValidation(driver);
			String actData=validate.validateprd(driver, prdName);
			Assert.assertEquals(actData, prdName);
			System.out.println("Assert pass");
			//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
			//driver.findElement(By.linkText("Sign Out")).click();
			//home.signOut();

		}

	}
	



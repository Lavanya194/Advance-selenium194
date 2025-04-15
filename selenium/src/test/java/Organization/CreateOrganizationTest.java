package Organization;


			import java.io.FileInputStream;
			import java.io.FileNotFoundException;

import java.util.Properties;
//java.util.Properties;
			import java.util.Random;

			import org.apache.poi.ss.usermodel.Cell;
			import org.apache.poi.ss.usermodel.DataFormatter;
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
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import Generic_utilities.WebDriver_utility;
import Object_Repo.CreateOrgPage;
import Object_Repo.CreateOrgPageDetails;
import Object_Repo.Home_page;
import Object_Repo.LoginPage;
import Object_Repo.OrgValidate;

			public class CreateOrganizationTest extends BaseClass {

				@Test(groups="smokeTest")

				public void CreateOrganizationTest() throws Throwable {

					//FileInputStream fis = new FileInputStream("./src/test/resources/browserfirefox.properties");

					// step2:-create an object to properties class to load all the keys
					//Properties pro = new Properties();
					//pro.load(fis);

					// step3:-read the value using getProperty()
					//String BROWSER = pro.getProperty("browser");
					//String URL = pro.getProperty("url");
					//String USERNAME = pro.getProperty("username");
					//String PASSWORD = pro.getProperty("password");
					
//					File_utility flib=new File_utility();
//					//String BROWSER=flib.getKeyAndValuePair("browser");
//					String URL=flib.getKeyAndValuePair("url");
//					String USERNAME=flib.getKeyAndValuePair("username");
//					String PASSWORD=flib.getKeyAndValuePair("password");
//
//			WebDriver driver;
//
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//						driver = new ChromeDriver();
//					} else if (BROWSER.equalsIgnoreCase("firefox")) {
//						driver = new FirefoxDriver();
//					} else if (BROWSER.equalsIgnoreCase("edge")) {
//						driver = new EdgeDriver();
//					} else {
//						driver = new ChromeDriver();
//					}
//				WebDriver_utility wlib = new WebDriver_utility();
//					wlib.maximizeWindow(driver);
//					wlib.waitElementsToLoad(driver);
//					driver.get(URL);
//					//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//					//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//					//driver.findElement(By.id("submitButton")).click();
//					LoginPage login = new LoginPage(driver);
//					login.loginIntoApp(USERNAME, PASSWORD);

					//driver.findElement(By.linkText("Organizations")).click();
					
					
					Home_page home = new Home_page(driver);
					home.clickOrgLink();
				
					//driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]"));
					CreateOrgPage lookup = new CreateOrgPage(driver);
					lookup.enterOrgDetails();
					
					// To avoid Duplicates
					Java_utility jilib=new Java_utility();
					int ranNum = jilib.getRandomNum();
					
					// step1:- path connection
					//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

					// step2:-keeps the workbook/excelfile in read mode
					//Workbook book = WorkbookFactory.create(fis1);

					// step3:- Navigating expected sheet
					//Sheet sheet = book.getSheet("Organization");

					// step4:- Navigating expected row--->row value starts from 0
					//Row row = sheet.getRow(0);

					// step5:- Navigating expected cell--->cell value starts from 0
					//Cell cell = row.getCell(0);
					Excel_utility Exlib = new Excel_utility();
					String orgName = Exlib.getExcelValues("Organization",0,0)+ranNum;
					String phnNum=Exlib.getExcelDataFormatter("Organization", 1, 0);
					String emailId=Exlib.getExcelDataFormatter("Organization", 2, 0);
					CreateOrgPageDetails org = new CreateOrgPageDetails(driver);
					org.enterOrgDetails(orgName, phnNum, emailId);
					org.clickSaveButton();
					//driver.findElement(By.name("accountname")).sendKeys(orgName);
					// -------------------------------------------------------------------------------------------------------
					//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
					//Workbook book = WorkbookFactory.create(fis1);

					//Sheet sheet = book.getSheet("Organization");

					//Row row1 = sheet.getRow(1);
					//Cell cell1 = row1.getCell(0);
					//DataFormatter format = new DataFormatter();
					//String phnNum = format.formatCellValue(cell1);
					//driver.findElement(By.id("phone")).sendKeys(phnNum);
					// -------------------------------------------------------------------------------------------------------
					//Row row2 = sheet.getRow(2);
					//Cell cell2 = row2.getCell(0);
					//DataFormatter format1 = new DataFormatter();
					//String emailId = format1.formatCellValue(cell2);
					//driver.findElement(By.id("email1")).sendKeys(emailId);
					//driver.findElement(By.id("email1")).sendKeys(emailId);

					//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					Thread.sleep(2000);
					//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
				//if(actData.contains(orgName))
				//{
					//System.out.println("Organization name is created");
				//}
				//else
				//{
					//System.out.println("Organization name is not created");
				//}
					
					OrgValidate validate = new OrgValidate(driver);
					validate.validateOrg(driver, orgName);
				//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
				//driver.findElement(By.linkText("Sign Out")).click();
				
					home.signOut();
				}
				

			

}

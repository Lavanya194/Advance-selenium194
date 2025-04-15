package ContactwithOrganization;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import Generic_utilities.WebDriver_utility;
import Object_Repo.ContactLookUpImg;
import Object_Repo.ContactValidationPage;
import Object_Repo.CreateContactPage;
import Object_Repo.CreateOrgPage;
import Object_Repo.CreateOrgPageDetails;
import Object_Repo.Home_page;
import Object_Repo.LoginPage;
import Object_Repo.OrgValidate;
import Object_Repo.SwitchingWindowPage;
@Listeners(Generic_utilities.ListenersImp.class)

public class CreateContactwithOrganization extends BaseClass {
	@Test(retryAnalyzer = Generic_utilities.RetryImp.class)
		public static void main(String[] args) throws Throwable {

//			FileInputStream fis = new FileInputStream("./src/test/resources/browserfirefox.properties");
//
//			// step2:-create an object to properties class to load all the keys
//			Properties pro = new Properties();
//			pro.load(fis);

			// step3:-read the value using getProperty()
			//String BROWSER = pro.getProperty("browser");
			//String URL = pro.getProperty("url");
			//String USERNAME = pro.getProperty("username");
			//String PASSWORD = pro.getProperty("password");
			
			File_utility flib=new File_utility();
			Excel_utility elib=new Excel_utility();
			String BROWSER=flib.getKeyAndValuePair("browser");
			String URL=flib.getKeyAndValuePair("url");
			String USERNAME=flib.getKeyAndValuePair("username");
			String PASSWORD=flib.getKeyAndValuePair("password");



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

			driver.get(URL);
			
			//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			//driver.findElement(By.id("submitButton")).click();
			LoginPage login=new LoginPage(driver);
			login.loginIntoApp(USERNAME, PASSWORD);
			WebDriver_utility Wlib=new WebDriver_utility();
			Wlib.maximizeWindow(driver);
			Wlib.waitElementsToLoad(driver);
			
			//driver.findElement(By.linkText("Organizations")).click();
			//driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
			Home_page home=new Home_page(driver);
			home.clickOrgLink();
			CreateOrgPage lookup = new CreateOrgPage(driver);
			lookup.enterOrgDetails();
			
			// To avoid Duplicates
			//Random ran = new Random();
			//int ranNum = ran.nextInt(1000);
			
			Java_utility jilib=new Java_utility();
			int ranNum = jilib.getRandomNum();
			

			// step1:- path connection
//			FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
//
//			// step2:-keeps the workbook/excelfile in read mode
//			Workbook book = WorkbookFactory.create(fis1);
//
//			// step3:- Navigating expected sheet
//			Sheet sheet = book.getSheet("Organization");
//
//			// step4:- Navigating expected row--->row value starts from 0
//			Row row = sheet.getRow(0);
//
//			// step5:- Navigating expected cell--->cell value starts from 0
//			Cell cell = row.getCell(0);
//
//			String orgName = cell.getStringCellValue() + ranNum;
//			System.out.println(orgName);
			String orgName = elib.getExcelValues("Organization",0,0) + ranNum;
			System.out.println(orgName);
			
			  String phnNum = elib.getExcelDataFormatter("Organization", 1, 0);
				String emailId = elib.getExcelDataFormatter("Organization", 2, 0);
				
				CreateOrgPageDetails org = new CreateOrgPageDetails(driver);
				org.enterOrgDetails(orgName, phnNum, emailId);
				
			//driver.findElement(By.name("accountname")).sendKeys(orgName);
			// -------------------------------------------------------------------------------------------------------
//			Row row1 = sheet.getRow(1);
//			Cell cell1 = row1.getCell(0);
//			DataFormatter format = new DataFormatter();
//			String phnNum = format.formatCellValue(cell1);
//			driver.findElement(By.id("phone")).sendKeys(phnNum);
			// -------------------------------------------------------------------------------------------------------
//			Row row2 = sheet.getRow(2);
//			Cell cell2 = row2.getCell(0);
//			DataFormatter format1 = new DataFormatter();
//			String emailId = format1.formatCellValue(cell2);
//			driver.findElement(By.id("email1")).sendKeys(emailId);

			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				org.clickSaveButton();
				Thread.sleep(2000);
			
//				String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		if(actData.contains(orgName))
//		{
//			System.out.println("Organization name is created");
//		}
//		else
//		{
//			System.out.println("Organization name is not created");
//		}
				OrgValidate validate = new OrgValidate(driver);
				validate.validateOrg(driver, orgName);
//-------------------------------------------------------------------------------------------------------------------------------
			//driver.findElement(By.linkText("Contacts")).click();
			//driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
				home.clickContactLink();
				
				ContactLookUpImg Contact = new ContactLookUpImg(driver);
				Contact.clickContactLookUp();
				
//				WebElement ele=driver.findElement(By.xpath("//select[@name='salutationtype']"));
//			Select select = new Select(ele);
//			select.selectByValue("Mrs.");
//			Random ran1 = new Random();
//			int ranNum1 = ran1.nextInt(1000);
//
//			// step1:- path connection
//			FileInputStream fis2 = new FileInputStream("./src/test/resources/TestData.xlsx");
//
//			// step2:-keeps the workbook/excelfile in read mode
//			Workbook book1 = WorkbookFactory.create(fis2);
//
//			// step3:- Navigating expected sheet
//			Sheet sheet1 = book1.getSheet("Contact");
//
//			// step4:- Navigating expected row--->row value starts from 0
//			Row row3 = sheet1.getRow(0);
//
//			// step5:- Navigating expected cell--->cell value starts from 0
//			Cell cell3 = row3.getCell(0);
//
//			String fName = cell3.getStringCellValue() + ranNum1;
//			System.out.println(fName);

				CreateContactPage contactPage = new CreateContactPage(driver);
				contactPage.selectDropDOwnVAlue(driver);
				
				String FirstName = elib.getExcelValues("Contact", 0, 0);
				String LastName = elib.getExcelValues("Contact", 1, 0);
				contactPage.enterContactDetails(FirstName, LastName);
				
//			driver.findElement(By.name("firstname")).sendKeys(fName);
//			//-------------------------------------------------------------
//			Row row4 = sheet1.getRow(1);
//			Cell cell4 = row4.getCell(0);
//			String lName = cell4.getStringCellValue();
//			driver.findElement(By.name("lastname")).sendKeys(lName);
				
//						

			// -------------------------------------------------------------------------------------------------------				driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
			//driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
				contactPage.clickorgPlusSign();
				
//			Set<String> allWins = driver.getWindowHandles();
//			Iterator<String> it = allWins.iterator();
//
//			while (it.hasNext()) {
//				String win = it.next();
//				driver.switchTo().window(win);
//				String title = driver.getTitle();
//				if (title.contains("Contacts&action")) {
//					break;
//				}
//			}
				
				Wlib.windowSwitching(driver, "Accounts&action");

				SwitchingWindowPage switching = new SwitchingWindowPage(driver);
				switching.searchOrgNAme(orgName);
				switching.dynamicXpath1(driver, orgName);

			//driver.findElement(By.name("search_text")).sendKeys(orgName);
			//driver.findElement(By.cssSelector("[name=\"search\"]")).click();

			Thread.sleep(2000);
			//driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
			//-------------------------------------------------------------------------------------------------
//			Set<String> allWins1 = driver.getWindowHandles();
//			Iterator<String> it1 = allWins1.iterator();
//
//			while (it1.hasNext()) {
//				String win1 = it1.next();
//				driver.switchTo().window(win1);
//				String title1 = driver.getTitle();
//				if (title1.contains("Accounts&action")) {
//					break;
//				}
//			}
			
			Wlib.windowSwitching(driver, "Contacts&action");
			contactPage.clickSaveButton();
			
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//			String actData1 = driver.findElement(By.xpath("//span[@id=\"dtlview_First Name\"]")).getText();
//			if(actData1.contains(fName))
//			{
//				System.out.println("first name is created");
//			}
//			else
//			{
//				System.out.println("first name is not created");
//			}
//			driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
//			
			//if(actData.contains(lName))
//			{
//				System.out.println("Last name is created");
//			}
//			else
//			{
//				System.out.println("Last name is not created");
//			}

			OrgValidate validate2 = new OrgValidate(driver);
			validate2.validateOrg(driver, orgName);
			
			ContactValidationPage validate1 = new ContactValidationPage(driver);
			validate1.validateContactFirstNAme(driver, FirstName);
			validate1.validateContactLastNAme(driver, LastName);
			
			
			
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
			home.logOut(driver);
		}

	
	

}

package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import Generic_utilities.WebDriver_utility;
import Object_Repo.CampLookUpImg;
import Object_Repo.CampValidation;
import Object_Repo.CreateCampPage;
import Object_Repo.Home_page;
import Object_Repo.LoginPage;
@Listeners(Generic_utilities.ExtentReportImp.class)
public class CreateCampaignTest  extends BaseClass {
	@Test(retryAnalyzer = Generic_utilities.RetryImp.class)
	public void CreateCampaignTest() throws Throwable {
		//i am Eng1---------
		//Eng2-----------
		 Excel_utility Exlib = new Excel_utility();
		 Java_utility jlib=new Java_utility();
		 //WebDriver_utility wlib = new WebDriver_utility();


//		File_utility flib=new File_utility();
//		//String BROWSER=flib.getKeyAndValuePair("browser");
//		String URL=flib.getKeyAndValuePair("url");
//		String USERNAME=flib.getKeyAndValuePair("username");
//		String PASSWORD=flib.getKeyAndValuePair("password");
//

	//WebDriver driver;
//
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//wlib.maximizeWindow(driver);
//wlib.waitElementsToLoad(driver);

		//driver.get(URL);
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		//using getter method
		//LoginPage login=new LoginPage(driver);
		//login.getUserTextField().sendKeys(USERNAME);
		//login.getPassWordTextField().sendKeys(PASSWORD);
		//login.getLoginButton().click();
		
//		//Business Logic
//		LoginPage login=new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);


		
		//Actions a=new Actions(driver);
		//WebElement ele = driver.findElement(By.linkText("More"));
		//a.moveToElement(ele).perform();
		//driver.findElement(By.linkText("Campaigns")).click();
		Home_page home=new Home_page(driver);
		home.clickCampLink();

		//driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
CampLookUpImg lookUp=new CampLookUpImg(driver);
lookUp.clickCampLookUp();

		// step1:- path connection
		//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:-keeps the workbook/excelfile in read mode
		//Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating expected sheet
		//Sheet sheet = book.getSheet("Campaign");

		// step4:- Navigating expected row--->row value starts from 0
		//Row row = sheet.getRow(0);

		// step5:- Navigating expected cell--->cell value starts from 0
		//Cell cell = row.getCell(0);

		String CampName = Exlib.getExcelValues("Campaign", 0, 0);
		System.out.println(CampName);

		//driver.findElement(By.name("campaignname")).sendKeys(campName);

		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateCampPage camp=new CreateCampPage(driver);
		camp.enterCampDetails(CampName);
		//String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		//if (actData.contains(CampName)) {
			//System.out.println("campaign Name is created");
		//} else {
			//System.out.println("campaign Name is not created");
		//}
		
		Assert.assertEquals(true,true);
		camp.clickSaveButton();
		
		CampValidation validate=new CampValidation(driver);
		String actData = validate.validateCamp(driver, CampName);
		Assert.assertEquals(actData, CampName);
		System.out.println("Assert pass");
		
		//driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		// home.logOut(driver);
//		home.signOut();
	}


	}



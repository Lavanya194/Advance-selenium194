package ProductToCampaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import Generic_utilities.WebDriver_utility;
import Object_Repo.CampLookUpImg;
import Object_Repo.CampValidation;
import Object_Repo.CreateCampPage;
import Object_Repo.CreateProductDetails;
import Object_Repo.Home_page;
import Object_Repo.LoginPage;
import Object_Repo.PrdLookUp;
import Object_Repo.ProductValidation;
import Object_Repo.SwitchingWindowPage;

public class CreateCampaignAndProduct 
{
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
//		driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(http://By.id("submitButton")).click();

		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		// driver.findElement(By.linkText("Products")).click();
		Home_page home = new Home_page(driver);
		home.clickPrdLink();

		// driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
		PrdLookUp lookUp = new PrdLookUp(driver);
		lookUp.ClickPrdLookUp();

		int ranNum = jlib.getRandomNum();

		String prdName = elib.getExcelValues("Product", 0, 0) + ranNum;
		System.out.println(prdName);

//		driver.findElement(http://By.name("productname")).sendKeys(prdName);
//
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		CreateProductDetails prdPage = new CreateProductDetails(driver);
		prdPage.enterPrdName(prdName);

//------------------------------------------------------------------------------------------
//		driver.findElement(By.linkText("More")).click();
//		driver.findElement(By.linkText("Campaigns")).click();
		home.clickCampLink();

//		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampLookUpImg lookUpImg = new CampLookUpImg(driver);
		lookUpImg.clickCampLookUp();

		String CampName = elib.getExcelValues("Campaign", 0, 0)+ranNum;

		System.out.println(CampName);

		// driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampDetails(CampName);

		// driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		campPage.clickPrdPlusSign();

		wlib.windowSwitching(driver, "Products&action");

//		driver.findElement(http://By.name("search_text")).sendKeys(prdName);
//		driver.findElement(By.cssSelector("[name=\"search\"]")).click();

		SwitchingWindowPage switching = new SwitchingWindowPage(driver);
		switching.searchPrdNAme(prdName);
		switching.dynamicXpath(driver, prdName);

		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Puma']")).click();
		// Dynamic Xpath
//		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		// -------------------------------------------------------------------------------------------------

		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();

//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
//		campPage.clickSaveButton();
//		
//		if (actData.equals(CampName)) {
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}
//
//		String actPrd = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
//		if (actPrd.equals(prdName)) {
//			System.out.println("product name is created");
//		} else {
//			System.out.println("product name is not created");
//		}

		CampValidation validate = new CampValidation(driver);
		validate.validateCamp(driver, CampName);
		ProductValidation validate1=new ProductValidation(driver); 
		validate1.validateprd(driver, prdName);

//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		home.logOut(driver);
	}
}



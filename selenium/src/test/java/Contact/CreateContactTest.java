package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import Generic_utilities.WebDriver_utility;
import Object_Repo.ContactLookUpImg;
import Object_Repo.ContactValidationPage;
import Object_Repo.CreateContactPage;
import Object_Repo.Home_page;
import Object_Repo.LoginPage;
@Listeners(Generic_utilities.ListenersImp.class)

public class CreateContactTest extends BaseClass {
	@Test(retryAnalyzer = Generic_utilities.RetryImp.class)
	public void CreateContactTest() throws Throwable {
		
		Excel_utility Exlib = new Excel_utility();
		 Java_utility jlib=new Java_utility();
		//WebDriver_utility wlib = new WebDriver_utility();
//		File_utility flib = new File_utility();
//		String BROWSER=flib.getKeyAndValuePair("browser");
//		String URL=flib.getKeyAndValuePair("url");
//		String USERNAME=flib.getKeyAndValuePair("username");
//		String PASSWORD=flib.getKeyAndValuePair("password");
//		
//		WebDriver driver;
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
//		wlib.maximizeWindow(driver);
//		wlib.waitElementsToLoad(driver);
//		
//		driver.get(URL);
//		
//		LoginPage login=new LoginPage(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);
		
		Home_page home=new Home_page(driver);
		home.clickContactLink();
		
		ContactLookUpImg Contact = new ContactLookUpImg(driver);
		Contact.clickContactLookUp();
		
		CreateContactPage contactPage = new CreateContactPage(driver);
		contactPage.selectDropDOwnVAlue(driver);
		Excel_utility elib = new Excel_utility();
		String FirstName = elib.getExcelValues("Contact", 0, 0);
		String LastName = elib.getExcelValues("Contact", 1, 0);
		contactPage.enterContactDetails(FirstName, LastName);
		
		contactPage.clickSaveButton();


		ContactValidationPage validate = new ContactValidationPage(driver);
		String actData=validate.validateContactFirstNAme(driver, FirstName);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actData, FirstName);
		System.out.println("Asset PASS");
		
		validate.validateContactLastNAme(driver, LastName);
		
		//home.logOut(driver);
		
		
		
		

		
		
	}

}

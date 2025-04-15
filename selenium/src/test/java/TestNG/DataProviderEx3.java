package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.Excel_utility;

public class DataProviderEx3 {
	@Test(dataProvider="readContactNames")
	public void createContact(String FirstName, String LastName)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
	@DataProvider
	public Object[][] readContactNames() throws Throwable
	{
			
		Object[][] objArr = new Object[3][2];
		
		Excel_utility elib = new Excel_utility();
		Object[][] data = elib.readDataUsingDataProvider("ContactNames");
		return data;
	}
}




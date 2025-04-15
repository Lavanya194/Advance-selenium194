package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampValidation {
	
	public CampValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateCamp(WebDriver driver,String CampName)
	{
		return driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		
		
//		if (actData.equals(campName)) {
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}
	}
}

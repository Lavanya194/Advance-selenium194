package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactValidationPage {
	
	public ContactValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String validateContactFirstNAme(WebDriver driver,String FirstName)

	{
		String actFirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();

		return actFirstName;
//		if (actFirstName.contains(FirstName)) {
//			System.out.println("contact first name is created");
//		} else {
//			System.out.println("contact first name is not created");
//		}
	}
	
	public void validateContactLastNAme(WebDriver driver,String LastName )
	{
		String actLastName = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();

		if (actLastName.contains(LastName)) {
			System.out.println("contact last name is created");
		} else {
			System.out.println("contact last name is not created");
		}
	}
}

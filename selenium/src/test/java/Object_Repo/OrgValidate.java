package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrgValidate {
	public OrgValidate(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void validateOrg(WebDriver driver,String orgName )
	{
		String actorg = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if (actorg.contains(orgName)) {
			System.out.println("Organization name is created");
		} else {
			System.out.println("Organization name is not created");
		}
	}
}

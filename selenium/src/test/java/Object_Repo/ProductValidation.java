package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductValidation {
	public ProductValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String validateprd(WebDriver driver,String prdName)
	{
		return driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
//		if (actPrd.equals(prdName)) {
//			System.out.println("product name is created");
//		} else {
//			System.out.println("product name is not created");
//		}

	}

}

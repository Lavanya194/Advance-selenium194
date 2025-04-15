package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
	private WebElement orgLookUp;
	
	public WebElement getOrgLookUp() {
		return orgLookUp;
	}

	
	public void enterOrgDetails()

	{
		orgLookUp.click();
		
	}
	

}

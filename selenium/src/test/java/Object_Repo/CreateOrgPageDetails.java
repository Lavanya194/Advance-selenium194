package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPageDetails {
	public CreateOrgPageDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement OrgAccName;
	
	@FindBy(id="phone")
	private WebElement OrgPhnNum;
	
	@FindBy(id="email1")
	private WebElement OrgEmail;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getOrgAccName() {
		return OrgAccName;
	}

	public WebElement getOrgPhnNum() {
		return OrgPhnNum;
	}

	public WebElement getOrgEmail() {
		return OrgEmail;
	}
	
public void enterOrgDetails(String Name, String PhnNum,String Email) 
{
	OrgAccName.sendKeys(Name);
	OrgPhnNum.sendKeys(PhnNum);
	OrgEmail.sendKeys(Email);
	
}
public void clickSaveButton()
{
	savebutton.click();
}
}

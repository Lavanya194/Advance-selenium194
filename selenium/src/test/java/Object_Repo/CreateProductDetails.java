package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductDetails {
	public CreateProductDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="productname")
	private WebElement prdName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getPrdName() {
		return prdName;
	}
	
	public void enterPrdName(String name)
	{
		prdName.sendKeys(name);
		saveButton.click();
		
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	

}

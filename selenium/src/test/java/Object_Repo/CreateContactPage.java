package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utilities.WebDriver_utility;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
}

@FindBy(name = "firstname")
private WebElement firstName;

@FindBy(name = "lastname")
private WebElement lastName;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveButton;

@FindBy(xpath = "//img[@alt=\"Select\"]")
private WebElement orgPlusSign;

public WebElement getFirstName() {
	return firstName;
}



public WebElement getLastName() {
	return lastName;
}



public WebElement getSaveButton() {
	return saveButton;
}

public void setSaveButton(WebElement saveButton) {
	this.saveButton = saveButton;
}

public WebElement getorgPlusSign() {
	return orgPlusSign;
}


public void selectDropDOwnVAlue(WebDriver driver)
{
	WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	WebDriver_utility wlib = new WebDriver_utility();
	wlib.dropDown(ele, "Mrs.");
}

public void enterContactDetails(String firstname, String lastname)

{
	firstName.sendKeys(firstname);
	lastName.sendKeys(lastname);
}

public void clickSaveButton()
{
	saveButton.click();
}
public void clickorgPlusSign()
{
	orgPlusSign.click();
}
}

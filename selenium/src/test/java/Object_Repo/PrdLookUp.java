package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrdLookUp {
	public PrdLookUp(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath="//img[@alt=\"Create Product...\"]")
private WebElement prdlookUp;

public WebElement getPrdlookUp() {
	return prdlookUp;
}

public void ClickPrdLookUp()
{
prdlookUp.click();
}
}

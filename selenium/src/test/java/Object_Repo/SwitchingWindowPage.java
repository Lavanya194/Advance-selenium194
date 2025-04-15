package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchingWindowPage {
	
	public SwitchingWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "search_text")
	private WebElement searchPrd;
	
	@FindBy(css = "[name=\"search\"]")
	private WebElement searchBar;
	
	@FindBy(name = "search_text")
	private WebElement searchOrg;
	
	
	public WebElement getSearchOrg() {
		return searchOrg;
	}


	public void setSearchOrg(WebElement searchOrg) {
		this.searchOrg = searchOrg;
	}


	public WebElement getSearchPrd() {
		return searchPrd;
	}


	public WebElement getSearchBar() {
		return searchBar;
	}
	
	public void searchPrdNAme(String name)
	{
		searchPrd.sendKeys(name);
		searchBar.click();
	}
	public void searchOrgNAme(String name)
	{
		searchOrg.sendKeys(name);
		searchBar.click();
	}
	
	public void dynamicXpath(WebDriver driver,String productName)
	{
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();

	}
	public void dynamicXpath1(WebDriver driver,String orgName)
	{
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

	}
	

	
}

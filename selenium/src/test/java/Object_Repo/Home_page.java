package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utilities.WebDriver_utility;

public class Home_page {
	
	public Home_page(WebDriver driver)
	{
		
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(linkText = "More")
		private WebElement moreLink;
		
		@FindBy(linkText = "Campaigns")
		private WebElement campLink;

		@FindBy(css = "[src='themes/softed/images/user.PNG']")
		private WebElement admLink;
		
		
		@FindBy(linkText = "Sign Out")
		private WebElement signOut;
		
		@FindBy(linkText="Organizations")
		private WebElement OrgName;
		
		@FindBy(linkText="Products")
		private WebElement PrdName;
		
		@FindBy(linkText="Contacts")
		private WebElement ContactName;
		
		
		
		public WebElement getContactName() {
			return ContactName;
		}


		public WebElement getPrdName() {
			return PrdName;
		}


		//getter methods
		public WebElement getMoreLink() {
			return moreLink;
		}

		public WebElement getCampLink() {
			return campLink;
		}
		public WebElement getPrdLink() {
			return PrdName;
		}
		public WebElement getOrgName() {
			return OrgName;
		}
		

		
		/**
		 * This method is used to click campaign link
		 */
		public void clickCampLink()
		{
			moreLink.click();
			campLink.click();
			
		}
		public void clickOrgLink()
		{
			
			OrgName.click();
			
		}
		public void clickPrdLink()
		{
			
			PrdName.click();
			
		}
		public void clickContactLink()
		{
			
			ContactName.click();
			
		}
		
		public void logOut(WebDriver driver)
		{
			WebDriver_utility wlib = new WebDriver_utility();
			wlib.mouseHoverToEle(driver, admLink);
			signOut.click();
		}
		
		public void signOut()
		{
			admLink.click();
			signOut.click();
		}
	}
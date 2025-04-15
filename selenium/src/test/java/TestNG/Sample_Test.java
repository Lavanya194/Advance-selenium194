package TestNG;

import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
@Test
public class Sample_Test extends BaseClass{
	
	public void createContact()
	{
		System.out.println("contact created");
	}

	public void modifyContact()
	{
		
		System.out.println("contact modified");
	}
	
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}
}

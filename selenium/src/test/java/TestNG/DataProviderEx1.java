package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test(dataProvider="getData")

public class DataProviderEx1 {
	public void bookTickets(String src, String dest,int PassengersCount)
	{
		System.out.println("Book tickets from "+src+" to "+dest+" No. of passengers travelling "+PassengersCount);
		
	}
	@DataProvider
public Object[][] getData()
{
	Object[][] objArr = new Object[3][3];
	objArr[0][0]="Bangalore";
	objArr[0][1]="Mysuru";
	objArr[0][2]=50;
	
	objArr[1][0]="Bangalore";
	objArr[1][1]="Hassan";
	objArr[1][2]=55;
	
	objArr[2][0]="Bangalore";
	objArr[2][1]="Mangalore";
	objArr[2][2]=60;
	
	return objArr;
	
}
}

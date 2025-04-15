package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PrintAllBluetoothNamesAndPricesFromAmazon {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("bluetooth");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().window().maximize();
		List<WebElement> name = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
		for(int i=0;i<name.size();i++)
		{
			WebElement ele = name.get(i);
			WebElement ele1 = price.get(i);

			String txt = ele.getText();
			String txt1 = ele1.getText();

			System.out.println(txt);
			System.out.println(txt1);

			
		}
	}

}

package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PrintProKabbadiMatchPoints {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		String name = driver.findElement(By.xpath("//p[text()='Haryana Steelers']")).getText();
		String P = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-play']")).getText();
		String W = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']")).getText();
		String L = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-lost']")).getText();

			System.out.println(name);
			System.out.println(P);
			System.out.println(W);
			System.out.println(L);



			
		
	

	}

}

package DDT;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
		Properties pro = new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "http://localhost:8888");
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/InsertData.txt");
		pro.store(fos, "StoringData");
		

	}

}

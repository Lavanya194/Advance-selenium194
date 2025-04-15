package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_utility {
	/**
	 * This method is used to read data from Properties file(External resource)
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Lavanya L L
	 */
	public String getKeyAndValuePair(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/browserfirefox.properties");

		// step2:-create an object to properties class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String Value= pro.getProperty(key);
		return Value;
		
	}

}

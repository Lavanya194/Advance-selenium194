package Generic_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ListenersImp implements ITestListener{
	
	public void onTestFailure(ITestResult result)
	{
		TakesScreenshot takesScreenShot = (TakesScreenshot) BaseClass.sdriver;
		File src = takesScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./failedScript.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}


package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots {

	public static void captureScreenshots(WebDriver driver,String filename) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File filsource = ts.getScreenshotAs(OutputType.FILE);
		
		File destination= new File(System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png");
		 
		FileHandler.copy(filsource, destination);
		
		
	}
}

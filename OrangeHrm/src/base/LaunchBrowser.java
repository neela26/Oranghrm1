package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class LaunchBrowser {
public	static WebDriver driver;
	
	 @BeforeSuite
	 public void initBrowser() throws IOException {
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\WebDriverExe\\chromedriver.exe");
		 driver=new ChromeDriver();
		 Properties pro=new Properties();
		
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
		 pro.load(fis);
	     driver.get(pro.getProperty("testsiteurl"));
		 driver.manage().window().maximize(); 
		 Reporter.log("before suite: launch browser ",true);
	 }
	 
	 @AfterSuite
	 public void closeBrowser()
	 {
		 driver.quit();
       Reporter.log("after suite: browser close",true);
	 }
	 
}

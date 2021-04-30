package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.ScreenShots;

/***
 * 
 *@Neelam
 */
public class Login extends LaunchBrowser {

	@Test(priority=1)
	public void logintestcase() throws IOException {
		 Properties pro=new Properties();
			
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
	pro.load(fis);
	driver.findElement(By.xpath("//*[contains(@id, 'txtUser')]")).sendKeys(pro.getProperty("username"));
	driver.findElement(By.xpath("//*[@id='txtPassword' and @name = 'txtPassword']")).sendKeys(pro.getProperty("password"));
	driver.findElement(By.xpath("//*[contains(@name,'Submit')]")).click();
	
	String actual=driver.getCurrentUrl();
	String expected="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	Assert.assertEquals(actual,expected,"login a"
			+ "ssert pass");
	Reporter.log("Login pass",true);

		
	}
	
	@Test(priority=3)
	public void logout() throws InterruptedException {
		
		Thread.sleep(200);
           //WebDriverWait wait =new WebDriverWait(driver,20);
		   driver.findElement(By.id("welcome")).click();
         // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Logout"))));
         
		   Thread.sleep(200);
           driver.findElement(By.linkText("Logout")).click();
		   String actual=driver.getCurrentUrl();
		   String expected="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		   Assert.assertEquals(actual, expected);
		   
	}
	
	@Test (priority=4 ,dependsOnMethods="logout")
	public void invalidLogin() throws IOException {
		
		 Properties pro=new Properties();
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
			pro.load(fis);
			driver.findElement(By.xpath("//*[contains(@id, 'txtUser')]")).sendKeys("jbfgdfj");
			driver.findElement(By.xpath("//*[@id='txtPassword' and @name = 'txtPassword']")).sendKeys(pro.getProperty("password"));
			driver.findElement(By.xpath("//*[contains(@name,'Submit')]")).click();
		    String invalidMsg=driver.findElement(By.id("spanMessage")).getText();
		    String actual=invalidMsg;
			String expected="Invalid credentials";
            //SoftAssert sa=new SoftAssert();
			if(actual.equals(expected)){
				Reporter.log("invalid taste case pass",true);
				ScreenShots.captureScreenshots(driver, "oranghrm1");
			}
			else{
				Reporter.log("invalid test case case fail",true);
			}
			//sa.assertAll();
			
	}
	
}

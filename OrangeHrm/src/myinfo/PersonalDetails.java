package myinfo;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.LaunchBrowser;

public class PersonalDetails extends LaunchBrowser{

	@BeforeClass 
	public void moveMyInfo()  {
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("My Info")).click();
    Reporter.log("after class:move to my info",true);
  }
	
	@Test(priority=2,dependsOnMethods="base.Login.logintestcase")
	public void personalDetailsForm() {
		
		driver.findElement(By.xpath("//*[@id='btnSave' and @value='Edit']")).click();
		WebElement fname = driver.findElement(By.xpath("//*[@id='personal_txtEmpFirstName']"));
		fname.clear();
		fname.sendKeys("neelam");
		WebElement lastname = driver.findElement(By.xpath("//*[@id='personal_txtEmpLastName']"));
		lastname.clear();
		lastname.sendKeys("rasal");
		
		
		
		//Reporter.log("personal details",true);
	}
	
	@AfterClass
	public void moveDashboard() {
	    driver.findElement(By.linkText("Dashboard")).click();
	    Reporter.log("after class:move to dashboard",true);
	
	}
	
}

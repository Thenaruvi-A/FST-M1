package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testactivity1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		//initlizr driver and wait
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	// OPen page
		driver.get("https://training-support.net");
	}
	
	@Test(priority=1)
	public void homePageTest() {
		//Assetions, fom sssertion function(org.test,ng)
		//Assert.assertEquals(actual,expected)
		Assert.assertEquals(driver.getTitle(),"Training Support");
	}
	
	@Test(priority=2)
	public void aboutPageTest() {
		//Assetions, fom sssertion function(org.test,ng)
		//Assert.assertEquals(actual,expected)
		driver.findElement(By.linkText("About Us")).click();
								
		Assert.assertEquals(driver.getTitle(),"About Training Support");
	}
	@AfterClass
	public void teardown() {
		//close page
		driver.quit();
	}
}


package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

	BaseClass obj =new BaseClass();
	WebDriver driver;
	
@BeforeClass
public void setup() {

	driver = obj.SetUp();
 
}

@Test(priority=1)
public void myAccountTiltleTest() {
	driver.findElement(By.linkText("My Account")).click();

	Assert.assertEquals(driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText(), "My Account");
	
}

@Test(priority=2)
public void myAccountLoginTest() {
	driver.findElement(By.linkText("Login")).click();
	System.out.println("Page title" + driver.getTitle());
	driver.findElement(By.id("user_login")).sendKeys("root");
	driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	driver.findElement(By.id("wp-submit")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='admin-email__heading']")).getText(),"Administration email verification");
}

@AfterClass
public void teardown() {
	//close page
	driver.quit();
}
}
package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {

	BaseClass obj =new BaseClass();
	WebDriver driver;

@BeforeClass
public void setup() {

	driver = obj.SetUp();
 
}

@Test
public void secondPopularCourseTest() {
	//Assetions, fom sssertion function(org.test,ng)
	//Assert.assertEquals(actual,expected)
	Assert.assertEquals(driver.findElement(By.cssSelector("#post-71 > div:nth-child(3) > h3:nth-child(1)")).getText(), "Email Marketing Strategies");
	//Email Marketing Strategies
}

@AfterClass
public void teardown() {
	//close page
	driver.quit();
}
}
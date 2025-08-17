package project;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	BaseClass obj =new BaseClass();

@BeforeClass
public void setup() {

	driver = obj.SetUp();
}

@Test
public void homePageTitleTest() {
	//Assetions, fom sssertion function(org.test,ng)
	//Assert.assertEquals(actual,expected)
	Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(), 'Industry')]")).getText(), "Learn from Industry Experts");
	//System.out.println("Page Title is: "+actualTitle);
}

@AfterClass
public void teardown() {
	//close page
	driver.quit();

}
}
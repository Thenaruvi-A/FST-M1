package project;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity1 {

	BaseClass obj =new BaseClass();
	WebDriver driver;

@BeforeClass
public void setup() {

	driver = obj.SetUp();
 
}

@Test
public void homePageTitleTest() {
	//Assetions, fom sssertion function(org.test,ng)
	//Assert.assertEquals(actual,expected)
	Assert.assertEquals(driver.getTitle(),"Alchemy LMS – An LMS Application");
}

@AfterClass
public void teardown() {
	//close page
	driver.quit();
}
}

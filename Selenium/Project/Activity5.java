package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
	BaseClass obj =new BaseClass();
	WebDriver driver;
	
//@BeforeTest	
@BeforeClass
public void setup() {

	driver = obj.SetUp();
 
}

//@BeforeClass
//public void myAccountpage() {
//	driver.findElement(By.linkText("My Account")).click();
  //  driver.get("https://alchemy.hguy.co/lms/my-account/");  
//}


@Test
public void myAccountTiltleTest() {
	driver.findElement(By.linkText("My Account")).click();
	//wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	//Assert.assertEquals(driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText(), "My Account");
		//Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[1]/div[2]/div[2]/div[2]/div/div/div/div/div[1]/h1")).getText(), "My Account");
	String myAccountTitle = driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText();
    String expectedTitle = "My Account";
    Assert.assertEquals(myAccountTitle, expectedTitle);
    System.out.println("Title of the page the user is currently in is : "+myAccountTitle);
}

@AfterClass
public void teardown() {
	//close page
	driver.quit();
}
}
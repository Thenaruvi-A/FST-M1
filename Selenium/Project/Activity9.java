package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

	BaseClass obj =new BaseClass();
	WebDriver driver;
	WebDriverWait wait;
	

@BeforeClass
public void AccountLoginTest() {
	driver = obj.SetUp();
	driver.findElement(By.linkText("My Account")).click();
	Assert.assertEquals(driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText(), "My Account");
	driver.findElement(By.linkText("Login")).click();
	System.out.println("Page title" + driver.getTitle());
	driver.findElement(By.id("user_login")).sendKeys("root");
	driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");	
	driver.findElement(By.id("wp-submit")).click();
	driver.findElement(By.linkText("← Back to Alchemy LMS")).click();
	//#backtoblog > a:nth-child(1)
	
	
}

@Test(priority=1)
public void AllCoursesTitleTest() {
	driver.findElement(By.linkText("All Courses")).click();
	Assert.assertEquals(driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText(), "All Courses");
	
}

@Test(priority=2)
public void selectCourseTest() {
	
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[3]/article/div[2]/p[2]/a")).click();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 driver.findElement(By.cssSelector("div.ld-item-list-item:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2)")).click();
	WebElement courseTitle = driver.findElement(By.cssSelector(".ld-focus-content > h1:nth-child(1)"));
	String actualCourseTitle = courseTitle.getText();
    String expectedTitle = "Analyze Content & Develop Writing Strategies";
    Assert.assertEquals(actualCourseTitle, expectedTitle);
    System.out.println("Title of the course selected is : "+actualCourseTitle);
    try {
   WebElement completeButton = driver.findElement(By.cssSelector("input.learndash_mark_complete_button"));
    if (completeButton.isDisplayed()) {
    	completeButton.click();
        System.out.println("Course is marked complete");
    }    
    }catch (NoSuchElementException errormsg) {
    	System.out.println("Course is already completed , Button Not visible, closing the browser");
    }
   
    }
   
	

@AfterClass
public void teardown() {
	//close page
	driver.quit();
}
}


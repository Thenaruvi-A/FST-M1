package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {

	BaseClass obj =new BaseClass();
	WebDriver driver;
	
@BeforeClass
public void setup() {

	driver = obj.SetUp();
 
}

@Test(priority=1)
public void AllCoursesTitleTest() {
	driver.findElement(By.linkText("All Courses")).click();

	Assert.assertEquals(driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText(), "All Courses");
	
}

@Test(priority=2)
public void myCourseaListTest() {
	List<WebElement> CourseList = driver.findElements(By.className("entry-title"));
	System.out.println("Total courses found: " + CourseList.size());
	int count=1;
	for (WebElement course : CourseList) {
		//int count=1;
		//System.out.println("Course Name " + course.getText());
        System.out.println("Course Name " + count + ": " + course.getText());
        count++;
    }
}
	

@AfterClass
public void teardown() {
	//close page
	driver.quit();
}
}
package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity8 {
	BaseClass obj =new BaseClass();
	WebDriver driver;
	
@BeforeClass
public void setup() {

	driver = obj.SetUp();
 
}

@Test(priority=1)
public void AllCoursesTitleTest() {
	driver.findElement(By.linkText("Contact")).click();

	Assert.assertEquals(driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText(), "Need Help?");
	
}
@DataProvider(name = "FormData")
public static Object[][] contactForm() {
    return new Object[][] { 
        { "Test Name", "Test1@test.com", "Test Subject", "Test Message"}
    };
}

@Test(priority=2, dataProvider = "FormData")

public void loginTest(String username, String email, String Subject, String Message) {
    // Find  the user name , passwor & submit elements
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement usernameField = driver.findElement(By.id("wpforms-8-field_0"));
    WebElement emailField = driver.findElement(By.id("wpforms-8-field_1"));
    WebElement subjactField = driver.findElement(By.id("wpforms-8-field_3"));
    WebElement messageField = driver.findElement(By.id("wpforms-8-field_2"));
    WebElement sendMessage = driver.findElement(By.id("wpforms-submit-8"));

    // Enter the credentials
    usernameField.sendKeys(username);
    emailField.sendKeys(email);
    subjactField.sendKeys(Subject);
    messageField.sendKeys(Message);
    //Click submit
    sendMessage.click();

    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String confirmationMessage = driver.findElement(By.cssSelector("#wpforms-confirmation-8 p")).getText();
    Assert.assertEquals(confirmationMessage, "Thanks for contacting us! We will be in touch with you shortly.");
    System.out.println("Confirmation Text : "+confirmationMessage);

}
	

@AfterClass
public void teardown() {
	//close page
	driver.quit();
}
}
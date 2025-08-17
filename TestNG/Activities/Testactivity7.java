package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testactivity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize driver
        driver = new FirefoxDriver();
        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the page
        driver.get("https://training-support.net/webelements/login-form");
    }
    
    @Test(priority=1)
    public void pageTitleTest() {
    	assertEquals(driver.getTitle(), "Selenium: Login Form");
    }

    @DataProvider(name = "InvalidCreds")
    public static Object[][] creds() {
        return new Object[][] { 
            { "admin1", "invalidpassword"},
            { "wrongAdmin", "wrongPassword"},
            {"4210()&^?","Delet TABLE users;"}
        };
    }

    @Test(priority=2, dataProvider = "InvalidCreds")
    public void loginTest(String username, String password) {
        // Find  the user name , passwor & submit elements
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        // Clear the input fields
        usernameField.clear();
        passwordField.clear();
        // Enter the credentials 
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        //Click submit
        submitButton.click();

        // Assert login message
        //though explicit wait is used for visiblity of elements here in this page,
        //String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
        //here implicit will work as well as the error message does not go away
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String errorMessage = driver.findElement(By.id("subheading")).getText();
        Assert.assertEquals(errorMessage, "Invalid credentials");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

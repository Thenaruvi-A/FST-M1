package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;
    BaseClass obj =new BaseClass();

    @BeforeTest
    public void setup() {

    	driver = obj.SetUp();    // a & b. Open browser and navigate to the site
    }

    @Test
    public void testReadFirstInfoBoxTitle() {
   
        // c. Locate the first info box title
        WebElement firstInfoBoxTitle = driver.findElement(By.xpath("(//h3[@class='uagb-ifb-title'])"));
      
        // d. Get the text and verify it matches "Actionable Training"
        String actualTitle = firstInfoBoxTitle.getText();
        String expectedTitle = "Actionable Training";
        System.out.println("Title of the first info box: "+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Info box title does not match!");
    }
    
    
    @AfterTest
    public void closeBrowser() {
    	// e. Close the browser
        driver.quit();
    }


}
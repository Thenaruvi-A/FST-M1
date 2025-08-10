package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;                        // For using List<>
import org.openqa.selenium.WebElement; 
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;

public class Activity2 {

	public static void main(String[] args)  { 
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
		System.out.println("Page title" + driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		//driver.findElement(By.tagName("button")).click();
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		buttons.get(2).click();
		
        //String successMessage = driver.findElement(By.tagName("h1")).getText();
        //System.out.println("Confirmation: " + successMessage);
        System.out.println("Confirmation:" + driver.findElement(By.xpath("//h1[contains(text(),'Success!')]")).getText());
        driver.quit();
      
	}

}



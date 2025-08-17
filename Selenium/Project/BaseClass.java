package project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	WebDriverWait wait;

	    public WebDriver SetUp() {
	    	//initlizr driver and wait common for all activities
	    	//webdriver can be itslf a retrn typ - else throwing null pointer exception
	        WebDriver driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://alchemy.hguy.co/lms");  
	        return driver;
	    }
	    
	    
	}



package activities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity16 {
public static void main(String[] args) {
	
	 //Create a new Instance of Firefox driver
	WebDriver driver = new FirefoxDriver();
	
	 // Open the page
    driver.get("https://training-support.net/webelements/selects");

    // Print the title of the page
    System.out.println("Page title is: " + driver.getTitle());

    // Find the dropdown and create a Select object
    Select dropdown = new Select(driver.findElement(By.cssSelector("select.h-10")));

    // Select the second option using the visible text
    dropdown.selectByVisibleText("One");
    System.out.println(dropdown.getFirstSelectedOption().getText());

    // Select the third option using the index
    dropdown.selectByIndex(2);
    System.out.println(dropdown.getFirstSelectedOption().getText());

    // Select the fourth option using the value
    dropdown.selectByValue("three");
    System.out.println(dropdown.getFirstSelectedOption().getText());

    // Get all the options and print them to the console
    System.out.println("All the options:");
    for (WebElement option : dropdown.getOptions()) {
        System.out.println(option.getText());
    }

    // Close the browser
    driver.quit();
}
}
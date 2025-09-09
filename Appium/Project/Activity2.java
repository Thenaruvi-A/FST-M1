package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		//options.setApp(new File(getClass().getClassLoader().getResource("ts-todo-list-v1.apk").toURI()).getAbsolutePath());
		options.setApp("C:/Users/AsaAThenaruvi/eclipse-workspace/New-workspace3/fst_appium/src/test/resources/ts-todo-list-v1.apk");
		options.setAppPackage("com.app.todolist");
		options.setAppActivity("tutorial.TutorialActivity");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void longPress() {
	List<WebElement> tasks = driver.findElements(AppiumBy.id("tv_exlv_task_name"));
	if (!tasks.isEmpty()) {
	    WebElement pressFirstTask = tasks.get(0);
	    Point location = pressFirstTask.getLocation();
        //Element located , then provide the code to find the coordinates
        int width = pressFirstTask.getSize().getWidth();
        int height = pressFirstTask.getSize().getHeight();
        Point center = new Point(location.getX() + width / 2, location.getY() + height / 2);

        // Now call your custom long press method
        ActionsBase.doLongPress(driver, center);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Edit To-Do Task']")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")));
        driver.findElement(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline")).click();
        driver.findElement(AppiumBy.accessibilityId("20 September 2025")).click();
        driver.findElement(AppiumBy.id("com.app.todolist:id/bt_deadline_ok")).click();
        driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
        String deadlineText = driver.findElements(AppiumBy.id("com.app.todolist:id/tv_exlv_task_deadline")).get(0).getText();
        Assert.assertTrue(deadlineText.contains("20.09.2025"), "Deadline not updated. Found: " + deadlineText);  
        
	} else {
	    System.out.println("No tasks found!");
	}
	}
		@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}



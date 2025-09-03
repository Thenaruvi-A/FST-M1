package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

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

	@DataProvider(name = "createTasks")
    public static Object[][] tasks() {
        return new Object[][] { 
            { "Activity1_HP", "High"},
            { "Activity2_MP", "Medium"},
            {"Activity3_LP", "Low"}
        };
    }
	
	
	@Test(priority=1, dataProvider = "createTasks")
	public void createTask(String Name, String priority) {
		// +icon
		driver.findElement(AppiumBy.id("com.app.todolist:id/fab_new_task")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("et_new_task_name")));
		driver.findElement(AppiumBy.id("et_new_task_name")).sendKeys(Name);
		//System.out.println("Trying to select priority: " + priority);
		driver.findElement(AppiumBy.id("tv_new_task_priority")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='" + priority + "']")));
		//System.out.println("Wait Trying to select priority: " + priority);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + priority + "']")).click();
		driver.findElement(AppiumBy.id("bt_new_task_ok")).click();
		//android.widget.TextView[@resource-id="android:id/title" and @text="High"]
		
	// Assertion of number of tasks added - try with data provider
	if (Name.equals("Activity3_LP")) {
	int taskCount = tasks().length;
	List<WebElement> tasks = driver.findElements(AppiumBy.id("tv_exlv_task_name"));
	Assert.assertEquals(tasks.size(), taskCount);
	}
	}
}

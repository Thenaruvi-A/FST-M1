package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
		//options.setApp("./src/test/resources/Calculator.apk");
		options.setApp(new File(getClass().getClassLoader().getResource("Calculator.apk").toURI()).getAbsolutePath());
		//options.setApp("C:/Users/AsaAThenaruvi/eclipse-workspace/New-workspace3/fst_appium/src/test/resources/Calculator.apk");
		/*
		 * File apkFile = new File("src/test/resources/Calculator.apk");
		 * 
		 * if (!apkFile.exists()) { System.out.println("❌ APK not found at: " +
		 * apkFile.getAbsolutePath()); } else { System.out.println("✅ APK found at: " +
		 * apkFile.getAbsolutePath()); }
		 */
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
	}

	// Test method
	@Test
	public void multiplyTest() {
		// Find and tap the number 5
		driver.findElement(AppiumBy.id("digit_5")).click();

		// Find and tap the multiply button
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();

		// Find and tap the number 6
		driver.findElement(AppiumBy.id("digit_6")).click();

		// Find and tap the equals button
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		// Get the result and assert the value
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		assertEquals(result, "30");
	}

	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}

}

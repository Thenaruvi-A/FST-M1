package project;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {
    private final static PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    private final static PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "pointer");
    
    /*public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        Sequence swipe = new Sequence(finger, 1)
            .addAction(finger.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
            .addAction(finger.createPointerDown(LEFT.asArg()))
            .addAction(finger.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
            .addAction(finger.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }*/
    
    public static void progressBar(AppiumDriver driver, WebElement seekBar, double percentage, int duration) {
        // Get SeekBar dimensions and position
        int startX = seekBar.getLocation().getX();
        int startY = seekBar.getLocation().getY();
        int width = seekBar.getSize().getWidth();
        int height = seekBar.getSize().getHeight();

        // Calculate center Y and target X based on percentage
        int centerY = startY + height / 2;
        int targetX = startX + (int)(width * percentage);

        Point start = new Point(startX, centerY);
        Point end = new Point(targetX, centerY);

        // Create W3C Action to swipe
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
            .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.getY()))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), end.getX(), end.getY()))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
  /* public static void Sequence drag = new Sequence(finger, 1)
            // Move finger to start of SeekBar
            .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            // Drag to target position smoothly
            .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), targetX, y))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    */
 // Create the long press action function
    public static void doLongPress(AppiumDriver driver, Point start) {
        // Create s sequence of actions
        Sequence longPress = new Sequence(pointer, 1)
                .addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(pointer.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(pointer, Duration.ofMillis(2000)))
                .addAction(pointer.createPointerUp(LEFT.asArg()));

        // Perform the actions
        driver.perform(Arrays.asList(longPress));
    }

    // Create the long press action function
    public static void doTap(AppiumDriver driver, Point start) {
        // Create s sequence of actions
        Sequence longPress = new Sequence(pointer, 1)
                .addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(pointer.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(pointer, Duration.ofMillis(80)))
                .addAction(pointer.createPointerUp(LEFT.asArg()));

        // Perform the actions
        driver.perform(Arrays.asList(longPress));
    }
}


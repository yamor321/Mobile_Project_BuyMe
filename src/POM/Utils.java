package POM;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Utils {

    public static void swipe(AndroidDriver driver, int fromx, int fromy, int tox, int toy, int duration){
        TouchAction action = new TouchAction(driver);
        Duration swipeDuration = Duration.ofMillis(duration);
        LongPressOptions longPressOptions = new LongPressOptions();
        PointOption fromPointOption = new PointOption();
        fromPointOption.withCoordinates(fromx, fromy);
        PointOption toPointOption = new PointOption();
        toPointOption.withCoordinates(tox, toy);
        longPressOptions.withDuration(swipeDuration).withPosition(fromPointOption).build();
        action.longPress(longPressOptions).moveTo(toPointOption).release().perform();
    }
}

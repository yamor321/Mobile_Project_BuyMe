package POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.List;

public class Howtosendscreen {

    private static MobileElement element = null;
    private AndroidDriver<MobileElement> driver;

    public static void box1after(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/nowRadioButton")).click();
    }


    public static void boxchooseemail(AndroidDriver driver){

        List<MobileElement> checkbox1 = driver.findElements(By.id("il.co.mintapp.buyme:id/optionCheckBox"));
        checkbox1.get(2).click();
    }

    public static void swipe(AndroidDriver driver){

        TouchAction action = new TouchAction(driver);
        Duration swipeduration = Duration.ofMillis(75);
        LongPressOptions longPressOptions = new LongPressOptions();
        List<MobileElement> elements = driver.findElements(By.id("il.co.mintapp.buyme:id/optionCheckBox"));
        MobileElement fromelement  = elements.get(2);
        ElementOption elementOption = new ElementOption();
        elementOption.withElement(fromelement);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(1380,1000);
        longPressOptions.withDuration(swipeduration).withElement(elementOption).build();
        action.longPress(longPressOptions).moveTo(pointOption).release().perform();
    }



    public static void writeemail(AndroidDriver driver){

        List<MobileElement> writemail = driver.findElements(By.id("il.co.mintapp.buyme:id/description"));
        writemail.get(1).sendKeys("Yamor321@gmail.com");
        driver.hideKeyboard();
    }


    public static void submit(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/goNextButton")).click();
    }




//    TouchActions action = new TouchActions(driver);
//    action.scroll(element, 10, 100);
//    action.perform();

//    Swipe

//    Duration swipeduration = Duration.ofMillis(50);
//    LongPressOptions longPressOptions = new LongPressOptions();
//    List<MobileElement> elements = driver.findElements(By.id("il.co.mintapp.buyme:id/optionCheckBox"));
//    MobileElement fromelement  = elements.get(2);
//    ElementOption elementOption = new ElementOption();
//    elementOption.withElement(fromelement);
//    PointOption pointOption = new PointOption();
//    pointOption.withCoordinates(100,1000);
//    longPressOptions.withDuration(swipeduration).withElement(elementOption).build();
//    action.longPress(longPressOptions).moveTo(pointOption).release().perform();


//    TouchAction action = new TouchAction(driver);
//    Duration swipeDuration = Duration.ofMillis(100);
//    LongPressOptions longPressOptions = new LongPressOptions();
//    PointOption fromPointOption = new PointOption();
//    fromPointOption.withCoordinates(10, 280);
//    PointOption toPointOption = new PointOption();
//    toPointOption.withCoordinates(800, 280);
//    longPressOptions.withDuration(swipeDuration).withPosition(fromPointOption).build();
//    action.longPress(longPressOptions).moveTo(toPointOption).release().perform();






    public Howtosendscreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

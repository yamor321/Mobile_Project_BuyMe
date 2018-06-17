package POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class Enterandhomescreen {

    private static MobileElement element = null;
    private final AndroidDriver<MobileElement> driver;


    public static void pressgoogletoreg(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/googleButton")).click();
    }

    public static void pickacatagory(AndroidDriver driver){

        List<MobileElement> giftsList = driver.findElements(By.id("il.co.mintapp.buyme:id/t_title"));
        giftsList.get(3).click();
    }


    public static void pickgiftfromlist(AndroidDriver driver){

        List<MobileElement> giftsList = driver.findElements(By.id("il.co.mintapp.buyme:id/businessName"));
        giftsList.get(1).click();
    }


    public static void sendamountofmoney (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/priceEditText")).sendKeys("600");
    }


    public static void submittobuy (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/purchaseButton")).click();
    }

//    EXTRAS

    public static void infoclick (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/profileTab")).click();
    }


    public static void onbuymeclick(AndroidDriver driver){

        List<MobileElement> att = driver.findElements(By.id("il.co.mintapp.buyme:id/title"));
        att.get(2).click();
    }

    public static void printalltextonscreen (AndroidDriver driver){
        String a = driver.findElement(By.id("il.co.mintapp.buyme:id/titleText")).getText();
        String b = driver.findElement(By.id("il.co.mintapp.buyme:id/contentText")).getText();
        System.out.println(a+"\n\n"+b);
    }


    public static void search (AndroidDriver driver) {
        driver.findElement(By.id("il.co.mintapp.buyme:id/search")).click();
        driver.findElement(By.id("android:id/text1")).click();
    }

    public static void searchyakar(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/edit_text_search")).sendKeys("חבילת 24");
    }

    public static void choose (AndroidDriver driver) {
        driver.findElement(By.id("android:id/text1")).click();
    }

    public static void pickacatagoryex(AndroidDriver driver){

        List<MobileElement> giftsList = driver.findElements(By.id("il.co.mintapp.buyme:id/t_title"));
        giftsList.get(2).click();
    }

    public static void pickgiftfromlistex(AndroidDriver driver){

        List<MobileElement> giftsList = driver.findElements(By.id("il.co.mintapp.buyme:id/businessName"));
        giftsList.get(1).click();
    }


    public static void pickexgiftfromlistex(AndroidDriver driver){

        List<MobileElement> giftsList = driver.findElements(By.id("il.co.mintapp.buyme:id/purchaseButton"));
        giftsList.get(1).click();
    }


    public Enterandhomescreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
}


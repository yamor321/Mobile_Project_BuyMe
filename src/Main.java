import POM.Enterandhomescreen;
import POM.Howtosendscreen;
import POM.Sendscreen;
import POM.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static com.google.gson.internal.bind.TypeAdapters.URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Main {

    private static AndroidDriver<MobileElement> driver;
    public TestName name = new TestName();
    private static ExtentReports extent ;
    private static ExtentTest test ;

    @BeforeClass
    public static void setUp() throws IOException, ParserConfigurationException, SAXException {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter
                ("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Mobile Automation BuyMe\\reports\\report.html");
        htmlReporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Yarden Morshtein Mobile Automation Project", "Automating “BuyMe” App");
        extent.setSystemInfo("Project goal", "'BuyMe' App Sanity Test");
        extent.setSystemInfo("Tester", "Yarden");
        extent.setSystemInfo("App address", "https://play.google.com/store/apps/details?id=il.co.mintapp.buyme");
        extent.setSystemInfo("Third-Party usage", "Selenium web-driver, JUnit, Appium, Extent Report.");

        test.log(Status.INFO, "@Before class");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(getData("PACKA"), getData("PACKB"));
        capabilities.setCapability(getData("ACTA"), getData("ACTB"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void Aopenandregwithgoogle() throws InterruptedException {
//        This method chooses google to register the application - before preforming this test you'll need to log out app.
        boolean enterandhomescreenok = false;
        try {
            WebDriverWait expwait = new WebDriverWait(driver, 3);
            expwait.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/googleButton")));
            test.pass("Register Screen", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Mobile Automation BuyMe\\screenshots\\"
                            + "Register Screen")).build());
            Enterandhomescreen.pressgoogletoreg(driver);
            enterandhomescreenok = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Register" + e.getMessage());
            enterandhomescreenok = false;
        }finally {
            if (enterandhomescreenok){
                test.log(Status.PASS,"App Register Successfully");
            }
        }
    }
    @Test
    public void Bpickagiftattributes() throws InterruptedException, IOException {
//        This method picks the gift attributes and proceed to sendscreen

        boolean pickatt = false;
        try {

            WebDriverWait expwait1 = new WebDriverWait(driver, 3);
            expwait1.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/t_title")));

            test.pass("Home Screen", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Mobile Automation BuyMe\\screenshots\\"
                            + "Home Screen")).build());
        Enterandhomescreen.pickacatagory(driver);

            WebDriverWait expwait2 = new WebDriverWait(driver, 3);
            expwait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("il.co.mintapp.buyme:id/businessName")));

        Enterandhomescreen.pickgiftfromlist(driver);

            test.pass("Picking Screen", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Mobile Automation BuyMe\\screenshots\\"
                            + "Picking Screen")).build());

            WebDriverWait expwait3 = new WebDriverWait(driver, 3);
            expwait3.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/priceEditText")));
        Enterandhomescreen.sendamountofmoney(driver);
        Enterandhomescreen.submittobuy(driver);


            pickatt = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Pick Gift Attributes and gift from List" + e.getMessage());
            pickatt = false;
        }finally {
            if (pickatt){
                test.log(Status.PASS,"App Succeeded Picking Gift Attributes and gift from List");
            }
        }
    }

    @Test
    public void Cfillsendscreen() throws IOException {
//        This method fill send screen form and proceed to how to send screen
        boolean fillsend = false;
        try {
        Sendscreen.towhomthegift(driver);
            test.pass("Send Screen Form", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Mobile Automation BuyMe\\screenshots\\"
                            + "Send Screen Form")).build());
        Sendscreen.watkindofevent(driver);
        Sendscreen.pickabless(driver);
        Sendscreen.blessEditText(driver);
        Sendscreen.scrolldown(driver);
        Sendscreen.whosendthegift(driver);
        Sendscreen.submit(driver);

            fillsend = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Fill Sendscreen form" + e.getMessage());
            fillsend = false;
        }finally {
            if (fillsend){
                test.log(Status.PASS,"App Succeed Filling Sendscreen form");
            }
        }
    }

    @Test
    public void Dfillhowtosend(){
        //        This method fill how to send screen form and submit to payment

        boolean fillhowtosend = false;
        try {

        Howtosendscreen.box1after(driver);
            test.pass("How to Send Screen Form", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Mobile Automation BuyMe\\screenshots\\"
                            + "How to Send Screen Form")).build());
        Howtosendscreen.boxchooseemail(driver);
        Howtosendscreen.swipe(driver);

            WebDriverWait expwait4 = new WebDriverWait(driver, 3);
            expwait4.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/goNextButton")));
        Howtosendscreen.writeemail(driver);
        Howtosendscreen.submit(driver);

            fillhowtosend = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL,"App Could not Fill How to Send form and Submit" + e.getMessage());
            fillhowtosend = false;
        }finally {
            if (fillhowtosend){
                test.log(Status.PASS,"App Succeed Filling How to Send form and Submit");
            }
        }
    }




//    EXTRAS

//    @Test
    public void printinfoonbuyme() throws InterruptedException {
//        This Method click on "my zone" then on "on buyme" and prints all the info on the screen

        WebDriverWait expwait1 = new WebDriverWait(driver, 3);
        expwait1.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/t_title")));
        Enterandhomescreen.infoclick(driver);
        Enterandhomescreen.onbuymeclick(driver);
        Enterandhomescreen.printalltextonscreen(driver);
    }

//    @Test
    public void swipetochoosecategory() throws InterruptedException {
//        This Method swipe on main screen to choose category

        WebDriverWait expwait1 = new WebDriverWait(driver, 3);
        expwait1.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/t_title")));
        Utils.swipe(driver,10,1800,1400,1800,30);
    }

//    @Test
    public void choosemostexpensive() throws InterruptedException {
//        This Method chooses the most exspensive gift to be found at category

        WebDriverWait expwait1 = new WebDriverWait(driver, 3);
        expwait1.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/t_title")));
        Enterandhomescreen.pickacatagoryex(driver);
        WebDriverWait expwait2 = new WebDriverWait(driver, 3);
        expwait2.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/businessName")));
        Enterandhomescreen.pickgiftfromlistex(driver);
        WebDriverWait expwait3 = new WebDriverWait(driver, 3);
        expwait3.until(ExpectedConditions.elementToBeClickable(By.id("il.co.mintapp.buyme:id/priceEditText")));
        Utils.swipe(driver,682,2377,682,100,100);
        Utils.swipe(driver,622,2377,622,500,100);
        Enterandhomescreen.pickexgiftfromlistex(driver);

    }

    @AfterClass
    public static void after() {
        driver.quit();
        extent.flush();

    }



    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }


    private static String getData(String keyName) throws
            ParserConfigurationException, IOException, SAXException {
        File XML1 = new File("C:\\Users\\Yarden`s NUC\\Desktop\\Yarden\\Automation\\Mobile Automation BuyMe\\XML1.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        assert dBuilder != null;
        doc = dBuilder.parse(XML1);
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();

    }

}
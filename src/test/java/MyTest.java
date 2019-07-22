import com.saucelabs.rdc.RdcCapabilities;
import com.saucelabs.rdc.RdcTestResultWatcher;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class MyTest {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private By ByReff;
    private MobileElement reff;
    private long TIME_OUT = 10; //in seconds
    DesiredCapabilities capabilities;

    //saucelabs
    @Rule
    public final RdcTestResultWatcher watcher = new RdcTestResultWatcher();
    //end saucelabs


    @Before
    public void setUp() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        //local
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "9");
//        capabilities.setCapability("deviceName", "Android SDK built for x86");
//        capabilities.setCapability("noReset", "false");
//        capabilities.setCapability("fullReset", "true");
//        capabilities.setCapability("app", "C:\\Users\\Admin\\Desktop\\aws\\app-debug.apk");
//
//        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //end local

        //saucelabs
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("testobject_app_id", "1");
        System.out.println("API_KEY: " + System.getenv().get("SAUCE_TEST_OBJECT"));
        capabilities.setCapability("testobject_api_key", System.getenv().get("SAUCE_TEST_OBJECT"));
        capabilities.setCapability("testobject_suite_name", "aws suit2");
        capabilities.setCapability("testobject_test_name", "aws test2");

        driver = new AndroidDriver<MobileElement>(new URL("https://eu1.appium.testobject.com/wd/hub"), capabilities);
        watcher.setRemoteWebDriver(driver);
        //end sauce labs

        wait = new WebDriverWait(driver, TIME_OUT);
        ByReff = new By.ByXPath(
                "//android.widget.ImageButton[@content-desc=\"ReferenceApp\"]"
        );
        reff = (MobileElement) driver.findElement(ByReff);

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void webTest() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();

        MobileElement web = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[2]"
        );
        web.click();
        //Assert.assertEquals(web.getText(), "WEB");

        MobileElement urlBar = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.EditText\n"
        );
        urlBar.sendKeys(
                "http://www.google.com/\\n"
        );
        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[1]/android.widget.Image")));
//        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ById("hplogo")));
//        Thread.sleep(2000);
    }

    @Test
    public void nativeTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();
        MobileElement nativeComps = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[3]"
        );
        nativeComps.click();

        MobileElement scroll = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[2]"
        );
        scroll.click();

//        MobileElement es2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[1]");
//
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(ElementOption.element(es1)).moveTo(PointOption.point(es2.getLocation().x-200, es2.getLocation().y)).release().perform();

        MobileElement video = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        video.click();

        MobileElement camera = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        camera.click();

        MobileElement outView = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        outView.click();
    }

    @Test
    public void inputTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();
        MobileElement input = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[4]"
        );
        input.click();

        MobileElement inputText = findObject(
                "//android.widget.EditText[@content-desc=\"Text Input Control\"]"
        );
        inputText.sendKeys("Test");

        MobileElement checkboxTab = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[2]"
        );
        checkboxTab.click();

        MobileElement checkbox = findObject(
                "//android.widget.CheckBox[@content-desc=\"Checkbox Control\"]"
        );
        checkbox.click();

        MobileElement radioTab = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        radioTab.click();
        //android.widget.RadioButton[@content-desc="Radio Button 1"]
        //android.widget.RadioButton[@content-desc="Radio Button 2"]
        //android.widget.RadioButton[@content-desc="Radio Button 3"]
        MobileElement radio2 = findObject(
                "//android.widget.RadioButton[@content-desc=\"Radio Button 1\"]"
        );
        radio2.click();
        MobileElement radio3 = (MobileElement) driver.findElementByAccessibilityId("Radio Button 3");
        radio3.click();

        MobileElement toggleTab = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        toggleTab.click();

        MobileElement toggle = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.Switch"
        );
        toggle.click();

        MobileElement spinnerTab = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        spinnerTab.click();

        MobileElement spinner = findObject(
                "//android.widget.Spinner[@content-desc=\"Spinner Control\"]"
        );
        spinner.click();
        MobileElement option5 = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]"
        );
        option5.click();

        MobileElement pullRefresh = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        pullRefresh.click();

        MobileElement timePickerTab = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        timePickerTab.click();

        MobileElement num6 = findObject(
                "//android.widget.TimePicker[@content-desc=\"Timepicker Control\"]/android.widget.LinearLayout/android.view.View"
        );
        num6.click();
        MobileElement num45 = (MobileElement) driver.findElementByAccessibilityId("45");
        num45.click();


        MobileElement datePicker = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        datePicker.click();


        By ByDatePicker = new By.ByXPath(
                "//android.widget.DatePicker[@content-desc=\"Datepicker Control\"]"
        );
        wait.until(ExpectedConditions.presenceOfElementLocated(ByDatePicker));
        //android.view.View[@content-desc="07 July 1994"]
        MobileElement day7 = (MobileElement) driver.findElementByAccessibilityId("07 July 1994");
        day7.click();

        MobileElement submiTab = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        submiTab.click();

        MobileElement submit = findObject(
                "//android.widget.Button[@content-desc=\"Submit Button\"]"
        );
        submit.click();

        MobileElement gestures = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[3]"
        );
        gestures.click();

        MobileElement press = findObject(
                "//android.widget.FrameLayout[@content-desc=\"Gesture Action Pad\"]/android.widget.TextView"
        );
        press.click();
    }

    @Test
    public void nestedTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();

        MobileElement nested = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[5]"
        );
        nested.click();

        MobileElement up = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[1]"
        );
        up.click();

        MobileElement next = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button"
        );
        next.click();

        MobileElement back = findObject(
                "//android.widget.ImageButton[@content-desc=\"Navigate up\"]"
        );
        back.click();

        MobileElement back2 = findObject(
                "//android.widget.ImageButton[@content-desc=\"Navigate up\"]"
        );
        back2.click();
    }

    @Test
    public void alertsTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();

        MobileElement alerts = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[7]"
        );
        alerts.click();

        MobileElement toast = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button[1]"
        );
        toast.click();
        MobileElement alert2 = (MobileElement) driver.findElementById("com.amazonaws.devicefarm.android.referenceapp:id/notifications_alert_button");
        alert2.click();

        MobileElement ok = findObject(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button"
        );
        ok.click();
    }

    @Test
    public void loginTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();

        MobileElement login = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[8]"
        );
        login.click();

        MobileElement username = findObject(
                "//android.widget.EditText[@content-desc=\"Username Input Field\"]"
        );
        username.sendKeys("Test");
        //android.widget.EditText[@content-desc="Password Input Field"]
        MobileElement password = (MobileElement) driver.findElementByAccessibilityId("Password Input Field");
        password.sendKeys("Test");
        //android.widget.Button[@content-desc="Login Button"]
        MobileElement loginBtn = (MobileElement) driver.findElementByAccessibilityId("Login Button");
        loginBtn.click();
    }

    @Test
    public void webViewTest() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();

        MobileElement webView = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[9]"
        );
        webView.click();

        Thread.sleep(2000);
    }

    @Test
    public void fixturesTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();

        MobileElement fixtures = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[10]"
        );
        fixtures.click();
    }

    @Test
    public void crashTest() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ByReff));
        reff.click();


//crashing the app----------------

        MobileElement crashTab = findObject(
                "(//android.widget.TextView[@content-desc=\"Row Category Name\"])[6]"
        );
        crashTab.click();

        MobileElement crash = findObject(
                "//android.widget.Button[@content-desc=\"Crash Button\"]"
        );
        crash.click();
    }

    private MobileElement findObject(String xPath){
        By by = new By.ByXPath(xPath);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return (MobileElement) driver.findElement(by);
    }
}
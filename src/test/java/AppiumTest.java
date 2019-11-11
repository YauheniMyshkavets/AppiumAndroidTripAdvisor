import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3 XL");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.tripadvisor.tripadvisor");
        caps.setCapability("appActivity","com.tripadvisor.tripadvisor.TripAdvisorTripAdvisorActivity");
        caps.setCapability("noReset","false");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url,caps);
        wait = new WebDriverWait(driver, 10);
    }

//    @AfterMethod
//    public void finish () {
//        driver.quit();
//    }


    @Test
    public void firstMobileTestTest () {

        //tab to get started button
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.tripadvisor.tripadvisor:id/generic_onboarding_cta")))).click();

        //tap to close button
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.tripadvisor.tripadvisor:id/login_skip")))).click();

        //tap to not now button
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.tripadvisor.tripadvisor:id/no_thanks")))).click();

        (new TouchAction(driver))
                .press(PointOption.point(1371, 1315))
                .moveTo(PointOption.point(110, 1321))
                .release()
                .perform();

    }


}

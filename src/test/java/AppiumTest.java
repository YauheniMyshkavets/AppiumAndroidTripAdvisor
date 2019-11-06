import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    DesiredCapabilities caps = new DesiredCapabilities();


    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3 XL API 29");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.tripadvisor.tripadvisor");
        caps.setCapability("appActivity","com.tripadvisor.tripadvisor.TripAdvisoTripAdvisorActivity");
        caps.setCapability("noReset","false");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url,caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstMobileTestTest () {

        MobileElement mainPage = driver.findElement(By.id("com.tripadvisor.tripadvisor:id/splash_screen"));
        mainPage.click();



    }

    @AfterMethod
    public void finish () {
        driver.quit();
    }
}

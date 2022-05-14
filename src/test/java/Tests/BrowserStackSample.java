package Tests;
import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackSample {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "mohanalatha_O61DNU");
        caps.setCapability("browserstack.key", "QxazxCBMtxzVV8Tu26ZZ");

        // Set URL of the application under test
        caps.setCapability("app", "bs://b479b53bdf7e83f0968be8fa1c6c098af2331772");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S8 Plus");
        caps.setCapability("os_version", "7.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "APIDemo_test");
//        caps.setCapability("ensureWebviewsHavePages", true);
//        caps.setCapability("nativeWebScreenshot", true);
//        caps.setCapability("newCommandTimeout", 3600);
//        caps.setCapability("appium:connectHardwareKeyboard", true);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        AndroidElement viewElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AccessibilityId("Views")));
        viewElement.click();
//        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//                ExpectedConditions.elementToBeClickable(
//                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
//        insertTextElement.sendKeys("BrowserStack");
//        Thread.sleep(5000);
//        List<AndroidElement> allProductsName = driver.findElementsByClassName(
//                "android.widget.TextView");
//        assert (allProductsName.size() > 0);


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }

    public void defaultApp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "mohanalatha_O61DNU");
        caps.setCapability("browserstack.key", "QxazxCBMtxzVV8Tu26ZZ");

        // Set URL of the application under test
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName(
                "android.widget.TextView");
        assert (allProductsName.size() > 0);


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}

//Enter this in command line prompt
//curl -u "mohanalatha_O61DNU:QxazxCBMtxzVV8Tu26ZZ" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@/C:/Selenium/MobileTesting/ApiDemos-debug.apk"
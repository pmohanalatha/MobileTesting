package Tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    public AndroidDriver<MobileElement> driver;

    @BeforeSuite
    public void setupDriver()throws MalformedURLException {
//    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//    URL url = new URL("http://127.0.0.1:4723/wd/hub");

        //Mobile Emulator capabilities
      /*  desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "10");
        desiredCapabilities.setCapability("appium:deviceName","Android SDK built for x86");
        desiredCapabilities.setCapability( "appium:appPackage","io.appium.android.apis");
        desiredCapabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

       */

        //Mobile Device
      /*  desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
        desiredCapabilities.setCapability("appium:deviceName","Moto G5 Plus");
        desiredCapabilities.setCapability("appium:app","C:\\Selenium\\MobileTesting\\ApiDemos-debug.apk");
        driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);

       */
    }
}

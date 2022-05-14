package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utils.DataKeyConstants;
import utils.ExtentTestNGListener;
import utils.PropertyReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners(ExtentTestNGListener.class)
public class BaseClass {

    public AndroidDriver<MobileElement> driver;

    @BeforeMethod(alwaysRun = true, enabled = true)
    public void setupDriver()throws MalformedURLException {
        PropertyReader propertyReader = new PropertyReader();
        String capType = propertyReader.getPropertyValue("capabilityType");
        System.out.println("Cap "+capType);
        if(capType==null){
            capType = "emulator";
        }
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        switch(capType){
            case "emulator":
                desiredCapabilities.setCapability(DataKeyConstants.platform_name, propertyReader.getPropertyValue(DataKeyConstants.platform_name));
                desiredCapabilities.setCapability("platformVersion", propertyReader.getPropertyValue(DataKeyConstants.emulator_platform_version));
                desiredCapabilities.setCapability("deviceName",propertyReader.getPropertyValue(DataKeyConstants.emulator_device_name));
                desiredCapabilities.setCapability("appium:app",propertyReader.getPropertyValue(DataKeyConstants.app));
//                desiredCapabilities.setCapability(DataKeyConstants.app_activity,propertyReader.getPropertyValue(DataKeyConstants.app_activity));
//                desiredCapabilities.setCapability(DataKeyConstants.app_package,propertyReader.getPropertyValue(DataKeyConstants.app_package));
                driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
                break;
            case "real":
                desiredCapabilities.setCapability(DataKeyConstants.platform_name, propertyReader.getPropertyValue(DataKeyConstants.platform_name));
                desiredCapabilities.setCapability("platformVersion", propertyReader.getPropertyValue(DataKeyConstants.real_platform_version));
                desiredCapabilities.setCapability("deviceName",propertyReader.getPropertyValue(DataKeyConstants.real_device_name));
                desiredCapabilities.setCapability("appium:app",propertyReader.getPropertyValue(DataKeyConstants.app));
                desiredCapabilities.setCapability(DataKeyConstants.app_activity,propertyReader.getPropertyValue(DataKeyConstants.app_activity));
                desiredCapabilities.setCapability(DataKeyConstants.app_package,propertyReader.getPropertyValue(DataKeyConstants.app_package));
                driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
                break;
            case "browserstack":
                desiredCapabilities.setCapability(DataKeyConstants.platform_name, propertyReader.getPropertyValue(DataKeyConstants.platform_name));
                desiredCapabilities.setCapability("platformVersion", propertyReader.getPropertyValue(DataKeyConstants.browserstack_device_name));
                desiredCapabilities.setCapability("deviceName",propertyReader.getPropertyValue(DataKeyConstants.browserstack_platform_version));
                desiredCapabilities.setCapability("appium:app",propertyReader.getPropertyValue(DataKeyConstants.app));
                desiredCapabilities.setCapability(DataKeyConstants.app_activity,propertyReader.getPropertyValue(DataKeyConstants.app_activity));
                desiredCapabilities.setCapability(DataKeyConstants.app_package,propertyReader.getPropertyValue(DataKeyConstants.app_package));
                driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(DataKeyConstants.implicitwait, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true, enabled = true)
    public void closeDriver(){
        driver.quit();
    }



}

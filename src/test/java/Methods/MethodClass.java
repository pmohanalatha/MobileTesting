package Methods;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MethodClass {

    public void scrollviaCoordinates(int startX, int startY, int endX, int endY, AndroidDriver driver){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption()
                .withCoordinates(startX,startY)).moveTo(new PointOption()
                .withCoordinates(endX, endY)).release().perform();

    }

    public void dragAndDrop(MobileElement drag, MobileElement drop, AndroidDriver driver){
        new AndroidTouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(drag)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(ElementOption.element(drop))
                .release()
                .perform();
    }

    public void waitUntilElementPresent(AndroidDriver driver,AndroidElement element) {
        try{
            Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void elementClick(AndroidDriver driver, AndroidElement element){
        waitUntilElementPresent(driver, element);
        element.click();
    }

    public void elementSendKeys(AndroidDriver driver, AndroidElement element, String value){
        waitUntilElementPresent(driver, element);
        element.sendKeys(value);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}

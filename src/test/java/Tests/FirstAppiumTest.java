package Tests;

import Methods.MethodClass;
import Tests.Base;
import base.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.util.List;

public class FirstAppiumTest extends BaseClass {
    @Test
    public void firstTest() throws MalformedURLException, InterruptedException {
        MobileElement viewElement= driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']"));
        viewElement.click();
        Thread.sleep(5000);
    }

    @Test
    public void secondTest(){
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Text");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("LogTextBox");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Add");
        el3.click();
        String text = driver.findElement(By.id("io.appium.android.apis:id/text")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("This is a test", text);
    }

    @Test
    public void scrollTest()throws InterruptedException{
        MethodClass methodClass = new MethodClass();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
        el1.click();
        methodClass.scrollviaCoordinates(499, 2058, 499, 372, driver);
        methodClass.scrollviaCoordinates(499, 2058, 499, 372, driver);

//        touchAction.longPress(LongPressOptions.longPressOptions().withPosition(new PointOption()
//        .withCoordinates(408,1907))).moveTo(new PointOption().withCoordinates(467, 1907)).release().perform();
//        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("TextFields");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("io.appium.android.apis:id/edit");
        el3.sendKeys("Scroll test");
    }

    @Test
    public void checkBoxTest(){
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Views");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Controls");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("1. Light Theme");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Checkbox 1");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("RadioButton 1");
        el6.click();

    }

    @Test
    public void checkAlertTest() throws InterruptedException{
        driver.findElementByAccessibilityId("App").click();
        driver.findElementByAccessibilityId("Alert Dialogs").click();
        driver.findElementById("io.appium.android.apis:id/two_buttons").click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElementById("io.appium.android.apis:id/two_buttons2").click();
        alert.accept();
        driver.findElementById("io.appium.android.apis:id/two_buttons2ultra").click();
        alert.dismiss();
        Thread.sleep(3000);
    }

    @Test
    public void checkDragDropTest() throws InterruptedException{
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAccessibilityId("Drag and Drop").click();

        MobileElement dragElement = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        MobileElement dropElement = driver.findElementById("io.appium.android.apis:id/drag_dot_2");

        MethodClass methodClass = new MethodClass();
        methodClass.dragAndDrop(dragElement,dropElement,driver);
        SoftAssert softAssert = new SoftAssert();
        String message = driver.findElementById("io.appium.android.apis:id/drag_result_text").getText();
        softAssert.assertEquals("Dropped!", message);
    }

    @Test
    public void ratingBarTest() throws InterruptedException{

        MethodClass methodClass = new MethodClass();
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
        el1.click();
        methodClass.scrollviaCoordinates(499, 2058, 499, 372, driver);
        driver.findElementByAccessibilityId("Rating Bar").click();
        Thread.sleep(3000);

        WebElement threeRatingBar= driver.findElementById("io.appium.android.apis:id/ratingbar1");
        int startX = threeRatingBar.getLocation().getX();
        int endx = threeRatingBar.getSize().getWidth();
        System.out.println("X "+startX + " Y "+ endx);
        int tappingPoint = (int) (endx*0.5);
        int tapY = threeRatingBar.getLocation().getY();
        new TouchAction<>(driver).press(new PointOption<>().withCoordinates(tappingPoint, tapY)).perform();
    }

    @Test
    public void dropdownTest() throws InterruptedException{

        MethodClass methodClass = new MethodClass();
        methodClass.scrollviaCoordinates(473, 1488, 473, 888, driver);
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
        el1.click();
        methodClass.scrollviaCoordinates(464, 1637, 464, 464, driver);
        methodClass.scrollviaCoordinates(464, 1637, 464, 464, driver);
        methodClass.scrollviaCoordinates(464, 1637, 464, 464, driver);
        driver.findElementByAccessibilityId("Spinner").click();
        Thread.sleep(3000);

        driver.findElementById("io.appium.android.apis:id/spinner2").click();
        List<MobileElement> dropdown= driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView");
        for (MobileElement element: dropdown){
            System.out.println("Elements "+ element.getText());
            if(element.getText().equalsIgnoreCase("Earth")){
                element.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }


}

package Tests;

import Methods.MethodClass;
import base.BaseClass;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import pages.MainPage;

public class SmokeTests extends BaseClass {

    @Test
    public void firstTest() throws InterruptedException{
        MainPage mainPage = new MainPage(driver);
        MethodClass methodClass = new MethodClass();
//        methodClass.scrollviaCoordinates(511, 1346, 545, 752, driver);
//        mainPage.clickViewLink();
        mainPage.clickAppLink(driver);
        mainPage.clickAlarmLink();
    }

}

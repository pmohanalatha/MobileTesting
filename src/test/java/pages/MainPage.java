package pages;

import Methods.MethodClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {

    public MainPage(AndroidDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    MethodClass methodClass = new MethodClass();

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
    public AndroidElement viewLink;

    @AndroidFindBy(accessibility = "Alarm")
    public AndroidElement alarmLink;

    @AndroidFindBy(accessibility = "App")
    public AndroidElement appLink;

    public void clickViewLink(){
        viewLink.click();
    }

    public void clickAlarmLink(){
        alarmLink.click();
    }

    public void clickAppLink(AndroidDriver<MobileElement> driver){
//        methodClass.dragAndDrop(alarmLink,appLink,driver);
        appLink.click();
    }



}

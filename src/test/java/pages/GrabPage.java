package pages;

import Methods.MethodClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class GrabPage {

    public GrabPage(AndroidDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    MethodClass methodClass = new MethodClass();

    @AndroidFindBy(id = "com.grubhub.android:id/welcome_button")
    public AndroidElement welcome;

    @AndroidFindBy(id = "com.grubhub.android:id/address_bar")
    public AndroidElement addressbar;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='Search At Current Location Button']")
    public AndroidElement selectAddress;

    @AndroidFindBy(id= "com.grubhub.android:id/address_location_search_title")
    public AndroidElement yourLocation;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public AndroidElement allowPermission;

    @AndroidFindBy(id= "com.grubhub.android:id/text_input_start_icon")
    public AndroidElement searchFoodImgicon;

    @AndroidFindBy(id = "com.grubhub.android:id/search_query_input_fused")
    public AndroidElement searchInputFood;

    @AndroidFindBy(id = "com.grubhub.android:id/suppress_commingle_order_type_toggle_delivery")
    public List<AndroidElement> toggles;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Convenience']")
    public AndroidElement convenienceOption;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView")
    public AndroidElement cardView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='7-Eleven'][@resource-id='com.grubhub.android:id/restaurant_name']")
    public AndroidElement Eleven7Restaurant;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.grubhub.android:id/text_input_start_icon']")
    public AndroidElement searchImageInRestaurant;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.grubhub.android:id/search_query_input_fused']")
    public AndroidElement searchTextboxInRestaurant;

    @AndroidFindBy(id = "com.grubhub.android:id/autocomplete_restaurant_name")
    public AndroidElement searchResultAutoCompleteName;

    @AndroidFindBy(id = "com.grubhub.android:id/menu_item_image")
    public AndroidElement searchItemInRestaurant;

    @AndroidFindBy(id = "com.grubhub.android:id/add_button")
    public AndroidElement addBtn;

    @AndroidFindBy(id = "com.grubhub.android:id/order_button_label")
    public AndroidElement viewOrderBtn;

    @AndroidFindBy(id = "com.grubhub.android:id/order_button_bg")
    public AndroidElement proceedToCheckoutBtn;

    @AndroidFindBy(id = "com.grubhub.android:id/empty_cart_container")
    public AndroidElement emptyBag;

    @AndroidFindBy(id = "com.grubhub.android:id/cookbook_button_bar_primary_button")
    public AndroidElement okBtnRemoveItem;

    @AndroidFindBy(id= "com.grubhub.android:id/menu_item_price")
    public AndroidElement itemPrice;

    @AndroidFindBy(id= "com.grubhub.android:id/stepper_button_right")
    public AndroidElement increaseItem;

    public void clickWelcomeLink(AndroidDriver driver){
        methodClass.elementClick(driver, welcome);
    }

    public void selectLocation(AndroidDriver driver){
        methodClass.waitUntilElementPresent(driver, addressbar);
        methodClass.elementClick(driver,addressbar);
        methodClass.sleep(3000);
        methodClass.elementClick(driver,yourLocation);
        methodClass.elementClick(driver,allowPermission);
        methodClass.waitUntilElementPresent(driver, toggles.get(0));
        methodClass.sleep(2000);
    }

    public void searchFood(AndroidDriver driver, String food){
        methodClass.elementClick(driver,searchFoodImgicon);
        methodClass.elementSendKeys(driver,searchInputFood,food);
    }

    public void selectConvenienceFood(AndroidDriver driver){
        methodClass.waitUntilElementPresent(driver, cardView);
        methodClass.elementClick(driver, searchImageInRestaurant);
        methodClass.elementSendKeys(driver, searchTextboxInRestaurant, "7-Eleven");
        methodClass.sleep(3000);
        methodClass.elementClick(driver, searchResultAutoCompleteName);
        methodClass.waitUntilElementPresent(driver, searchItemInRestaurant);
    }

    public void searchItemInRestaurant(AndroidDriver driver){
        methodClass.elementClick(driver, searchItemInRestaurant);
        methodClass.waitUntilElementPresent(driver, addBtn);

    }

    public void addItem(AndroidDriver driver){
        methodClass.elementClick(driver, addBtn);
        methodClass.waitUntilElementPresent(driver, viewOrderBtn);
    }

    public void viewOrder(AndroidDriver driver){
        methodClass.elementClick(driver, viewOrderBtn);
        methodClass.waitUntilElementPresent(driver, proceedToCheckoutBtn);
    }

    public void proceedToCheckout(AndroidDriver driver){
        methodClass.elementClick(driver, proceedToCheckoutBtn);
        methodClass.sleep(5000);
    }

    public void setEmptyBag(AndroidDriver driver){
        methodClass.elementClick(driver, emptyBag);
        methodClass.waitUntilElementPresent(driver, okBtnRemoveItem);
        methodClass.elementClick(driver, okBtnRemoveItem);
        methodClass.sleep(5000);
    }

    public String getItemPrice(){
        return itemPrice.getText().trim();
    }

    public String getItemPriceInBag(){
        String text= addBtn.getText();
        String[] textData= text.split(":");
        return textData[1].trim();
    }

    public void clickPlus(AndroidDriver driver){
        methodClass.elementClick(driver, increaseItem);
    }






}

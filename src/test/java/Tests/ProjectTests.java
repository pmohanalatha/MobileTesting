package Tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GrabPage;

public class ProjectTests extends BaseClass {

    @Test(alwaysRun = true, enabled = true, priority = 0, groups = {"smoke", "regression"})
    public void addItemToShoppingBagProceedCheckout(){
        GrabPage grabPage = new GrabPage(driver);
        grabPage.clickWelcomeLink(driver);
        grabPage.selectLocation(driver);
        grabPage.selectConvenienceFood(driver);
        grabPage.searchItemInRestaurant(driver);
        grabPage.addItem(driver);
        grabPage.viewOrder(driver);
        grabPage.proceedToCheckout(driver);
    }

    @Test(alwaysRun = true, enabled = true, priority = 1, groups = {"regression"})
    public void addItemToShoppingBagEmptyBag(){
        GrabPage grabPage = new GrabPage(driver);
        grabPage.clickWelcomeLink(driver);
        grabPage.selectLocation(driver);
        grabPage.selectConvenienceFood(driver);
        grabPage.searchItemInRestaurant(driver);
        grabPage.addItem(driver);
        grabPage.viewOrder(driver);
        grabPage.setEmptyBag(driver);
    }

    @Test(alwaysRun = true, enabled = true, priority = 2, groups = {"regression"})
    public void addItemToShoppingBagIncreaseItemAndValidateAmount(){
        GrabPage grabPage = new GrabPage(driver);
        grabPage.clickWelcomeLink(driver);
        grabPage.selectLocation(driver);
        grabPage.selectConvenienceFood(driver);
        grabPage.searchItemInRestaurant(driver);
        Assert.assertEquals(grabPage.getItemPrice(), grabPage.getItemPriceInBag(), "Price is not matched");
        grabPage.clickPlus(driver);
        Assert.assertEquals(grabPage.getItemPrice(), grabPage.getItemPriceInBag(), "Price is not matched");
    }


}

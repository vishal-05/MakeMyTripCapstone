package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_card_text\" and @text=\"Home\"]")
    WebElement homeTab;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Hamburger\"]")
    WebElement hamburgerBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_title\" and contains(@text, \"Hi\")]")
    WebElement profileName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tvTitle\" and @text=\"My Account\"]")
    WebElement myAccBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"verItemTitle\" and @text=\"\u200DLogout\"]")
    WebElement logoutBtn;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"Log Out\"])[2]")
    WebElement confirmLogOut;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    WebElement doNotAllow;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tvTitle\" and @text=\"Flights\"]")
    WebElement flightsTab;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tvTitle\" and @text=\"Hotels\"]")
    WebElement hotelsTab;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tvTitle\" and @text=\"Trains/ Bus\"]")
    WebElement trainsAndBusesTab;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Book Bus Tickets\"]")
    WebElement busTab;

        @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tvTitle\" and @text=\"Airport Cabs\"]")
            WebElement cabsTab;

    public boolean isProfileNameDisplayed() {
        if (!isPresent(profileName)) {
            driver.navigate().back();
            System.out.println("clicked back");
        }
        pause(3000);
        hamburgerBtn.click();
        System.out.println("clicked menu");
        pause(3000);
        return isPresent(profileName);
    }

    public boolean verifyHomePageISDisplayed() {
        if(!isPresent(homeTab)){
            doNotAllow.click();
            System.out.println("clicked do not allow on home page");
        }
        driver.navigate().back();
        return homeTab.isDisplayed();
    }

    public void viewProfileData() {
        myAccBtn.click();
    }

    public void clickLogoutOption() {
        pause(3000);
        System.out.println("inside scroll");
        scrollPageForFlightPage();
        System.out.println("scrolled");
        logoutBtn.click();
        confirmLogOut.click();
        pause(3000);
    }

    public void clickOnFlights(){
        pause(5000);
        flightsTab.click();
    }

    public void clicksOnHotels(){
        hotelsTab.click();
    }

    public void clicksOnBuses(){
        trainsAndBusesTab.click();
        busTab.click();
    }

    public void clickOnAirportCabs(){
        cabsTab.click();
    }

}

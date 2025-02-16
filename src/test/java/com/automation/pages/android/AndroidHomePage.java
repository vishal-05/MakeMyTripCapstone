package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebBasePage;
import com.automation.pages.web.WebHomePage;
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

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tvTitle\" and @text=\"Flights\"]")
    WebElement flightsTab;

    public boolean isProfileNameDisplayed() {
        pause(3000);
        hamburgerBtn.click();
        pause(3000);
        return isPresent(profileName);

    }


    public boolean verifyHomePageISDisplayed() {
        return homeTab.isDisplayed();
    }

    public void viewProfileData() {
        myAccBtn.click();

    }

    public void clickLogoutOption() {
        System.out.println("inside scroll");
        scrollPage();

        logoutBtn.click();
        confirmLogOut.click();
        pause(3000);
    }

    public void clickOnFlights(){
        flightsTab.click();
    }
}

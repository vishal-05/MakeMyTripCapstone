package com.automation.pages.web;

import com.automation.pages.ui.HomePage;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//span[@data-testid='cstmModal-close']")
    WebElement closeBtn;

    @FindBy(xpath = "//p[@data-cy='loggedInUser']")
    WebElement profileData;

    @FindBy(xpath = "//button/span[contains(text(), 'Continue')]")
    WebElement continueBtn;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//button[@data-cy='login']")
    WebElement loginBtn;


    @FindBy(xpath = "//a[@class='mmtLogo makeFlex']")
    WebElement websiteLogo;

    @FindBy(xpath = "//span[@class='cstmModal__close']")
    WebElement offerBannerClose;

    @FindBy(xpath = "//p[contains(text(), 'My Profile')]")
    WebElement myProfileOption;

    @FindBy(xpath = "//li[contains(text(), 'Logout')]")
    WebElement logoutOption;

    @FindBy(xpath = "//li[@data-cy='menu_Flights']")
    WebElement flightsTab;

    @FindBy(xpath = "//li[@data-cy='menu_Hotels']")
    WebElement hotelsTab;

    public boolean verifyHomePageISDisplayed() {
        closeBtn.click();
        System.out.println("home page");
        return websiteLogo.isDisplayed();
    }

    public boolean isProfileNameDisplayed() {
        pause(5000);
//        offerBannerClose.click();
        System.out.println(profileData.getText());
        return profileData.isDisplayed();
    }

    public void viewProfileData() {
        profileData.click();
        myProfileOption.click();
    }

    public void clickLogoutOption() {
        logoutOption.click();
        System.out.println("logged out");
    }

    public void clickOnFlights() {
        flightsTab.click();
    }

    public void clicksOnHotels() {
        hotelsTab.click();
    }
}

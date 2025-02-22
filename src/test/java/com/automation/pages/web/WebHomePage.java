package com.automation.pages.web;

import com.automation.pages.ui.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//span[@data-testid='cstmModal-close']")
    WebElement closeBtn;

    @FindBy(xpath = "//p[@data-cy='loggedInUser']")
    WebElement profileData;

    @FindBy(xpath = "//a[@class='mmtLogo makeFlex']")
    WebElement websiteLogo;

    @FindBy(xpath = "//span[@class='cstmModal__close']")
    WebElement offerBannerClose;

    @FindBy(xpath = "//p[contains(text(), 'My Profile')]")
    WebElement myProfileOption;

    @FindBy(xpath = "//li[contains(text(),'Logout')]")
    WebElement logoutOption;

    @FindBy(xpath = "//li[@data-cy='menu_Flights']")
    WebElement flightsTab;

    @FindBy(xpath = "//li[@data-cy='menu_Hotels']")
    WebElement hotelsTab;

    @FindBy(xpath = "//li[@data-cy='menu_Buses']")
    WebElement busesTab;

    @FindBy(xpath = "//span[@class='headerIconTextAlignment chNavText darkGreyText'][normalize-space()='Forex Card & Currency']")
    WebElement currencyTab;

    @FindBy(xpath = "//a[@id='listingPage_foreignCurrencyNotes_quickLoadBtn']")
    WebElement buyCurrency;

    @FindBy(xpath = "//li[@data-cy='menu_TravelInsurance']")
    WebElement travelInsuranceTab;


    public boolean verifyHomePageISDisplayed() {
        //closeBtn.click();
        System.out.println("home page");
        return websiteLogo.isDisplayed();
    }

    public boolean isProfileNameDisplayed() {
        pause(5000);
//        offerBannerClose.click();
        return isPresent(profileData);
    }

    public void viewProfileData() {
        profileData.click();
        myProfileOption.click();
    }

    public void clickLogoutOption() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logoutOption);
        System.out.println("logged out");
    }

    public void clickOnFlights() {
        flightsTab.click();
    }

    public void clicksOnHotels() {
        hotelsTab.click();
    }

    public void clicksOnBuses() {
        busesTab.click();
    }

    public void clicksOnCurrency(){
        currencyTab.click();
        buyCurrency.click();
    }

    public void clicksOnTravelInsurance(){
        pause(2000);
        travelInsuranceTab.click();
    }
}

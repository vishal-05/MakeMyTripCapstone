package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//li[@data-cy='personalLogin']")
    WebElement loginPageElement;

    @FindBy(xpath = "//input[@placeholder='Enter Email Address']")
    WebElement emailIdInput;

    @FindBy(xpath = "//input[@data-cy='userName']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//img[@data-cy='signInByMailButton']")
    WebElement signInbymailId;

    @FindBy(xpath = "//p[@data-cy='loggedInUser']")
    WebElement profileData;

    @FindBy(xpath = "//button/span[contains(text(), 'Continue')]")
    WebElement continueBtn;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//button[@data-cy='login']")
    WebElement loginBtn;

    @FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']/div/p")
    WebElement signupbtn;

    @FindBy(xpath = "//span[@class='commonModal__close']")
    WebElement closeBtn;

    @FindBy(xpath = "//a[@class='mmtLogo makeFlex']")
    WebElement websiteLogo;

    @FindBy(xpath = "//span[@class='cstmModal__close']")
    WebElement offerBannerClose;

    @FindBy(xpath = "//p[contains(text(), 'My Profile')]")
    WebElement myProfileOption;

    @FindBy(xpath = "//li[contains(text(), 'Logout')]")
    WebElement logoutOption;

    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));

    }

    public void clicksignup() {
        pause(30000);
        signupbtn.click();

    }

    public boolean verifyLoginPageDisplayed() {
        return loginPageElement.isDisplayed();
    }

    public void clickClose() {
        closeBtn.click();
    }

    public void enterEmailId() {
        signInbymailId.click();
        emailIdInput.sendKeys("leet3891@gmail.com");
        pause(10000);
        continueBtn.click();

    }

    public void enterPhoneNumber() {
        phoneNumberInput.sendKeys("9886984547");
        continueBtn.click();
    }

    public void enterPassword() {
        passwordInput.sendKeys("Naveen@1ust");
        loginBtn.click();
    }

    public boolean verifyHomePageISDisplayed() {
        System.out.println("home page");
        return websiteLogo.isDisplayed();
    }

    public void clickLogin() {
        pause(20000);
        loginBtn.click();
    }

    public boolean isProfileNameDisplayed() {
        pause(5000);
//        offerBannerClose.click();
        System.out.println(profileData.getText());
        return profileData.isDisplayed();
    }

    public void viewProfileData(){
        profileData.click();
        myProfileOption.click();
    }

    public void clickLogoutOption(){
        logoutOption.click();
        System.out.println("logged out");
    }
}

package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {
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
}

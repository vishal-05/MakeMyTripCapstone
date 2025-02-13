package com.automation.pages.web;

import com.automation.pages.ui.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebLoginPage extends WebBasePage implements LoginPage {
    @FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']/div/p")
    WebElement signupbtn;

    @FindBy(xpath = "//span[@class='commonModal__close']")
    WebElement closeBtn;
    @FindBy(xpath = "//li[@data-cy='personalLogin']")
    WebElement loginPageElement;

    @FindBy(xpath = "//input[@data-cy='userName']")
    WebElement phoneNumberInput;


    @FindBy(xpath = "//button/span[contains(text(), 'Continue')]")
    WebElement continueBtn;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//button[@data-cy='login']")
    WebElement loginBtn;

    public void clickLogin() {
        pause(20000);
        loginBtn.click();
    }

    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean verifyLoginPageDisplayed() {
        return loginPageElement.isDisplayed();
    }
    public void clickClose() {
        closeBtn.click();
    }
    public void enterPhoneNumber() {
        phoneNumberInput.sendKeys("9886984547");
        continueBtn.click();
    }
}

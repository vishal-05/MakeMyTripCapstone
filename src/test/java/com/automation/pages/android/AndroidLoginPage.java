package com.automation.pages.android;

import com.automation.pages.ui.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends AndroidBasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.makemytrip:id/skipTextView\"]")
    WebElement skipBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.google.android.gms:id/cancel\"]")
    WebElement noneAbove;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
    WebElement doNotAllow;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Go Back\"]")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_header\"]")
    WebElement loginPageTitle;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.makemytrip:id/inputFieldChild\"]")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.makemytrip:id/btn_submit\"]")
    WebElement confirmBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.makemytrip:id/btn_continue\"]")
    WebElement submitBtn;

    public void clickLogin() {
        pause(7000);
        submitBtn.click();
        if (isPresent(doNotAllow)) {
            doNotAllow.click();
            System.out.println("clicked do not allow");
        }
        driver.navigate().back();
        System.out.println("clicked back");
    }

    public void openApplication() {
        skipBtn.click();
        noneAbove.click();
        driver.navigate().back();
        System.out.println("clicked back");
        doNotAllow.click();
        System.out.println("clicked do not allow");
    }



    public boolean verifyLoginPageDisplayed() {
        return loginPageTitle.isDisplayed();
    }

    public void enterPhoneNumber(String phone) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(ConfigReader.getConfigValue(phone));
        pause(5000);
        confirmBtn.click();
        pause(3000);

    }
}

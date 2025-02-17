package com.automation.pages.ui;

public interface LoginPage {
    void openApplication();



//    void clickSignup();

    boolean verifyLoginPageDisplayed();

    void enterPhoneNumber(String phone);

    void clickLogin();

}

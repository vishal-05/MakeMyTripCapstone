package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.ui.LoginPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebLoginPage;

public class BaseStep {

    HomePage homePage;
    LoginPage loginPage;
    public BaseStep() {
        if (System.getProperty("platform").equals("web")) {
             homePage = new WebHomePage();
            loginPage = new WebLoginPage();
        } else {
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
        }
    }
}

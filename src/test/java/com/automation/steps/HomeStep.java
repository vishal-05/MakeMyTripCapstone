package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import io.cucumber.java.en.Given;

public class HomeStep {


    HomePage homePage;
    public HomeStep() {
        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
        } else {
            homePage = new AndroidHomePage();
        }
    }

    @Given("user open application")
    public void user_open_application() {
        homePage.openApplication();
    }
}

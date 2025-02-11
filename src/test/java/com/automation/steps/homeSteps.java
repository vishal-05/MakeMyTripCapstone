package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;

public class homeSteps {
    HomePage homePage = new HomePage();

    @Given("user open application")
    public void user_open_application() {
        homePage.openApplication();
    }
}

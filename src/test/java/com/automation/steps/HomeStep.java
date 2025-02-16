package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStep extends BaseStep {


    @Then("verify user is logged in")
    public void verify_user_is_logged_in() {
        Assert.assertTrue(homePage.isProfileNameDisplayed());
    }

    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.verifyHomePageISDisplayed());
    }

    @When("user clicks on my profile")
    public void user_clicks_on_my_profile() {
        homePage.viewProfileData();
    }

    @When("clicks logout option")
    public void clicks_logout_option() {
        homePage.clickLogoutOption();
    }

    @Then("verify user is logged out")
    public void verify_user_is_logged_out() {
        Assert.assertTrue(!homePage.isProfileNameDisplayed());
    }

    @When("user click on flights")
    public void userClickOnFlights() {
        homePage.clickOnFlights();
    }
}

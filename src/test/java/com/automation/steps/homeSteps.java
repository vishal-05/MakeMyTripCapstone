package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class homeSteps {
    HomePage homePage = new HomePage();

    @Given("user open application")
    public void user_open_application() {
        homePage.openApplication();
    }
    @When("user clicks on loginBtn")
    public void user_clicks_on_loginBtn(){
        homePage.clickClose();
        homePage.clicksignup();
    }

    @Then("verify user is on login page")
    public void verify_user_is_on_login_page(){
        Assert.assertTrue(homePage.verifyLoginPageDisplayed());
    }

    @When("user enters emailId and password")
    public void user_enters_email_id_and_password() {
        homePage.enterPhoneNumber();
        homePage.clickLogin();
    }
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
        Assert.assertFalse(homePage.isProfileNameDisplayed());
    }

}

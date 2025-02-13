package com.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep extends BaseStep{
    @Given("user open application")
    public void user_open_application() {
        loginPage.openApplication();
        loginPage.clickClose();
    }
//    @When("user clicks on loginBtn")
//    public void user_clicks_on_loginBtn(){
//        homePage.clickClose();
//        homePage.clickSignup();
//    }

    @Then("verify user is on login page")
    public void verify_user_is_on_login_page(){
        Assert.assertTrue(loginPage.verifyLoginPageDisplayed());
    }

    @When("user enters phone number and OTP")
    public void user_enters_phoneNumber_and_OTP() {
        loginPage.enterPhoneNumber();
        loginPage.clickLogin();
    }
}

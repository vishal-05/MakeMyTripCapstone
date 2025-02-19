package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CabStep extends BaseStep{


    @Then("verify user is on cab search page")
    public void verify_user_is_on_cab_search_page() {
        Assert.assertTrue(cabPage.isUSerOnCabPage());
    }
    @When("user enters the details for booking cab {string}, {string} and {string}")
    public void user_enters_the_details_for_booking_cab_and(String fromLocation, String toLocation, String date) {
        cabPage.enterCabDetails(ConfigReader.getConfigValue(fromLocation),ConfigReader.getConfigValue(toLocation));
        cabPage.enterCabDate(ConfigReader.getConfigValue(date));
    }

    @When("user clicks on search cab button")
    public void user_clicks_on_search_cab_button() {
        cabPage.clickSearchCabsBtn();
    }

    @Then("verify user is on cab listing page")
    public void verify_user_is_on_cab_listing_page() {
        Assert.assertTrue(cabPage.isUserIsOnCabListingPage());
    }

    @When("user clicks on first cab")
    public void user_clicks_on_first_cab() {
        cabPage.userClicksOnFirstCab();
    }


    @When("user enters traveller details {string}")
    public void user_enters_traveller_details_and(String gender) {
        cabPage.userEntersTravellerDetails(ConfigReader.getConfigValue(gender));
    }

    @When("selects full pay option and clicks pay now")
    public void selects_full_pay_option_and_clicks_pay_now() {
        cabPage.selectFullPayAndPayNow();
    }

    @Then("verify traveller name is correct")
    public void verify_traveller_name_is_correct() {
        Assert.assertTrue(cabPage.verifyTravellerName());
    }

    @Then("print total fare")
    public void print_total_fare() {
        cabPage.printTotalFare();
    }


}

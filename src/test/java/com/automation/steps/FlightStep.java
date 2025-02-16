package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightStep extends BaseStep{

    @Then("verify user is on flight search page")
    public void verifyUserIsOnFlightSearchPage() {
        Assert.assertTrue(flightPage.isUserIsOnFlightPage());
    }

    @When("user enters the details for booking flight {string}, {string} and {string}")
    public void userEntersTheDetailsForBookingFlightAnd(String fromCity, String toCity, String departureDate) {
        flightPage.enterFlightDetails(ConfigReader.getConfigValue(fromCity), ConfigReader.getConfigValue(toCity));
        flightPage.enterFlightDate(ConfigReader.getConfigValue(departureDate));
    }

    @And("user click on search button")
    public void userClickOnSearchButton() {
        flightPage.clickOnSearchBtn();
    }
}

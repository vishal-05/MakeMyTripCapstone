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

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        flightPage.clickOnSearchBtn();
    }

    @Then("verify user is on flight listing page")
    public void verifyUserIsOnFlightListingPage() {
        Assert.assertTrue(flightPage.isUserIsOnFlightListingPage());
    }

    @When("user clicks on first flight")
    public void userClicksOnFirstFlight() {
        flightPage.userClickOnFirstFlight();
    }

    @And("user clicks Book Now in the Saver category")
    public void userClicksBookNowInTheSaverCategory() {
        flightPage.userClicksOnBookNowBtn();
    }

    @And("print the price and user clicks on continue")
    public void printThePriceAndUserClicksOnContinue() {
        flightPage.printPriceAndClicksContinue();
    }

    @And("user enters the traveller details {string}, {string} and {string}")
    public void userEntersTheTravellerDetailsAnd(String gender, String firstName, String lastName) {
        flightPage.userEntersTravellerDetails(ConfigReader.getConfigValue(gender),
                ConfigReader.getConfigValue(firstName),
                ConfigReader.getConfigValue(lastName));
    }

    @And("print the finalized flight details")
    public void printTheFinalizedFlightDetails() {
        flightPage.printConfirmedFlightDetails();
    }
}

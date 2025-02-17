package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusStep extends BaseStep{

    @Then("verify user is on bus search page")
    public void verifyUserIsOnBusSearchPage() {
        Assert.assertTrue(busPage.isUserIsOnBusPage());
    }

    @When("user enters the details for booking bus {string}, {string} and {string}")
    public void userEntersTheDetailsForBookingBusAnd(String fromCity, String toCity, String date) {
        busPage.enterBusDetails(ConfigReader.getConfigValue(fromCity),ConfigReader.getConfigValue(toCity));
        busPage.enterBusDate(ConfigReader.getConfigValue(date));
    }

    @And("user clicks on search buses button")
    public void userClicksOnSearchBusesButton() {
        busPage.clickSearchBusesBtn();
    }

    @Then("verify user is on bus listing page")
    public void verifyUserIsOnBusListingPage() {
        Assert.assertTrue(busPage.isUserIsOnBusListingPage());
    }

    @When("user clicks on first bus")
    public void userClicksOnFirstBus() {
        busPage.userClicksOnFirstBus();
    }

    @And("user clicks on the first available seat")
    public void userClicksOnTheFirstAvailableSeat() {
        busPage.clicksOnFirstAvailableSeat();
    }

    @Then("verify pickup and drop points are visible")
    public void verifyPickupAndDropPointsAreVisible() {
        Assert.assertTrue(busPage.isPickUpDropPointsVisible());
    }

    @When("user selects pickup and drop points")
    public void userSelectsPickupAndDropPoints() {
        busPage.selectPickUpAndDropPoints();
    }


    @Then("verify review booking is visible and print finalized bus booking details")
    public void verifyReviewBookingIsVisibleAndPrintFinalizedBusBookingDetails() {
        Assert.assertTrue(busPage.isReviewBookingIsVisible());
        busPage.printConfirmedBusDetails();
    }
}

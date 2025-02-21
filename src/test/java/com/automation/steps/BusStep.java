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

    @When("user select the bus name {string}")
    public void userSelectTheBusName(String busName) {
        busPage.selectTheBusName(ConfigReader.getConfigValue(busName));
    }

    @And("user print the name of buses that are displayed")
    public void userPrintNameBusesDisplayed() {
        busPage.PrintNameBusesDisplayed();
    }


    @Then("verify that only buses matching the specified bus name {string} are displayed")
    public void verifyThatOnlyBusesMatchingTheSpecifiedBusNameAreDisplayed(String busName) {
        Assert.assertTrue(busPage.isSpecifiedBusNameIsDisplayed(ConfigReader.getConfigValue(busName)));
    }

    @When("user select the bus filters {string} and {string}")
    public void userSelectTheBusFiltersAnd(String acNonAc, String seaterSleeper) {
        busPage.selectBusFiltersAcNonAcSeaterSleeper(acNonAc, seaterSleeper);
    }

    @And("user print the name and type of buses that are displayed")
    public void userPrintTheNameAndTypeOfBusesThatAreDisplayed() {
        busPage.printBusNameAndTypeDisplayed();
    }

    @Then("verify that the buses matching the filters {string} and {string} are displayed")
    public void verifyThatTheBusesMatchingTheFiltersAndAreDisplayed(String acNonAc, String seaterSleeper) {
        Assert.assertTrue(busPage.isBusFilterAcNonAcSeaterSleeperDisplayed(acNonAc, seaterSleeper));
    }
}

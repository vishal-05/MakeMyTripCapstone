package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HotelStep extends BaseStep {

    @Then("verify user is on hotel search page")
    public void verifyUserIsOnHotelSearchPage() {
        Assert.assertTrue(hotelPage.isUserIsOnHotelPage());
    }

    @When("user enters the details for booking hotel {string}, {string} and {string}")
    public void userEntersTheDetailsForBookingHotelAnd(String location, String checkInDate, String checkOutDate) {
        hotelPage.enterHotelBookingDetails(ConfigReader.getConfigValue(location),
                ConfigReader.getConfigValue(checkInDate),
                ConfigReader.getConfigValue(checkOutDate));
    }

    @And("user clicks on hotel search button")
    public void userClicksOnHotelSearchButton() {
        hotelPage.clickOnHotelSearchBtn();
    }

    @Then("verify user is on hotel listing page")
    public void verifyUserIsOnHotelListingPage() {
        Assert.assertTrue(hotelPage.isUserIsOnHotelListingPage());
    }

    @When("user clicks on first hotel")
    public void userClicksOnFirstHotel() {
        hotelPage.clickOnFirstHotel();
    }

    @And("print the price per night and select room")
    public void printThePricePerNightAndSelectRoom() {
        hotelPage.printPriceAndSelectRoom();
    }

    @And("print the finalized hotel details")
    public void printTheFinalizedHotelDetails() {
        hotelPage.printConfirmedHotelDetails();
    }

    @Then("verify user is on hotel details page")
    public void verifyUserIsOnHotelDetailsPage() {
        hotelPage.verifyUserisOnHotelDetailsPage();
    }

    @When("user clicks on a hotel image to view and zooms")
    public void userClicksOnAHotelImageToViewAndZooms() {
        hotelPage.clickOnImage();
        hotelPage.zoomImage();
        ExtentReportManager.attachScreenshot();
    }

    @And("user zoom out and navigate back to hotels details page")
    public void userZoomOutAndNavigateBackToHotelsDetailsPage() {
        hotelPage.zoomoutImage();
        ExtentReportManager.attachScreenshot();
        hotelPage.navigateToHotelDetailsPage();

    }
}

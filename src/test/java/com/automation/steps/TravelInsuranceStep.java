package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TravelInsuranceStep extends BaseStep{

    @Then("verify user is on travel insurance page")
    public void verifyUserIsOnTravelInsurancePage() {
        Assert.assertTrue(travelInsurancePage.isUserIsOnTravelInsurancePage());
    }

    @When("user select the destination country {string}")
    public void userSelectTheDestinationCountry(String countryName) {
        travelInsurancePage.selectDestinationCountry(ConfigReader.getConfigValue(countryName));
    }

    @And("user clicks on add to destination button")
    public void userClicksOnAddToDestinationButton() {
        travelInsurancePage.clicksOnAddToDestinationBtn();
    }

    @When("user select the travel dates as start date {string} and end date {string}")
    public void userSelectTheTravelDatesAsStartDateAndEndDate(String startDate, String endDate) {
        travelInsurancePage.selectTravelDatesForInsurance(ConfigReader.getConfigValue(startDate),
                ConfigReader.getConfigValue(endDate));
    }

    @When("user select the traveller age {string}")
    public void userSelectTheTravellerAge(String travellerAge) {
        travelInsurancePage.selectTravellerAge(ConfigReader.getConfigValue(travellerAge));
    }

    @When("user clicks on view plans button")
    public void userClicksOnViewPlansButton() {
        travelInsurancePage.clicksOnViewPlansBtn();
    }

    @Then("verify user is on choose plan window")
    public void verifyUserIsOnChoosePlanWindow() {
        Assert.assertTrue(travelInsurancePage.isUserIsOnChoosePlanWindow());
    }

    @And("user prints all the plans that are displayed")
    public void userPrintsAllThePlansThatAreDisplayed() {
        travelInsurancePage.printAllDisplayedPlans();
    }
}

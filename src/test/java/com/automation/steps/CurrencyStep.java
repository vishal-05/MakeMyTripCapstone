package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CurrencyStep extends BaseStep{

    @Then("verify user is on currency page")
    public void verifyUserIsOnCurrencyPage() {
        Assert.assertTrue(currencyPage.isUserIsOnCurrencyPage());
    }

    @When("user clicks on select currency to proceed tab")
    public void userClicksOnSelectCurrencyToProceedTab() {
        currencyPage.clicksOnSelectCurrency();
    }

    @Then("verify user is on select currency or country page")
    public void verifyUserIsOnSelectCurrencyPage() {
        Assert.assertTrue(currencyPage.isUserIsOnSelectCurrencyPage());
    }

    @When("user select the country {string}")
    public void userSelectTheCountry(String countryName) {
        currencyPage.userSelectCountry(countryName);
    }

    @And("user enter the amount {string}")
    public void userEnterTheAmount(String amount) {
        currencyPage.userEnterTheAmount(amount);
    }

    @And("user get the amount in rupees")
    public void userGetTheAmountInRupees() {
        currencyPage.getAmtInRupees();
    }

    @And("push the {string}, amount to convert {string} and the amount in rupees in the excel sheet")
    public void pushTheAmountToConvertAndTheAmountInRupeesInExcelSheet(String countryName, String amount) {
        currencyPage.pushCurrencyDataInExcelSheet(countryName, amount);
    }
}

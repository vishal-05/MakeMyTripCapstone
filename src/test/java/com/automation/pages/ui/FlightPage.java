package com.automation.pages.ui;

public interface FlightPage {

    boolean isUserIsOnFlightPage();

    void enterFlightDetails(String fromCity, String toCity);

    void enterFlightDate(String departureDate);

    void clickOnSearchBtn();
}

package com.automation.pages.ui;

public interface BusPage {
    boolean isUserIsOnBusPage();

    void enterBusDetails(String fromCity, String toCity);

    void enterBusDate(String departureDate);

    void clickSearchBusesBtn();

    boolean isUserIsOnBusListingPage();

    void userClicksOnFirstBus();

    void clicksOnFirstAvailableSeat();

    boolean isPickUpDropPointsVisible();

    void selectPickUpAndDropPoints();

    boolean isReviewBookingIsVisible();

    void printConfirmedBusDetails();
}

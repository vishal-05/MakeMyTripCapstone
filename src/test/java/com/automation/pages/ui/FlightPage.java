package com.automation.pages.ui;

public interface FlightPage {

    boolean isUserIsOnFlightPage();

    void enterFlightDetails(String fromCity, String toCity);

    void enterFlightDate(String departureDate);

    void clickOnSearchBtn();

    boolean isUserIsOnFlightListingPage();

    void userClickOnFirstFlight();

    void userClicksOnBookNowBtn();

    void printPriceAndClicksContinue();

    void userEntersTravellerDetails(String gender, String firstName, String lastName );

    void printConfirmedFlightDetails();

    default void selectFilterOption(String filterOption){};

    default boolean isFlightListingDisplayedWithFilter(String filterValue) {
        return false;
    }

    default void selectSortOption(String configValue){};

    default boolean isFlightListingDisplayedWithSort(String configValue){
        return false;
    }
}

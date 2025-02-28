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

    default void selectTheBusName(String busName){

    }

    default void PrintNameBusesDisplayed(){

    }

    default boolean isSpecifiedBusNameIsDisplayed(String busName){
        return false;
    }

    default void selectBusFiltersAcNonAcSeaterSleeper(String acNonAc, String seaterSleeper){

   }

    default void printBusNameAndTypeDisplayed(){

    }

    default boolean isBusFilterAcNonAcSeaterSleeperDisplayed(String acNonAc, String seaterSleeper){
        return false;
    }

}

package com.automation.pages.ui;

public interface HomePage {


    boolean isProfileNameDisplayed();

    boolean verifyHomePageISDisplayed();

    void viewProfileData();

    void clickLogoutOption();

    void clickOnFlights();

    void clicksOnHotels();

    void clicksOnBuses();

    default void clickOnAirportCabs(){}

    default void clicksOnCurrency(){

    }

    default void clicksOnTravelInsurance(){

    }
}

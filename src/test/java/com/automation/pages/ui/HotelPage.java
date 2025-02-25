package com.automation.pages.ui;

public interface HotelPage {

    boolean isUserIsOnHotelPage();

    void enterHotelBookingDetails(String location, String checkInDate, String checkOutDate);

    void clickOnHotelSearchBtn();

    boolean isUserIsOnHotelListingPage();

    void clickOnFirstHotel();

    void printPriceAndSelectRoom();

    void printConfirmedHotelDetails();

    default boolean verifyUserisOnHotelDetailsPage(){
        return false;
    }

    default void clickOnImage(){}

    default boolean verifyImageIsZoomed(){return false;}

    default void zoomImage(){}

    default void zoomoutImage(){}

    default void navigateToHotelDetailsPage(){}
}

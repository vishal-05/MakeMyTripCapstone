package com.automation.pages.ui;

public interface CabPage {

    boolean isUSerOnCabPage();

    void enterCabDetails(String configValue, String configValue1);

    void enterCabDate(String configValue);

    void clickSearchCabsBtn();

    boolean isUserIsOnCabListingPage();

    void userClicksOnFirstCab();

    void userEntersTravellerDetails(String configValue);

    void selectFullPayAndPayNow();

    boolean verifyTravellerName();

    void printTotalFare();
}

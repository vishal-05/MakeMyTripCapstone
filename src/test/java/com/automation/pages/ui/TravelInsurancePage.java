package com.automation.pages.ui;

public interface TravelInsurancePage {

    boolean isUserIsOnTravelInsurancePage();

    void selectDestinationCountry(String countryName);

    void clicksOnAddToDestinationBtn();

    void selectTravelDatesForInsurance(String startDate, String endDate);

    void selectTravellerAge(String travellerAge);

    void clicksOnViewPlansBtn();

    boolean isUserIsOnChoosePlanWindow();

    void printAllDisplayedPlans();
}

package com.automation.pages.ui;

public interface CurrencyPage {

    boolean isUserIsOnCurrencyPage();

    void clicksOnSelectCurrency();

    boolean isUserIsOnSelectCurrencyPage();

    void userSelectCountry(String countryName);

    void userEnterTheAmount(String amount);

    void getAmtInRupees();

    void pushCurrencyDataInExcelSheet(String countryName, String amount);
}

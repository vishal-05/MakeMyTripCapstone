package com.automation.pages.web;

import com.automation.pages.ui.CurrencyPage;
import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebCurrencyPage extends WebBasePage implements CurrencyPage {

    @FindBy(xpath = "//p[@class='TextStylesstyle__ParaTagStyle-sc-1pouoje-6 boVIjQ']")
    WebElement currencyText;

    @FindBy(xpath = "//span[@class='TextStylesstyle__SpanTagStyle-sc-1pouoje-7 DiscountBannerstyle__DiscountLabel-sc-1rhg8bs-0 kEcxiQ bfFmVH']")
    WebElement selectCurrencyProceedTab;

    @FindBy(xpath = "//h5[@class='TextStylesstyle__H5TagStyle-sc-1pouoje-4 fORMBh']")
    WebElement getSelectCurrencyText;

    @FindBy(xpath = "//input[@id='select-currency-dropdown']")
    WebElement countryInputField;

    @FindBy(xpath = "//div[@class='RadioButtonstyle__RadioButtonStyle-sc-5pfrsa-0 bfIwRe']")
    List<WebElement> countrySelectedBtn;

    @FindBy(id = "add-currency-input-0")
    WebElement amountInputField;

    @FindBy(xpath = "//span[@class='TextStylesstyle__SpanTagStyle-sc-1pouoje-7 xUUas']")
    WebElement getAmtRupees;

    @FindBy(xpath = "//p[@class='TextStylesstyle__ParaTagStyle-sc-1pouoje-6 cfIcgX']")
    WebElement countryCurrencyText;


    public boolean isUserIsOnCurrencyPage(){
        return currencyText.getText().contains("Currency");
    }

    public void clicksOnSelectCurrency(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectCurrencyProceedTab);

    }

    public boolean isUserIsOnSelectCurrencyPage(){
        return getSelectCurrencyText.getText().contains("Currency");
    }

    public void userSelectCountry(String countryName){
        countryInputField.sendKeys(countryName);
        countrySelectedBtn.getFirst().click();
        System.out.println("*******************************************");
        System.out.println("Country: "+countryName);
    }

    public void userEnterTheAmount(String amount){
        amountInputField.sendKeys(amount);
        System.out.println(("Amount to Convert: "+amount));
    }

    public void getAmtInRupees(){
       // getAmtRupees.getText();
        System.out.println("Amount Converted in Rupees: "+getAmtRupees.getText());
    }

    public void pushCurrencyDataInExcelSheet(String countryName, String amount){
        DriverManager.writeToExcel(countryName, countryCurrencyText.getText(), amount, getAmtRupees.getText());
    }

}

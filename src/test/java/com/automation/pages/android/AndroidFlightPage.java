package com.automation.pages.android;

import com.automation.pages.ui.FlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class AndroidFlightPage extends AndroidBasePage implements FlightPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_header_first\"]")
    WebElement flightSearchText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/from_to_et\"]")
    WebElement fromCityBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.makemytrip:id/departure_city_input\"]")
    WebElement fromCityInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_to_et\"]")
    WebElement  toCityBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.makemytrip:id/arrival_city_input\"]")
    WebElement toCityInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_dep\"]")
    WebElement departureDateText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_month\"]")
    WebElement monthName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/btnDone\"]")
    WebElement doneBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/search_button_flat\"]")
    WebElement searchBtn;

    public boolean isUserIsOnFlightPage(){
        return flightSearchText.getText().equals("Flight");
    }

    public void enterFlightDetails(String fromCity, String toCity) {
        fromCityBtn.click();
        fromCityInput.sendKeys(fromCity);
        WebElement fromCityElement = driver.findElement(By.xpath(String.format("//android.widget.TextView[@resource-id=\"com.makemytrip:id/title\" and @text=\"%s\"]", fromCity)));
        fromCityElement.click();

        toCityBtn.click();
        toCityInput.sendKeys(toCity);
        WebElement toCityElement = driver.findElement(By.xpath(String.format("//android.widget.TextView[@resource-id=\"com.makemytrip:id/title\" and @text=\"%s\"]", toCity)));
        toCityElement.click();
    }

    public void enterFlightDate(String departureDate){
        departureDateText.click();

        String expMonth = getFormattedDate("MMMM", departureDate, "dd/MM/yyyy");
        pause(4000);
        String actMonth = monthName.getText();
        while (!expMonth.contains(actMonth.trim())) {
            System.out.print(actMonth);
            System.out.print(expMonth);
            WebElement elementForScroll = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.makemytrip:id/rvCalendarMonth\"]/android.view.View[1]"));
            //scrollWithWebElement(elementForScroll);
            scrollPage();
            pause(1000);
            actMonth = monthName.getText();
            if(expMonth.equals(actMonth)){
                break;
            }
        }
        String XPATH_DATE_VALUE = "//f[@content-desc=\"%s 2025 Tap to select\"]";

        String dateValue = getFormattedDate("dd MMM", departureDate, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();

        doneBtn.click();
    }

    public void clickOnSearchBtn(){
        searchBtn.click();
    }
}

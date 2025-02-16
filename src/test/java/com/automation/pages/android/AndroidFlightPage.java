package com.automation.pages.android;

import com.automation.pages.ui.FlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.beans.Visibility;
import java.util.List;
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

    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.makemytrip:id/recycler_view\"])[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout")
    WebElement dismissBtn;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.makemytrip:id/airline_name\"])")
    List<WebElement> flightList;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.makemytrip:id/btnBookNow\"])[1]")
    WebElement bookNowBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/fare_family_tot_amt_txt\"]")
    WebElement ticketPrice;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/fare_family_cont\"]")
    WebElement continueBtn1;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/review_tv\"]")
    WebElement continueBtn2;

    @FindBy(xpath = "//android.widget.TextView[@text=\"+ ADD NEW ADULT\"]")
    WebElement addNewAdultBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.makemytrip:id/et_passport_number\" and @text=\"First & Middle Name\"]")
    WebElement firstNameEle;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.makemytrip:id/et_passport_number\" and @text=\"Last Name\"]")
    WebElement lastNameEle;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.makemytrip:id/clBottomSticky\"]")
    WebElement confirmBtn1;

    @FindBy(xpath = "//android.widget.CheckBox[@resource-id=\"com.makemytrip:id/confirmationCheckBox\"]")
    WebElement checkBox;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/snack_bar_footer_left\"]")
    WebElement unSecureBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/right_cta\"]")
    WebElement confirmBtn2;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/snack_bar_footer_right\"]")
    WebElement yesPleaseBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_final_fare\"]")
    WebElement ticketPriceAfterSeat;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"title\"]")
    WebElement titleOfTicket;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"time\"]")
    WebElement timingInTicket;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Total Due\"]/../android.widget.TextView[2]")
    WebElement finalPriceInTicket;



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
        String datePart = dateValue.substring(0, 2); // Extracts "14"
        String monthPart = dateValue.substring(3);   // Extracts "Apr"
        monthPart = monthPart.toUpperCase();   // Converts "Apr" to "APR"
        dateValue = datePart + " " + monthPart;
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();

        doneBtn.click();
    }

    public void clickOnSearchBtn(){
        searchBtn.click();
    }

    public boolean isUserIsOnFlightListingPage(){
        dismissBtn.click();
        return !flightList.isEmpty();
    }

    public void userClickOnFirstFlight(){
        flightList.getFirst().click();
    }

    public void userClicksOnBookNowBtn(){
        bookNowBtn.click();
    }

    public void printPriceAndClicksContinue(){
        System.out.println("Flight Ticket price: "+ticketPrice.getText());
        continueBtn1.click();
        wait.until(ExpectedConditions.visibilityOf(continueBtn2));
        continueBtn2.click();
    }

    public void userEntersTravellerDetails(String gender, String firstName, String lastname){
        addNewAdultBtn.click();
        WebElement genderEle = driver.findElement(By.xpath(String.format("//android.widget.TextView[@text=\"%s\"]",gender)));
        genderEle.click();
        firstNameEle.sendKeys(firstName);
        lastNameEle.sendKeys(lastname);
        confirmBtn1.click();
        continueBtn2.click();
        unSecureBtn.click();
        confirmBtn2.click();
        yesPleaseBtn.click();
        System.out.println("Flight ticket price after selecting seat: "+ticketPriceAfterSeat.getText());
        continueBtn2.click();
        continueBtn2.click();
        continueBtn2.click();
    }

    public void printConfirmedFlightDetails(){
        System.out.println("******************Flight Booking Details******************");
        System.out.println(titleOfTicket.getText());
        System.out.println(timingInTicket.getText());
        System.out.println("Final Price: "+finalPriceInTicket.getText());
    }
}

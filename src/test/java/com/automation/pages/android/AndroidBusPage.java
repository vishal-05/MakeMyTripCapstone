package com.automation.pages.android;

import com.automation.pages.ui.BusPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidBusPage extends AndroidBasePage implements BusPage {

    @FindBy(xpath = "//android.view.View[@resource-id=\"landingPage_busSearch\"]")
    WebElement busSearchText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"FROM\"]")
    WebElement fromCityTab;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Try Searching For \"]")
    WebElement fromCityInput;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement toCityInput;

    @FindBy(xpath = "//android.widget.TextView[@text=\"DATE\"]")
    WebElement departureDateText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"DONE\"]")
    WebElement doneBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SEARCH BUSES\"]")
    WebElement searchBusesBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Okay\"]/android.view.View")
    WebElement freeCancelBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"idOperatorName\"]")
    List<WebElement> listOfBuses;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='ss_SeatAvailable'])[1]")
    WebElement firstAvailableSeat;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Next\"]")
    WebElement nextBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Select Pickup & Drop Points\"]")
    WebElement pickUpDropText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"bpDp_BoardingPoint\"]")
    WebElement boardingPoint;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"bpDp_DropPoint\"]")
    WebElement dropPoint;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"reviewPage_header_text\"]")
    WebElement reviewBookingText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"reviewPage_operatorName\"]")
    WebElement busNameText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"reviewPage_BoardingPoint_name\"]")
    WebElement boardingPointNameText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"reviewPage_BoardingPoint_timeStamp\"]")
    WebElement boardingPointTimeText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"reviewPage_DropPoint_name\"]")
    WebElement dropPointNameText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"reviewPage_DroppingPoint_timeStamp\"]")
    WebElement dropPointTimeText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"reviewPage_SeatPrice\"]")
    WebElement finalPrice;

    public boolean isUserIsOnBusPage(){
        return busSearchText.getText().contains("Bus");
    }

    public void enterBusDetails(String fromCity, String toCity){
        fromCityTab.click();
        fromCityInput.sendKeys(fromCity);
        WebElement fromCityElement = driver.findElement(By.xpath(String.format("//android.widget.TextView[contains(@text,'%s')][1]",fromCity)));
        fromCityElement.click();

        toCityInput.sendKeys(toCity);
        WebElement toCityElement = driver.findElement(By.xpath(String.format("//android.widget.TextView[contains(@text,'%s')]",toCity)));
        toCityElement.click();
    }

    public void enterBusDate(String departureDate){
        departureDateText.click();

        String expMonth = getFormattedDate("MMMM", departureDate, "dd/MM/yyyy");
        pause(4000);
        WebElement elementForScroll = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.makemytrip:id/react_fragment_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]"));
        List<WebElement> expMonthElement = driver.findElements(By.xpath("//android.widget.TextView[contains(@text,' 25')]"));
        while (!expMonthElement.getFirst().getText().contains(expMonth)){
            elementForScroll = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.makemytrip:id/react_fragment_container\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]"));
            scrollWithWebElement(elementForScroll);
            pause(1000);
            expMonthElement = driver.findElements(By.xpath("//android.widget.TextView[contains(@text,' 25')]"));
        }

        String dateValue = getFormattedDate("dd", departureDate, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format("(//android.widget.TextView[@text=\"%s\"])[1]", dateValue)));
        dateElement.click();

        doneBtn.click();

    }

    public  void clickSearchBusesBtn(){
        searchBusesBtn.click();
    }

    public boolean isUserIsOnBusListingPage(){
        freeCancelBtn.click();
        return !listOfBuses.isEmpty();
    }

    public void userClicksOnFirstBus(){
        listOfBuses.getFirst().click();
    }

    public void clicksOnFirstAvailableSeat(){
        pause(2000);
        firstAvailableSeat.click();
        firstAvailableSeat.click();
        nextBtn.click();
    }

    public boolean isPickUpDropPointsVisible(){
        return pickUpDropText.getText().contains("Pickup");
    }

    public void selectPickUpAndDropPoints(){
        boardingPoint.click();
        dropPoint.click();
    }

    public boolean isReviewBookingIsVisible(){
        return reviewBookingText.getText().contains("Review");
    }

    public void printConfirmedBusDetails(){
        System.out.println("****************** Bus Booking Details ******************");
        System.out.println("Bus Name: "+busNameText.getText());
        System.out.println("Boarding point and Time: "+boardingPointNameText.getText()+" & "+boardingPointTimeText.getText());
        System.out.println("Drop point and Time: "+dropPointNameText.getText()+" & "+dropPointTimeText.getText());
        System.out.println("Ticket Price: "+finalPrice.getText());
        System.out.println("**********************************************************");
    }

}

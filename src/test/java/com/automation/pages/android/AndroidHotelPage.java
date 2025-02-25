package com.automation.pages.android;

import com.automation.pages.ui.HotelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AndroidHotelPage extends AndroidBasePage implements HotelPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"title\" and @text=\"Hotels & Homestays\"]")
    WebElement hotelSearchText;

    @FindBy(xpath = "//android.view.View[@resource-id='location_box']")
    WebElement locationBox;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='input_text']")
    WebElement searchText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_month\"]")
    WebElement monthName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/btnDone\"]")
    WebElement doneBtn1;

    @FindBy(xpath = "//android.view.View[@resource-id=\"room_and_guest_box\"]")
    WebElement guestBox;

    @FindBy(xpath = "(//android.view.View[@resource-id=\"dropdown_icon\"])[2]")
    WebElement adultOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"dropdown_item_text\" and @text=\"02\"]")
    WebElement numOfAdults;

    @FindBy(xpath = "//android.widget.TextView[@text=\"DONE\"]")
    WebElement doneBtn2;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"search_cta\"]")
    WebElement searchBtn;

    @FindBy(xpath = "//android.view.View[@resource-id=\"mediaCard\"]")
    List<WebElement> hotelImage;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"tvHotelName\"]")
    WebElement firstHotelTab;

        @FindBy(xpath = "//android.widget.TextView[@resource-id=\"tv_title\"]")
            WebElement hotelName;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"tvRoomPrice\"]")
    WebElement roomPricePerNight;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"forwardButton\"]")
    WebElement selectRoomTab;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"tv_hotel_name\"]")
    WebElement hotelNameText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"check_in_date\"]")
    WebElement checkInDateText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"check_in\"]")
    WebElement checkInTimeText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"check_out_date\"]")
    WebElement checkOutDateText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"check_out\"]")
    WebElement checkOutTimeText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"tv_amount\"]")
    WebElement totalAmt;

        @FindBy(xpath = "(//android.view.View[@resource-id=\"image_grid_item\"])[1]")
            WebElement hotelImageEle;

            @FindBy(xpath = "//android.view.View[@resource-id=\"gallery_item_12\"]")
                WebElement firstHotelImg;

                @FindBy(xpath = "(//android.view.View[@resource-id=\"media_grid_list_item_0\"])[1]")
                    WebElement firstHotelImg1;

    public boolean isUserIsOnHotelPage() {
        return hotelSearchText.isDisplayed();
    }

    public void enterHotelBookingDetails(String location, String checkInDate, String checkOutDate) {
        locationBox.click();
        searchText.sendKeys(location);
        List<WebElement> searchLocation = driver.findElements(By.xpath(String.format("//android.widget.TextView[contains(@text,'%s')][1]", location)));
        searchLocation.getFirst().click();

        String expMonth = getFormattedDate("MMMM", checkInDate, "dd/MM/yyyy");
        pause(4000);
        String actMonth = monthName.getText();
        while (!expMonth.contains(actMonth.trim())) {
            System.out.print(actMonth);
            System.out.print(expMonth);
            scrollPage();
            pause(1000);
            actMonth = monthName.getText();
            if (expMonth.equals(actMonth)) {
                break;
            }
        }

        String XPATH_DATE_VALUE = "//f[@content-desc=\"%s 2025 Tap to select\"]";

        String dateValue = getFormattedDate("dd MMM", checkInDate, "dd/MM/yyyy");
        String datePart = dateValue.substring(0, 2); // Extracts "14"
        String monthPart = dateValue.substring(3);   // Extracts "Apr"
        monthPart = monthPart.toUpperCase();   // Converts "Apr" to "APR"
        dateValue = datePart + " " + monthPart;
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();

        dateValue = getFormattedDate("dd MMM", checkOutDate, "dd/MM/yyyy");
        datePart = dateValue.substring(0, 2); // Extracts "14"
        monthPart = dateValue.substring(3);   // Extracts "Apr"
        monthPart = monthPart.toUpperCase();   // Converts "Apr" to "APR"
        dateValue = datePart + " " + monthPart;
        dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();

        doneBtn1.click();

        guestBox.click();
        adultOption.click();
        numOfAdults.click();
        doneBtn2.click();

    }

    public void clickOnHotelSearchBtn() {
        searchBtn.click();
    }

    public boolean isUserIsOnHotelListingPage() {
        return !hotelImage.isEmpty();
    }

    public void clickOnFirstHotel() {
        firstHotelTab.click();
    }

    public void printPriceAndSelectRoom() {
        System.out.println("Room price per night: " + roomPricePerNight.getText());
        selectRoomTab.click();
        wait.until(ExpectedConditions.visibilityOf(selectRoomTab));
        selectRoomTab.click();
    }

    public void printConfirmedHotelDetails() {
        System.out.println("****************** Hotel Booking Details ******************");
        System.out.println("Hotel Name: " + hotelNameText.getText());
        System.out.println("Check In Date And Time: " + checkInDateText.getText() + " ---> " + checkInTimeText.getText());
        System.out.println("Check Out Date And Time: " + checkOutDateText.getText() + " ---> " + checkOutTimeText.getText());
        System.out.println("Total Amount Incl Of Taxes & Fees: " + totalAmt.getText());
        System.out.println("***********************************************************");
    }

    public boolean verifyUserisOnHotelDetailsPage() {
        return hotelName.isDisplayed();
    }

    public void clickOnImage() {
        hotelImageEle.click();
        if(isPresent(firstHotelImg)){
            firstHotelImg.click();
        } else {
            firstHotelImg1.click();
        }
        System.out.println("image displayed");
    }




    public void zoomImage(){
        zoom();
        System.out.println("zoomed in");
        pause(2000);
    }

    public void zoomoutImage(){
        zoomOut();
        System.out.println("zoomed out");
    }

    public void navigateToHotelDetailsPage(){
        driver.navigate().back();
        driver.navigate().back();
    }

}

package com.automation.pages.web;

import com.automation.pages.ui.HotelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebHotelPage extends WebBasePage implements HotelPage {
    @FindBy(xpath = "//li[@data-cy='menu_Hotels']//a[@class='headerIcons makeFlex hrtlCenter column active']")
    WebElement hotelTabActive;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityBox;

    @FindBy(xpath = "//input[@placeholder='Where do you want to stay?']")
    WebElement cityInput;

    @FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
    WebElement firstCityFromList;

    @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//div[@class='DayPicker-Caption']")
    WebElement monthName;

    @FindBy(xpath = "//button[@class='primaryBtn btnApplyNew pushRight capText']")
    WebElement guestApplyBtn;

    @FindBy(xpath = "//button[@id='hsw_search_button']")
    WebElement searchBtn;

    @FindBy(xpath = "//span[@class='wordBreak appendRight10']")
    List<WebElement> hotelTitles;

    @FindBy(xpath = "//div[@class='rmPayable__newDtl--left']/div")
    WebElement roomPricePerNight;

    @FindBy(xpath = "//div[@class='rmPayable__newDtl--right newDtlsSelectRoom appendTop10']//a")
    WebElement selectRoomBtn;

    @FindBy(xpath = "//div[@class='rvHtlInfoLft']/h3")
    WebElement hotelName;

    @FindBy(xpath = "//p[@class='prptChk__date']")
    List<WebElement> hotelDates;

    @FindBy(xpath = "//div[@class='pricBreakup__total']//div[@class='pricBreakup__rht']")
    WebElement totalAmt;

    public boolean isUserIsOnHotelPage() {
        return hotelTabActive.isDisplayed();
    }

    public void enterHotelBookingDetails(String location, String checkInDate, String checkOutDate) {
        cityBox.click();
        cityInput.sendKeys(location);
        pause(5000);
        firstCityFromList.click();
        enterHotelDate(checkInDate, checkOutDate);
        pause(3000);
        guestApplyBtn.click();
    }

    public void enterHotelDate(String checkInDate, String checkoutDate) {
        String expMonth = getFormattedDate("MMMM", checkInDate, "dd/MM/yyyy");
        pause(4000);
        String actMonth = monthName.getText();
        String firstWord = actMonth.replaceAll("[^a-zA-Z]", "");
        while (!expMonth.contains(firstWord.trim())) {
            System.out.print(firstWord);
            System.out.print(expMonth);
            nextMonthBtn.click();
            pause(1000);
            actMonth = monthName.getText();
            firstWord = actMonth.replaceAll("[^a-zA-Z]", "");
            if (expMonth.equals(firstWord)) {
                break;
            }
        }
        String dateValue = getFormattedDate("dd", checkInDate, "dd/MM/yyyy");
        System.out.println(dateValue);
        WebElement checkInDateElement = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and contains(text(),'" + dateValue + "')]"));
        checkInDateElement.click();
        dateValue = getFormattedDate("dd", checkoutDate, "dd/MM/yyyy");
        WebElement checkOutDateElement = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and contains(text(),'" + dateValue + "')]"));
        checkOutDateElement.click();
    }

    public void clickOnHotelSearchBtn() {
        searchBtn.click();
    }

    public boolean isUserIsOnHotelListingPage() {
        return !hotelTitles.isEmpty();
    }

    public void clickOnFirstHotel() {
        hotelTitles.getFirst().click();
    }

    public void printPriceAndSelectRoom() {
        switchToNewTab();
        pause(5000);
        System.out.println("Room price per night: " + roomPricePerNight.getText());
        pause(5000);
        selectRoomBtn.click();
        pause(5000);
    }

    public void printConfirmedHotelDetails() {
        WebElement checkInDate = hotelDates.get(0);
        WebElement checkInTime = checkInDate.findElement(By.xpath("following-sibling::p"));

        WebElement checkOutDate = hotelDates.get(1);
        WebElement checkOutTime = checkOutDate.findElement(By.xpath("following-sibling::p"));
        System.out.println("****************** Hotel Booking Details ******************");
        System.out.println("Hotel Name: " + hotelName.getText());
        System.out.println("Check In Date And Time: " + checkInDate.getText() + " ---> " + checkInTime.getText());
        System.out.println("Check Out Date And Time: " + checkOutDate.getText() + " ---> " + checkOutTime.getText());
        System.out.println("Total Amount Incl Of Taxes & Fees: " + totalAmt.getText());
        System.out.println("***********************************************************");
    }


}

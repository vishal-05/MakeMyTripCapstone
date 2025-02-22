package com.automation.pages.web;

import com.automation.pages.ui.BusPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebBusPage extends WebBasePage implements BusPage {
    @FindBy(xpath = "//li[@data-cy='menu_Buses']//a[@class='headerIcons makeFlex hrtlCenter column active']")
    WebElement busTabActive;

    @FindBy(xpath = "//input[@id='fromCity']")
    WebElement fromCityBox;

    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement fromCityInput;

    @FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
    WebElement firstCityFromList;

    @FindBy(xpath = "//input[@id='toCity']")
    WebElement toCityBox;

    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toCityInput;

    @FindBy(xpath = "//div[@class='DayPicker-Caption']")
    WebElement monthName;
    @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//button[@id='search_button']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='busCardContainer ']")
    List<WebElement> busList;

    @FindBy(xpath = "//div[@class='busListingContainer']/div[@class='sortViewContainer makeFlex spaceBetween hrtlCenter']/p[contains(text(), buses)]")
    WebElement busPageText;

    @FindBy(xpath = "//span[@data-testid='seat_horizontal_sleeper_available']")
    List<WebElement> sleeperSeats;

    @FindBy(xpath = "//span[@data-testid='seat_seater_available']")
    List<WebElement> regularSeats;

    @FindBy(xpath = "//div[@class='selectPickDrop']/div[contains(text(), 'Select Pickup & Drop Points')]")
    WebElement pickUpDropText;

    @FindBy(xpath = "//div[@class='summaryContainer']//span[contains(text(), 'Continue')]")
    WebElement continueBtn;

    @FindBy(xpath = "//div[@class='reviewHeaderContainer  makeFlex spaceBetween ']")
    WebElement reviewPageHeader;

    @FindBy(xpath = "//div[@class='travellerBusInfoDetails makeFlex column card']//p")
    WebElement busName;

    @FindBy(xpath = "//div[@class='makeFlex row blackText reviewBusInfoWrapper cardPadding spaceBetween']/div")
    WebElement boardingPointName;

    @FindBy(xpath = "//p[@class='totalPriceValue textRight makeFlex column blackText font16 latoBlack']")
    WebElement finalPrice;

    @FindBy(xpath = "//div[@class='makeFlex row blackText reviewBusInfoWrapper cardPadding spaceBetween']/div[3]")
    WebElement dropPointName;

    @FindBy(xpath = "//li[@class='containerHorizontal'][6]//span[@class='sc-kjoXOD erIYpE']")
    List<WebElement> listOfBusNames;

    @FindBy(xpath = "//p[@class='makeFlex hrtlCenter appendBottom8 latoBold blackText appendRight15']")
    List<WebElement> displayedBusNames;

    @FindBy(id = "price")
    List<WebElement> displayedBusPrice;

    @FindBy(xpath = "//div[@class='busTypesFilterSection']//span[@class='secondaryTxt font14']")
    List<WebElement> busAcNonAcSeaterSleeper;

    @FindBy(xpath = "//p[@class='makeFlex hrtlCenter secondaryTxt nowrapStyle']")
    List<WebElement> displayedBusType;

    @FindBy(id = "toggle_buses")
    WebElement toggleBus;

    @FindBy(xpath = "//p[@class='sc-fAjcbJ jzbkvc']")
    WebElement noBusesFound;

    public boolean isUserIsOnBusPage() {
        return busTabActive.isDisplayed();
    }

    public void enterBusDetails(String fromCity, String toCity) {
        fromCityBox.click();
        fromCityInput.sendKeys(fromCity);
        pause(5000);
        firstCityFromList.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", toCityBox);
        toCityInput.sendKeys(toCity);
        pause(5000);
        firstCityFromList.click();
    }

    public void enterBusDate(String departureDate) {
        String expMonth = getFormattedDate("MMMM", departureDate, "dd/MM/yyyy");
        pause(4000);
        String actMonth = monthName.getText();
        String firstWord = actMonth.split(" ")[0];
        while (!expMonth.contains(firstWord.trim())) {
            System.out.print(firstWord);
            System.out.print(expMonth);
            nextMonthBtn.click();
            pause(1000);
            actMonth = monthName.getText();
            firstWord = actMonth.split(" ")[0];
            if (expMonth.equals(firstWord)) {
                break;
            }
        }
        String dateValue = getFormattedDate("dd", departureDate, "dd/MM/yyyy");
        System.out.println(dateValue);
        WebElement dateElement = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and contains(text(), '" + dateValue + "')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dateElement);
       // dateElement.click();
    }

    public void clickSearchBusesBtn() {
        searchBtn.click();
    }

    public boolean isUserIsOnBusListingPage() {
        return !busList.isEmpty() & busPageText.isDisplayed();
    }

    public void userClicksOnFirstBus() {
        busList.getFirst().click();
    }

    public void clicksOnFirstAvailableSeat() {
        if (!sleeperSeats.isEmpty()) {
            WebElement firstSleeperSeat = sleeperSeats.getFirst();
            firstSleeperSeat.click();
            System.out.println("Sleeper bed seat selected.");
        }
        // If no sleeper seat is available, check for regular seats
        else if (!regularSeats.isEmpty()) {
            WebElement firstRegularSeat = regularSeats.getFirst();
            firstRegularSeat.click();
            System.out.println("Regular seat selected.");
        } else {
            System.out.println("No available seats found.");
        }
    }

    public boolean isPickUpDropPointsVisible() {
        return pickUpDropText.isDisplayed();
    }

    public void selectPickUpAndDropPoints() {
        continueBtn.click();
    }

    public boolean isReviewBookingIsVisible() {
        return reviewPageHeader.isDisplayed();
    }

    public void printConfirmedBusDetails() {
        System.out.println("****************** Bus Booking Details ******************");
        System.out.println("Bus Name: " + busName.getText());
        System.out.println("Boarding point and Time: " + boardingPointName.getText());
        System.out.println("Drop point and Time: " + dropPointName.getText());
        System.out.println("Ticket Price: " + finalPrice.getText());
        System.out.println("**********************************************************");
    }

    public void selectTheBusName(String busName){
        for(WebElement busNameElement : listOfBusNames){
            if(busNameElement.getText().contains(busName)){
                busNameElement.click();
                pause(2000);
                break;
            }
        }
    }

    public void PrintNameBusesDisplayed(){
        for(int i=0;i<displayedBusNames.size();i++){
            System.out.print(displayedBusNames.get(i).getText()+" ---> ");
            System.out.println(displayedBusPrice.get(i).getText());
        }
    }

    public boolean isSpecifiedBusNameIsDisplayed(String busName){
        for(WebElement busNameElement : displayedBusNames){
            if(!busNameElement.getText().contains(busName)){
                return false;
            }
        }
        return true;
    }

    public void selectBusFiltersAcNonAcSeaterSleeper(String acNonAc, String seaterSleeper){
        for (WebElement filterElement : busAcNonAcSeaterSleeper){
            if(filterElement.getText().equals(acNonAc) || filterElement.getText().contains(seaterSleeper)){
                filterElement.click();
            }
        }
        pause(2000);
    }
    public void printBusNameAndTypeDisplayed(){
        if(isPresent(noBusesFound)){
            System.out.println("No Buses Found");
        }
        else {
            if (isPresent(toggleBus)) {
                toggleBus.click();
            }
            for (int i = 0; i < displayedBusNames.size(); i++) {
                System.out.print(displayedBusNames.get(i).getText() + " ---> ");
                System.out.println(displayedBusType.get(i).getText());
            }
        }
    }

    public boolean isBusFilterAcNonAcSeaterSleeperDisplayed(String acNonAc, String seaterSleeper){
        for (WebElement filterElement : displayedBusType){
            if(!filterElement.getText().contains(acNonAc) && !(filterElement.getText().contains(seaterSleeper) || filterElement.getText().contains("Semi Sleeper"))){
                return false;
            }
        }
        return true;
    }
}

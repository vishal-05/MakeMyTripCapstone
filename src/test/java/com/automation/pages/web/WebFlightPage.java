package com.automation.pages.web;

import com.automation.pages.ui.FlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WebFlightPage extends WebBasePage implements FlightPage {

    @FindBy(xpath = "//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")
    WebElement flightTabActive;

    @FindBy(id = "fromCity")
    WebElement fromCityBox;

    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement fromCityInput;

    @FindBy(id = "react-autowhatever-1-section-0-item-0")
    WebElement firstCityFromList;

    @FindBy(id = "toCity")
    WebElement toCityInput;

    @FindBy(xpath = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//div[@class='DayPicker-Caption']")
    WebElement monthName;

    @FindBy(xpath = "//p[@data-cy='submit']/a")
    WebElement searchBtn;

    //    @FindBy(xpath = "//div[@class='fareLockInfoContainer']/button")
    @FindBy(xpath = "//span[contains(text(), 'GOT IT')]")
    WebElement fareLockButtonAd;

    @FindBy(xpath = "//div[@class='listingCard  appendBottom5']")
    List<WebElement> flightList;

    @FindBy(xpath = "//button[@class='ViewFareBtn  text-uppercase  clusterBtn']")
    WebElement viewPricesBtn;

    @FindBy(xpath = "//button[contains(text(), 'BOOK NOW')]")
    WebElement bookNowButton;

    @FindBy(xpath = "//span[@data-test='component-tot_fare']")
    WebElement totalFare;

    @FindBy(xpath = "//button[@class='addTravellerBtn']")
    WebElement addAdultBtn;

    @FindBy(xpath = "//input[@placeholder='First & Middle Name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameInput;

    @FindBy(xpath = "(//div[@class='insRadioSection appendBottom8 '])[2]//span")
    WebElement noInsurance;

    @FindBy(xpath = "//div[@class='flightItenaryHdr']//p")
    WebElement titleOfTicket;

    @FindBy(xpath = "//span[@data-test='component-time']")
    List<WebElement> timingInTicket;

    @FindBy(xpath = "//div[@class='adultList ']/label")
    WebElement adult1;

//    @FindBy(xpath = "//div[@class='adultItem']/div[@class='selectTab ']//label")
//    WebElement genderElement;

    public boolean isUserIsOnFlightPage() {
        return flightTabActive.isDisplayed();
    }

    public void enterFlightDetails(String fromCity, String toCity) {
        System.out.println(fromCity);
        fromCityBox.click();
        fromCityInput.sendKeys(fromCity);
        pause(5000);
        firstCityFromList.click();
        toCityInput.click();
        toCityInput.sendKeys(toCity);
        firstCityFromList.click();
    }

    public void enterFlightDate(String departureDate) {
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
        WebElement dateElement = driver.findElement(By.xpath("//div[contains(@aria-label, '" + dateValue + "')]/div[@class='dateInnerCell']/p[contains(text(), '" + dateValue + "')][1]"));
        dateElement.click();
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public boolean isUserIsOnFlightListingPage() {
        pause(5000);
        fareLockButtonAd.click();
        return !flightList.isEmpty();
    }

    public void userClickOnFirstFlight() {
        viewPricesBtn.click();
        System.out.println("click prices");
        pause(5000);
    }

    public void userClicksOnBookNowBtn() {
        bookNowButton.click();
    }

    public void printPriceAndClicksContinue() {
        switchToNewTab();
        System.out.println(totalFare.getText());
    }

    public void userEntersTravellerDetails(String gender, String firstName, String lastname) {
        addAdultBtn.click();
        pause(5000);
        adult1.click();
        System.out.println("click adult");
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastname);
        pause(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement genderElement = driver.findElement(By.xpath(String.format("//label/span[contains(text(), '%s')]", gender)));
        js.executeScript("arguments[0].click();", genderElement);
        pause(5000);
        js.executeScript("arguments[0].click();", noInsurance);
        noInsurance.click();
        System.out.println("clicked insurance");
        pause(5000);
    }

    public void printConfirmedFlightDetails() {
        System.out.println("******************Flight Booking Details******************");
        System.out.println(titleOfTicket.getText());
        System.out.println("Departure time" + timingInTicket.get(0).getText());
        System.out.println("Arrival time" + timingInTicket.get(1).getText());
        System.out.println("Final Price: " + totalFare.getText());
    }

}

package com.automation.pages.android;

import com.automation.pages.ui.FlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidFlightPage extends AndroidBasePage implements FlightPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_header_first\"]")
    WebElement flightSearchText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/from_to_et\"]")
    WebElement fromCityBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.makemytrip:id/departure_city_input\"]")
    WebElement fromCityInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_to_et\"]")
    WebElement toCityBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.makemytrip:id/arrival_city_input\"]")
    WebElement toCityInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_dep\"]")
    WebElement departureDateText;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_month\"]")
    WebElement monthName;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_year\"])[1]")
    WebElement yearName;

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

   // @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.makemytrip:id/selection_layout\"]")
    //  WebElement confirmBtn1;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.makemytrip:id/confirm_button']")
    WebElement adultConfirmBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Travel Unsecured\"]")
    WebElement unSecureBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.makemytrip:id/right_cta\"]")
    WebElement confirmBtn2;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Confirm & continue\"]")
    WebElement confirmContinueBtn;

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

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.makemytrip:id/filter_sort_icon']")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.makemytrip:id/apply_button']")
    WebElement applyBtn;

    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.makemytrip:id/recycler_view\"])[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout")
    WebElement addFilter;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Sort by']")
    WebElement sortByTab;


    public boolean isUserIsOnFlightPage() {
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

    public void enterFlightDate(String departureDate) {
        departureDateText.click();

        String expMonth = getFormattedDate("MMMM", departureDate, "dd/MM/yyyy");
        pause(4000);
        String actMonth = monthName.getText();
        while (!expMonth.contains(actMonth.trim())) {
            System.out.print(actMonth);
            System.out.print(expMonth);
            WebElement monthEle = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.makemytrip:id/rvCalendarMonth\"]/android.view.View[1]"));
            scrollWithWebElement(monthEle);
            pause(500);
            actMonth = monthName.getText();
            if (expMonth.equals(actMonth)) {
                break;
            }
        }
        String XPATH_DATE_VALUE = "//f[@content-desc=\"%s 2025 Tap to select\"]";

        String dateValue = getFormattedDate("dd MMM", departureDate, "dd/MM/yyyy");
        String datePart = dateValue.substring(0, 2);
        String monthPart = dateValue.substring(3);
        monthPart = monthPart.toUpperCase();
        dateValue = datePart + " " + monthPart;
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();

        doneBtn.click();
    }


    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public boolean isUserIsOnFlightListingPage() {
        dismissBtn.click();
        return !flightList.isEmpty();
    }

    public void userClickOnFirstFlight() {
        flightList.getFirst().click();
    }

    public void userClicksOnBookNowBtn() {
        bookNowBtn.click();
    }

    public void printPriceAndClicksContinue() {
        System.out.println("Flight Ticket price: " + ticketPrice.getText());
        continueBtn1.click();
        pause(5000);
//        wait.until(ExpectedConditions.visibilityOf(continueBtn2));
        continueBtn2.click();
    }

    public void userEntersTravellerDetails(String gender, String firstName, String lastname) {
        pause(3000);
        addNewAdultBtn.click();
        WebElement genderEle = driver.findElement(By.xpath(String.format("//android.widget.TextView[@text=\"%s\"]", gender)));
        genderEle.click();
        WebElement firstNameEle = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.makemytrip:id/et_passport_number\" and @text=\"First & Middle Name\"]"));
        firstNameEle.click();
        firstNameEle.sendKeys(firstName);
        System.out.println("clicked first name");
        WebElement lastNameEle = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.makemytrip:id/et_passport_number\" and @text=\"Last Name\"]"));
        lastNameEle.click();
        lastNameEle.sendKeys(lastname);
        System.out.println("clicked last name");
        adultConfirmBtn.click();
        continueBtn2.click();
        unSecureBtn.click();
        yesPleaseBtn.click();
        continueBtn2.click();
        System.out.println("Flight ticket price after selecting seat: " + ticketPriceAfterSeat.getText());
        continueBtn2.click();
        continueBtn2.click();
        confirmContinueBtn.click();
        pause(3000);
    }

    public void printConfirmedFlightDetails() {
        System.out.println("****************** Flight Booking Details ******************");
        System.out.println(titleOfTicket.getText());
        System.out.println(timingInTicket.getText());
        System.out.println("Final Price: " + finalPriceInTicket.getText());
        System.out.println("**********************************************************");
    }

    public void selectFilterOption(String filterOption) {
        filterBtn.click();
        scrollPageForFlightPage();
        WebElement flightName = driver.findElement(By.xpath("(//android.widget.TextView[@text='" + filterOption + "'])[1]"));
        flightName.click();
        applyBtn.click();
        pause(3000);
    }

    public boolean isFlightListingDisplayedWithFilter(String filterValue) {

        String prevFlightTime = "";

        while (true) {
            List<WebElement> flightTitle = driver.findElements(By.xpath("(//android.widget.TextView[@resource-id=\"com.makemytrip:id/airline_name\"])"));
            List<WebElement> flightTime = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_dep_time\"]"));
            List<WebElement> flightPrice = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.makemytrip:id/tv_final_fare']"));

            if (flightTime.isEmpty() || flightPrice.isEmpty()) {
                break;
            }

            String currentFlightTime = flightTime.getFirst().getText();

            if (currentFlightTime.equals(prevFlightTime)) {
                break;
            }

            for (int i = 0; i < flightTitle.size(); i++) {
                System.out.println("Flight Name: " + flightTitle.get(i).getText());
                System.out.println("Flight departure time: " + flightTime.get(i).getText());
                System.out.println("Flight Price: " + flightPrice.get(i).getText());
                currentFlightTime = flightTime.get(i).getText();
            }
            scrollPageForFlightPage();
            prevFlightTime = currentFlightTime;

        }
        System.out.println("scrolled");
        return true;
    }

    public void selectSortOption(String sortOption) {
        filterBtn.click();
        sortByTab.click();
        WebElement sortType = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_heading\" and @text='" + sortOption + "']"));
        sortType.click();
        applyBtn.click();
    }

    public boolean isFlightListingDisplayedWithSort(String configValue) {
        boolean filterApplied = false;
        String prevFlightTime = "";
        int prevFlightPrice = 0;  // Initialize as an integer

        while (true) {
            List<WebElement> flightTitle = driver.findElements(By.xpath("(//android.widget.TextView[@resource-id=\"com.makemytrip:id/airline_name\"])"));
            List<WebElement> flightTime = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.makemytrip:id/tv_dep_time\"]"));
            List<WebElement> flightPrice = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.makemytrip:id/tv_final_fare']"));

            // Check if we have flight information
            if (flightTime.isEmpty() || flightPrice.isEmpty()) {
                break;  // Exit if no flights are found
            }

            String currentFlightTime = flightTime.getFirst().getText();
            String currentFlightPriceText = flightPrice.getFirst().getText();

            // Remove non-numeric characters and convert the price to an integer
            int currentFlightPrice = Integer.parseInt(currentFlightPriceText.replaceAll("[^0-9]", ""));

            // Compare the current flight price with the previous price
            if (currentFlightTime.equals(prevFlightTime) && currentFlightPrice == prevFlightPrice) {
                filterApplied = true;
                break;  // Exit the loop if the price hasn't changed and time matches
            }

            // Loop through flight details if you want to print them
            for (int i = 0; i < flightTime.size(); i++) {
                System.out.println("Flight Name: " + flightTitle.get(i).getText());
                System.out.println("Flight departure time: " + flightTime.get(i).getText());
                System.out.println("Flight Price: " + flightPrice.get(i).getText());
            }

            // Scroll and continue checking
            scrollPageForFlightPage();

            // Update previous time and price
            prevFlightTime = currentFlightTime;
            prevFlightPrice = currentFlightPrice;  // Update the previous price for the next iteration
        }

        return filterApplied;
    }
}
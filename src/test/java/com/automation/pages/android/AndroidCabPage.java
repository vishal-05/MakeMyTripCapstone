package com.automation.pages.android;

import com.automation.pages.ui.CabPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidCabPage extends AndroidBasePage implements CabPage {
    @FindBy(xpath = "//android.widget.TextView[@text=\"Cab Search\"]")
    WebElement cabSearchPageTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='ENTER PICK UP ADDRESS']")
    WebElement pickUpAddressSearchBar;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter pick up address']")
    WebElement pickUpAddressInput;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='test-id'])[9]/android.view.ViewGroup[1]")
    WebElement selectFirstResult;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter drop address']")
    WebElement dropAddressInput;

    @FindBy(xpath = "//android.widget.TextView[@text='TRIP START']")
    WebElement dateBox;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.makemytrip:id/pickerWrapper']/android.widget.NumberPicker[1]/android.widget.Button[2]")
    WebElement nextDateBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='CONFIRM']")
    WebElement confirmDateBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='SEARCH']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    WebElement continueBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Rates for 10 Kms approx distance | 1 hr(s) approx time']/following-sibling::android.view.ViewGroup")
    List<WebElement> cabTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Full Pay']")
    WebElement fullPayRadioBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='PAY NOW']")
    WebElement payNowBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='title']/following-sibling::android.widget.TextView[2]")
    WebElement travellerName;

    @FindBy(xpath = "//android.widget.TextView[@text='Total Due']/following-sibling::android.widget.TextView")
    WebElement totalFare;

    @FindBy(xpath = "//android.widget.TextView[@text='Coupon & Offers']")
    WebElement couponsTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Inclusions/Exclusions']")
    WebElement featuresTitle;

    public boolean isUSerOnCabPage() {
        pause(3000);
        return cabSearchPageTitle.isDisplayed();
    }

    public void enterCabDetails(String pickUpAddress, String dropAddress) {
        pickUpAddressSearchBar.click();
        pickUpAddressInput.sendKeys(pickUpAddress);
        selectFirstResult.click();
        dropAddressInput.sendKeys(dropAddress);
        selectFirstResult.click();
    }

    public void enterCabDate(String date) {
        pause(3000);

        dateBox.click();
        System.out.println("clicked tab date");
        WebElement currentDate = driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.makemytrip:id/pickerWrapper']/android.widget.NumberPicker[1]/android.widget.EditText"));
        System.out.println(currentDate.getText());
        String expDate = getFormattedDate("E dd MMM", date, "dd/MM/yyyy");
        System.out.println(expDate);
        while (!expDate.equals(currentDate.getText())) {
            System.out.println(currentDate.getText());
            System.out.println(expDate);
            nextDateBtn.click();
        }
        pause(2000);
        confirmDateBtn.click();
    }

    public void clickSearchCabsBtn() {
        searchBtn.click();
        pause(3000);

    }

    public boolean isUserIsOnCabListingPage() {
        pause(5000);
        continueBtn.click();
        return !cabTab.isEmpty();
    }


    public void userClicksOnFirstCab() {
        cabTab.getFirst().click();
    }

    public void userEntersTravellerDetails(String gender) {
        int x = couponsTitle.getLocation().getX();
        int y = couponsTitle.getLocation().getY();
        int width = couponsTitle.getSize().getWidth();
        int height = featuresTitle.getLocation().getX();


        scroll(x+(width/2), y, x+(width/2), height);
        System.out.println("scrolled");
        String formattedGender = gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
        WebElement genderBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='" + formattedGender + "']/android.view.ViewGroup"));
        genderBtn.click();
    }


    @Override
    public void selectFullPayAndPayNow() {
        fullPayRadioBtn.click();
        pause(2000);
        payNowBtn.click();
        pause(5000);
    }

    @Override
    public boolean verifyTravellerName() {
        System.out.println(travellerName.getText());
        System.out.println(ConfigReader.getConfigValue("passenger.firstName").toLowerCase());
        return travellerName.getText().contains(ConfigReader.getConfigValue("passenger.firstName").toLowerCase());
    }

    @Override
    public void printTotalFare() {
        System.out.println("Total fare for the cab: " + totalFare.getText());
    }
}

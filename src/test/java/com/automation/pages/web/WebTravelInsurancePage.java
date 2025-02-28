package com.automation.pages.web;

import com.automation.pages.ui.TravelInsurancePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTravelInsurancePage extends WebBasePage implements TravelInsurancePage {

    @FindBy(xpath = "//span[@data-test-id='FormattedText' and contains(text(),'Medical Insurance')]")
    WebElement insuranceText;

    @FindBy(xpath = "//div[@data-test-id='PopularCountryComp-OtherCountyBtn']")
    WebElement otherCountryTab;

    @FindBy(id = "Search Country/Region")
    WebElement searchCountryInputField;

    @FindBy(xpath = "//p[@class=\"TextStylesstyle__ParaTagStyle-sc-1ci0hiy-5 gJuhyk\"]")
    List<WebElement> listOfCountries;

    @FindBy(xpath = "//span[normalize-space()='Add Destination']")
    WebElement addToDestinationBtn;

    @FindBy(xpath = "//div[@class='TravellingToWidgetstyle__TravelDateWigetStyle-sc-56hbau-4 hWDRGv']")
    WebElement travelDateTab;

    @FindBy(xpath = "(//b[@data-test-id='DatePickerComp-monthNameFormatter-b'])[1]")
    WebElement monthName;

    @FindBy(xpath = "//button[@aria-label='Go to next month']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//div[@class='TravellingToWidgetstyle__TravellerCountWigetStyle-sc-56hbau-2 MUdBP']")
    WebElement travellerAgeTab;

    @FindBy(xpath = "//span[@class='TextStylesstyle__SpanTagStyle-sc-1ci0hiy-6 jyjFpu']")
    WebElement selectAgeTab;

    @FindBy(xpath = "//div[@class='TravellingToWidgetstyle__AgeSelectItem-sc-56hbau-23 hArtey']//span//span")
    List<WebElement> travellerAgeList;

    @FindBy(xpath = "(//span[@class='TextStylesstyle__SpanTagStyle-sc-1ci0hiy-6 ebYDaw'])[1]")
    WebElement applyBtnAndViewPlansBtn;

    @FindBy(xpath = "(//div[@class='TravelDetailsstyle__CountryImg-sc-4x930j-6 eBaZCZ'])[1]")
    WebElement imgCountry;

    @FindBy(xpath = "//div[@class='choose-plan']")
    WebElement choosePlanElement;

    @FindBy(xpath = "//div[@class='title mmt-acc-tab']//div")
    List<WebElement> listOfSumInsured;

    @FindBy(xpath = "//div[@class='plan-price']")
    List<WebElement> listOfCostPerPerson;

    @FindBy(xpath = "//div[@class='name name-trim']")
    List<WebElement> listOfPlanTitles;

    @FindBy(xpath = "//div[@class='plan-benefits']")
    List<WebElement> listOfPlanBenefits;

    public boolean isUserIsOnTravelInsurancePage(){
        return isPresent(insuranceText);
    }

    public void selectDestinationCountry(String countryName){
        otherCountryTab.click();
        searchCountryInputField.sendKeys(countryName);
        pause(2000);
        for (WebElement countryElement : listOfCountries){
            System.out.println(countryElement.getText());
            if(countryElement.getText().contains(countryName)){
                countryElement.click();
                break;
            }
        }
    }

    public void clicksOnAddToDestinationBtn(){
        addToDestinationBtn.click();
    }

    public void selectTravelDatesForInsurance(String startDate, String endDate){
        travelDateTab.click();

        String expMonth = getFormattedDate("MMMM", startDate, "dd/MM/yyyy");
        pause(4000);
        String actMonth = monthName.getText();
        while (!expMonth.contains(actMonth)) {
            System.out.print(actMonth);
            System.out.print(expMonth);
            nextMonthBtn.click();
            pause(1000);
            actMonth = monthName.getText();
        }

        String dateValue = getFormattedDate("d", startDate, "dd/MM/yyyy");
        System.out.println(dateValue);
        WebElement startDateElement = driver.findElement(By.xpath(String.format("(//button[@class='rdp-button_reset rdp-button rdp-day' and contains(text(),'%s')])[1]",dateValue)));
        startDateElement.click();

        expMonth = getFormattedDate("MMMM", endDate, "dd/MM/yyyy");
        pause(4000);
        actMonth = monthName.getText();
        while (!expMonth.contains(actMonth)) {
            System.out.print(actMonth);
            System.out.print(expMonth);
            nextMonthBtn.click();
            pause(1000);
            actMonth = monthName.getText();
        }

        dateValue = getFormattedDate("d", endDate, "dd/MM/yyyy");
        WebElement endDateElement = driver.findElement(By.xpath(String.format("(//button[@class='rdp-button_reset rdp-button rdp-day' and contains(text(),'%s')])[1]",dateValue)));
        endDateElement.click();
    }

    public void selectTravellerAge(String travellerAge){
        travellerAgeTab.click();
        selectAgeTab.click();
        int ageInt = Integer.parseInt(travellerAge);
        for (WebElement ageListElement : travellerAgeList){
            String numberString = ageListElement.getText().replaceAll("[^0-9]", "");
            int number = Integer.parseInt(numberString.substring(0, 2));
            System.out.println(number);
            if(ageInt>number && ageInt<=(number+10)){
                ageListElement.click();
                break;
            }
        }
        pause(2000);
        applyBtnAndViewPlansBtn.click();
    }

    public void clicksOnViewPlansBtn(){
        imgCountry.click();
        pause(2000);
        imgCountry.click();
        applyBtnAndViewPlansBtn.click();
    }

    public boolean isUserIsOnChoosePlanWindow(){
        switchToNewTab();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToNewTab();
        pause(10000);
        return isPresent(choosePlanElement);
    }

    public void printAllDisplayedPlans(){
        System.out.println("***************** Travel Insurance Plans *****************");
        for (int i=0;i< listOfSumInsured.size();i++){
            System.out.println(listOfSumInsured.get(i).getText());
            System.out.println(listOfPlanTitles.get(i).getText());
            System.out.println("Cost: "+listOfCostPerPerson.get(i).getText());
            System.out.println(listOfPlanBenefits.get(i).getText());
            System.out.println("******************************************************");


        }


    }
}

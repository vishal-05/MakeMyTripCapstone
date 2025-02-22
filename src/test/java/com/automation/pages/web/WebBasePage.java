package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class WebBasePage {
    public WebDriver driver;
    WebDriverWait wait;

    public WebBasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isPresent(WebElement element) {
        try {
            pause(1000);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void pause(long milliSec) {
        try {
            Thread.sleep(milliSec);
            System.out.println("waited");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFormattedDate(String expectedFormat, String date, String currentDateFormat) {
        try {
            SimpleDateFormat currentFormatter = new SimpleDateFormat(currentDateFormat);
            Date dateObject = currentFormatter.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObject);

            SimpleDateFormat expectedFormatter = new SimpleDateFormat(expectedFormat);
            return expectedFormatter.format(calendar.getTime());
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format " + expectedFormat);
        }
    }

    public void switchToNewTab() {
        String currentWindowHandle = driver.getWindowHandle();

        // Wait for the new tab to open
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to the new tab (it will be the one that's not the current one)
        for (String handle : allWindowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

}

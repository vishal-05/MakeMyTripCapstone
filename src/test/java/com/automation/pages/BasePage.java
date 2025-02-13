package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;
    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void pause(long milliSec) {
        try {
            Thread.sleep(milliSec);
            System.out.println("waited");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebBasePage {
    public WebDriver driver;
    WebDriverWait wait;
    public WebBasePage() {
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

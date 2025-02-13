package com.automation.pages.android;

import com.automation.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidBasePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public AndroidBasePage() {
        driver = (AndroidDriver) DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
}

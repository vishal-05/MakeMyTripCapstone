package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.makemytrip:id/skipTextView\"]")
    WebElement skipBtn;

    public void openApplication(){
        skipBtn.click();

    }
}

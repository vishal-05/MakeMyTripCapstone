package com.automation.pages.web;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;

public class WebHomePage extends WebBasePage implements HomePage {
    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
}

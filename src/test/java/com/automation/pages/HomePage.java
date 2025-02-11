package com.automation.pages;

import com.automation.utils.ConfigReader;

public class HomePage extends BasePage{
    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
}

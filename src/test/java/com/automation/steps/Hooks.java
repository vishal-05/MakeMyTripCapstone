package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {

    @Before("@web or @android")
    public void setUpForWebOrAndroid(Scenario scenario) {
        ConfigReader.initConfig();
        ExtentReportManager.initReporter(scenario);
        DriverManager.createDriver();
    }

    @Before("@api")
    public void setUpForAPI() {
        ConfigReader.initConfig();
        RestAssured.baseURI = ConfigReader.getConfigValue("api.url");
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After
    public void cleanUp(Scenario scenario) {
        // Only quit the driver if the scenario is not related to API tests
        if (!scenario.getSourceTagNames().contains("@api")) {
            try {
                scenario.attach(DriverManager.takeScreenShotAsBytes(), "image/png", scenario.getName());
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
            DriverManager.getDriver().quit();
        }
    }
}

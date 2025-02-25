package com.automation.utils;

import io.cucumber.java.Scenario;

public class ExtentReportManager {

    static Scenario scenario;

    public static void initReporter(Scenario scenario){
        ExtentReportManager.scenario = scenario;
    }

    public static void attachScreenshot(){
        scenario.attach(DriverManager.takeScreenShotAsBytes(), "image/png", scenario.getName());
    }

}

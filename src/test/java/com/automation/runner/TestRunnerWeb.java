package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/WebTravelInsurance.feature",
        glue = "com.automation.steps",
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@web"
)
public class TestRunnerWeb {
}

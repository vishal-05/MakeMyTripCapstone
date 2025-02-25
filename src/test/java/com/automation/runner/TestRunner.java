package com.automation.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.steps",
        plugin = {"pretty",
                "json:test-output/cucumber.json",
                "html:test-output/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@web"
)
public class TestRunner {

}

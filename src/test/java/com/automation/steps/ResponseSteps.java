package com.automation.steps;

//import com.automation.pojo.CreateUserPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseSteps {
    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode){
        Assert.assertEquals(statusCode, RestAssuredManager.getStatusCode());
        System.out.println("Status Code: "+RestAssuredManager.getStatusCode());
    }

    @And("verify response body has a field {string}")
    public void verifyResponseBodyHasAField(String fieldName) {
        Assert.assertTrue(RestAssuredManager.isFieldAvailable(fieldName));

    }

    @And("store {string} from response to {string}")
    public void storeInto(String jsonPath, String configKey) {
        String value = RestAssuredManager.getResponseFieldValue(jsonPath);
        ConfigReader.setConfigValue(configKey, value);

    }
}
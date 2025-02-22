package com.automation.steps;

import com.automation.pojo.CreateOrderPojo;
import com.automation.pojo.CreatePetPojo;
import com.automation.pojo.CreateUserPojo;
import com.automation.pojo.LoginUserPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void user_wants_to_call_endPoint(String endPoint) {
        RestAssuredManager.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredManager.setHeader(key, value);
    }

    @Given("set request body from file {string} with type {string}")
    public void set_request_body_from_file(String filePath, String pojoType) throws Exception {
        String content = RestAssuredManager.getDataFromJsonFile(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        if ("CreatePet".equalsIgnoreCase(pojoType)) {
            CreatePetPojo petPojo = objectMapper.readValue(content, CreatePetPojo.class);
            RestAssuredManager.setBody(petPojo);
            ConfigReader.setProperty("request_pojo", content);
        } else if ("CreateOrder".equalsIgnoreCase(pojoType)) {
            CreateOrderPojo orderPojo = objectMapper.readValue(content, CreateOrderPojo.class);
            RestAssuredManager.setBody(orderPojo);
            ConfigReader.setProperty("request_pojo", content);
        } else if ("CreateUser".equalsIgnoreCase(pojoType)) {
            CreateUserPojo createUserPojo = objectMapper.readValue(content, CreateUserPojo.class);
            RestAssuredManager.setBody(createUserPojo);
            ConfigReader.setProperty("request_pojo", content);
        } else if ("LoginUser".equalsIgnoreCase(pojoType)) {
            LoginUserPojo loginUserPojo = objectMapper.readValue(content, LoginUserPojo.class);
            RestAssuredManager.setBody(loginUserPojo);
            ConfigReader.setProperty("request_pojo", content);
        } else {
            throw new IllegalArgumentException("Unsupported POJO type: " + pojoType);
        }
    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredManager.post();
    }

    @When("user performs put call")
    public void user_performs_put_call() {
        RestAssuredManager.put();
    }

    @When("user performs delete call")
    public void user_performs_delete_call() {
        RestAssuredManager.delete();
    }

    @When("user performs get call")
    public void user_performs_get_call() {
        RestAssuredManager.get();
    }

}
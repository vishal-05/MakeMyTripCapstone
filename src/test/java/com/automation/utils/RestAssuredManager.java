package com.automation.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RestAssuredManager {

    static RequestSpecification requestSpecification = RestAssured.given();
    static Response response;
    static String endPoint;

    public static void setEndPoint(String endPoint){
        RestAssuredManager.endPoint = endPoint;
    }

    public static void setHeader(String key, String value){
        requestSpecification.header(key,value);
    }

    public static void setBody(Object pojo){
        try {
            requestSpecification.body(pojo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void get(){
        requestSpecification.log().all();
        response = requestSpecification.get(endPoint);
        response.then().log().all();
    }

    public static void post(){
        requestSpecification.log().all();
        response = requestSpecification.post(endPoint);
        response.then().log().all();
    }

    public static void put(){
        requestSpecification.log().all();
        response = requestSpecification.put(endPoint);
        response.then().log().all();
    }
    public static void delete(){
        requestSpecification.log().all();
        response = requestSpecification.delete(endPoint);
        response.then().log().all();
    }

    public static int getStatusCode(){
        return response.getStatusCode();
    }

    public static String getDataFromJsonFile(String fileName) throws FileNotFoundException {
        String jsonFolderPath = "src/test/resources/jsonData/";
        Scanner sc = new Scanner(new FileInputStream(jsonFolderPath + fileName));
        return sc.useDelimiter("\\Z").next();
    }

    public static String getFieldDataFromJsonFile(String fileName, String fieldName) throws IOException {
        String jsonFolderPath = "src/test/resources/jsonData/";
        File file = new File(jsonFolderPath + fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        System.out.println(jsonNode.get(fieldName).asText());
        return jsonNode.get(fieldName).asText();

    }

    public static String getResponseFieldValue(String jsonPath){
        return response.jsonPath().getString(jsonPath);
    }

    public static boolean isFieldAvailable(String fieldName) {
        try{
            String value = RestAssuredManager.getResponseFieldValue(fieldName);
            System.out.println(value);
            return value!=null && !value.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public static void clear() {
        requestSpecification = RestAssured.given();
    }
}


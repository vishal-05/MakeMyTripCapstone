package com.automation.steps;

import com.automation.pages.android.*;
import com.automation.pages.ui.*;
import com.automation.pages.web.*;

public class BaseStep {

    HomePage homePage;
    LoginPage loginPage;
    FlightPage flightPage;
    HotelPage hotelPage;
    BusPage busPage;
    public BaseStep() {
        if (System.getProperty("platform").equals("web")) {
             homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            flightPage = new WebFlightPage();
            hotelPage = new WebHotelPage();
            busPage = new WebBusPage();
        } else {
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            flightPage = new AndroidFlightPage();
            hotelPage = new AndroidHotelPage();
            busPage = new AndroidBusPage();
        }
    }
}

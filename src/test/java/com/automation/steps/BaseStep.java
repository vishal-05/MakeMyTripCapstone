package com.automation.steps;

import com.automation.pages.android.AndroidFlightPage;
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidHotelPage;
import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.FlightPage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.ui.HotelPage;
import com.automation.pages.ui.LoginPage;
import com.automation.pages.web.WebFlightPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebHotelPage;
import com.automation.pages.web.WebLoginPage;

public class BaseStep {

    HomePage homePage;
    LoginPage loginPage;
    FlightPage flightPage;
    HotelPage hotelPage;
    public BaseStep() {
        if (System.getProperty("platform").equals("web")) {
             homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            flightPage = new WebFlightPage();
            hotelPage = new WebHotelPage();
        } else {
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            flightPage = new AndroidFlightPage();
            hotelPage = new AndroidHotelPage();
        }
    }
}

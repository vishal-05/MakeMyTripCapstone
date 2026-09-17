# MakeMyTrip Capstone – Automation Framework

End-to-end test automation suite for [MakeMyTrip](https://www.makemytrip.com/), built with **Java, Selenium WebDriver, Appium, Cucumber (BDD) and Rest Assured**. Covers Web UI, Android app, and API test flows using the Page Object Model, with Extent Reports for reporting.

## Tech Stack

- **Java 21**, Maven
- **Selenium WebDriver 4.x** – Web UI automation
- **Appium (Java client) 8.x** – Android app automation
- **Cucumber 7.x + JUnit 4** – BDD test runner
- **Rest Assured** – API testing
- **Apache POI** – Excel-driven test data
- **ExtentReports** (+ Cucumber adapter) – HTML reporting
- **Lombok**, **Jackson**

## Project Structure

```
src/test/java/com/automation/
├── runner/      # Cucumber JUnit runners (Web, Android)
├── steps/       # Cucumber step definitions
├── pages/       # Page Objects (web/, android/)
├── pojo/        # Request/response POJOs for API tests
└── utils/       # Driver, config, report & Rest Assured managers

src/test/resources/
├── features/    # Cucumber .feature files (incl. features/api)
├── config/      # config.properties (env/test data)
├── apk/         # MakeMyTrip Android app under test
├── excelSheet/  # Data-driven test inputs
└── jsonData/    # API request payloads & schemas
```

## Test Coverage

- **Web:** Login, flight/hotel/bus/cab booking, currency conversion, travel insurance, data-driven login
- **Android:** Login, flight booking & filters, cab/bus booking, zoom gestures
- **API:** User CRUD, login/logout, order creation, pet creation (Swagger Petstore)

## Prerequisites

- JDK 21
- Maven
- Chrome/Chromium (for Web tests)
- Appium Server + Android SDK/emulator or connected device (for Android tests)

## Configuration

Update `src/test/resources/config/config.properties` with your target URLs, device name, and test data (dates, cities, credentials, etc.) before running.

## Running Tests

Tests are split into Maven profiles by platform, driven by Cucumber tags:

```bash
# Web tests (@web tag, WebTravelInsurance.feature by default)
mvn test -Pweb

# Android tests (@android tag, FlightBooking.feature by default)
mvn test -Pandroid
```

> To run a different feature/tag set, edit `features`/`tags` in the relevant class under `src/test/java/com/automation/runner/`.

## Reports

- Cucumber HTML/JSON reports: `target/cucumber.html`, `target/cucumber.json`
- ExtentReports: generated via `extent.properties`
- Consolidated Cucumber reports: `CucumberReport/WebCucumberReport` and `CucumberReport/AndroidCucumberReport`

## Disclaimer

This is a capstone/learning project for practicing automation testing patterns and is not affiliated with MakeMyTrip.

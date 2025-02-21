package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver(){
        if(System.getProperty("platform").equals("web")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (System.getProperty("platform").equals("mobile")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("app", System.getProperty("user.dir") + ConfigReader.getConfigValue("app.path"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
         //   capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
         //   capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
            driver = new AndroidDriver(capabilities);
        }else {
            throw new RuntimeException("'platform' parameter value can be web or mobile");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver(){
        return driver;
    }


    public static void writeToExcel(String country, String currency, String amount, String amtRupees) {
        String filePath = "src/test/resources/excelSheet/CurrencyDataDriven.xlsx";
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        XSSFWorkbook workbook;
        XSSFSheet sheet;

        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheet("CurrencyData");
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("CurrencyData");

                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Country_Name");
                headerRow.createCell(1).setCellValue("Currency");
                headerRow.createCell(2).setCellValue("Amount");
                headerRow.createCell(3).setCellValue("Amount_In_Rupees");
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(rowCount);


            Cell cell0 = row.createCell(0);
            cell0.setCellValue(country);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(currency);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(amount);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(amtRupees);

            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                workbook.write(outputStream);
                System.out.println("Data written to Excel successfully");
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}






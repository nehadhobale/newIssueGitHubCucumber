package com.restar.testCases;

import com.restar.pages.*;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;


import java.time.Duration;
import java.util.Properties;

public class BaseTestClass {

    public WebDriver driver;
    Properties properties;
    LoginPage login;
    DashboardPage dashboard;
    RepositoriesPage repo;
    ProjectPage project;
    IssuePage issuePage;


    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        repo = new RepositoriesPage(driver);
        project = new ProjectPage(driver);
        issuePage = new IssuePage(driver);
    }
    @AfterSuite
    public void cleanUp(){
        driver.quit();
    }

}

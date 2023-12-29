package com.restar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

//Locators
    private By username =By.xpath("//input[@id='login_field']");
    private By password =By.xpath("//input[@id='password']");
    private By signIn =By.xpath("//input[@name='commit']");

    public void doLogin(String userid,String pass){
        driver.get("https://github.com/login");
        driver.manage().window().maximize();
        driver.findElement(username).sendKeys(userid);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signIn).click();
    }
}

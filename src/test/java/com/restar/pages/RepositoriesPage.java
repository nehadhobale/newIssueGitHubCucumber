package com.restar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoriesPage {
    WebDriver driver;
    public RepositoriesPage(WebDriver driver){
        this.driver  = driver;
    }
    //Locators
    By search = By.xpath("//input[@id='your-repos-filter']");
    By project = By.xpath("(//li[@itemprop='owns'])[1]//h3/a");


    public void doSearch(String projectName){
        //Providing repository name
        driver.findElement(search).sendKeys(projectName);
        //click on first repository
        driver.findElement(project).click();
    }

}

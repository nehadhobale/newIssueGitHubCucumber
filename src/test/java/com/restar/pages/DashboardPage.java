package com.restar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    //Locatores
    private By userProfileIcon =By.xpath("(//img[@class='avatar circle'])[1]");
    private By repositories=By.xpath("//li[@class='ActionListItem']/a/span[2][text()[normalize-space()='Your repositories']]");

    public void openRepositories(){
        //Used to open User Profile
        driver.findElement(userProfileIcon).click();
        //Clicked on Your repositories
        driver.findElement(repositories).click();

    }

}

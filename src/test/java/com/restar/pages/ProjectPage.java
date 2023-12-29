package com.restar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {

    WebDriver driver;


    public  ProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By issue = By.xpath("//a[@id='issues-tab']");
    By newIssue = By.xpath("//span[@class='d-none d-md-block']");
    By title = By.xpath("//input[@id='issue_title']");
    By comment = By.xpath("//textarea[@id='issue_body']");
    By submit = By.xpath("//div[@class='flex-items-center flex-justify-end d-none d-md-flex mx-2 mb-2 px-0']/button");

    public void createNewIssue(String issueTitle,String issueComment){
        //click on the issue tab
        driver.findElement(issue).click();
        //create new issue
        driver.findElement(newIssue).click();
        //give title
        driver.findElement(title).sendKeys(issueTitle);
        //give comment
        driver.findElement(comment).sendKeys(issueComment);
        //click on submit
        driver.findElement(submit).click();
    }

}

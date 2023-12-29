package com.restar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuePage {
    WebDriver driver;

    public IssuePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By issueGenerate = By.xpath("//bdi[@class='js-issue-title markdown-title']");
    By openIssue = By.xpath("(//span[@title='Status: Open'])[1]");

    public String getIssueTitle() {
        //give issue title
        return driver.findElement(issueGenerate).getText();
    }

    public Boolean verifyOpenStatus() {
        //give count of open new issue
        return driver.findElements(openIssue).size() > 0;
    }


}

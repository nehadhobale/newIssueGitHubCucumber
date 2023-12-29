package com.restar.testCases;

import com.restar.utility.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewIssueTest extends BaseTestClass {

    NewIssueTest(){
        this.properties = Utils.getProperties("NewIssueTest");
    }

    @Test
    public void verify_newIssue_functionality() {
        login.doLogin(Utils.decode(properties.getProperty("username")), Utils.decode(properties.getProperty("password")));
        dashboard.openRepositories();
        repo.doSearch("reStarTestRepo");
        String issueTitle = "Issue" + Utils.generateIssueNumber();
        project.createNewIssue(issueTitle, "New issue is created");
        Assert.assertEquals(issueTitle, issuePage.getIssueTitle(), "Issue Title is not matching");
        Assert.assertTrue(issuePage.verifyOpenStatus(), "Issue is not opened");
    }
}

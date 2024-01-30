package com.gitcucumber.stepdef;

import com.restar.pages.*;
import com.restar.testCases.BaseTestClass;
import com.restar.utility.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Properties;

public class NewIssueStep  {
    Properties properties;
    WebDriver driver;


//    NewIssueStep() {
//        this.properties = Utils.getProperties("NewIssueTest");
//    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Given("Open GitHub Application")
    public void open_git_hub_application() {
        driver.get("https://github.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("Entered the valid UserId {string} and password {string}")
    public void entered_the_valid_user_id_and_password(String loginId, String password) {
        LoginPage login = new LoginPage(driver);
        login.doLogin(loginId,password);
    }

    @When("Click on the user profile")
    public void click_on_the_user_profile() {
        DashboardPage dash = new DashboardPage(driver);
        dash.openRepositories();
    }

    @When("Search repository {string}")
    public void search_repository(String repoName) {
        RepositoriesPage repo = new RepositoriesPage(driver);
        repo.doSearch(repoName);
    }

    @Then("New Issue Should be created")
    public void new_issue_should_be_created() {
        ProjectPage project = new ProjectPage(driver);
        IssuePage issuePage =  new IssuePage(driver);
        String issueTitle = "Issue" + Utils.generateIssueNumber();
        project.createNewIssue(issueTitle, "New issue is created");
        Assert.assertEquals(issueTitle, issuePage.getIssueTitle(), "Issue Title is not matching");
        Assert.assertTrue(issuePage.verifyOpenStatus(), "Issue is not opened");
    }
    @After
    public void end(){
        driver.quit();
    }

}

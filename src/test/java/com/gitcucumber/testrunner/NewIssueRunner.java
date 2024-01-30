package com.gitcucumber.testrunner;


import io.cucumber.testng.*;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/featureFile/GitHubNewIssue.feature",
                 glue="com/gitcucumber/stepdef"
//                 tags = "@EnterValidId"
)
public class NewIssueRunner extends AbstractTestNGCucumberTests {
}

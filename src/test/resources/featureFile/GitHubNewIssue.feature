Feature: Test New Issue GitHub Functionality

  Background:
    Given Open GitHub Application

  #@EnterValidId
  Scenario:  Test New Issue functionality
    When Entered the valid UserId "nehadhobale" and password "GitHub@09876"
    And Click on the user profile
    And Search repository "newIssueGitHubCucumber"
    Then New Issue Should be created

@component:Client_tests
Feature: Goal feature setup - Home page
  As a pms user
  I can add and modify my goals

  Background:
    Given I launch the PMS application
    Then I click on LogIn with Google option
    And I Provide UserName and Click on Next button
    And I provide Password and Click on Next Button
    Then User should be Login Successfully on PMS


  Scenario: Verify the validation fields on goal form
    When I click on add goal button
    When I click on Submit for review button
    Then I will verify that goal title field showing validation message
    And  I will verify Goal field showing validation message
    And SubCategory field showing validation message
    And Weightage field showing validation message

  Scenario: Goal Submission negative
    When I click on add goal button
    Then I enter Goal Title
    Then I Enter Goal fields with Weightage value "25"
    When I click on Submit for review button
    Then I see a Validation message for Weightage

  Scenario: Goal Submission positive
    When I click on add goal button
    Then I enter Goal Title
    Then I Enter Goal fields with Weightage value "16"
    Then I click on save Draft button
    Then I click on Draft button
    Then I click on Goal Title HyperLink
    Then I click on Edit Goal Button
    When I click on Submit button
    Then Goal Should be Submitted Successfully





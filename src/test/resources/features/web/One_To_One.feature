@component:Client_tests
Feature: one to one feature setup - Home page
  As a pms user
  I can add one to one with my Reporting Manager


  Background:
    Given I launch the PMS application
    Then I click on LogIn with Google option
    When I provide "abhineet.kumar@successive.tech" and "abhineet@1666"
    Then I should be on goal page and verity all the components on that page
    And I verify the options in left panel

  Scenario: Verify the validations fields on one to one page
    When I click on one to one module
    Then I verify that the user landing on one to one module
    Then I click on add one to one button
    Then I verify that the calender functionality is disable
    And I verify the validation on mandatory fields


  Scenario: Verify that user adding note successfully
    When I click on one to one module
    Then I verify that the user landing on one to one module
    Then I click on add one to one button
    Then I Enter Notes Title "TestNote"
    And  I Enter Notes In Notes Section "one to one Notes"
   When I click on Submit for review button On Notes Button
    Then I verify the onetoone submitted successfully with title "TestNote" and status "Pending Approval"


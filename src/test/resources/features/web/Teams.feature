@component:Client_tests
Feature: Profile feature setup - Team page
  As a pms user(BUH)
  User can see the allocated team for him/her


  Background:
    Given I launch the PMS application
    Then I click on LogIn with Google option
    When I provide "butestuser@successivesoftwares.com" and "8802420232"
#    Then I should be on goal page and verity all the components on that page
#    And I verify the options in left panel


Scenario: Verify the Team section
  Given I click on Team Module
  Then I will verify that user landed on Team page
  Then I will verify that Direct Reporting and BU Team options are available
  Then I verify the name of Team Head from Direct Reporting section
  And verify the table columns from BU Team

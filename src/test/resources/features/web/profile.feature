@component:Client_tests
Feature: Profile feature setup - Profile page
  As a pms user
  User can see the profile


  Background:
    Given I launch the PMS application
    Then I click on LogIn with Google option
    When I provide "abhineet.kumar@successive.tech" and "abhineet@1666"
    Then I should be on goal page and verity all the components on that page
    And I verify the options in left panel



    Scenario: Verify the profile page with employee details
      When I click on profile page
      Then I verify that the user is on profile page
      And I verify All the details of that employee from top section
      And I verify all the details of that employee from middle section
      And I verify all the details of that employee from bottom section
@component:Client_tests
Feature: Login feature setup - Landing page
  As a pms user
  I can land on welcome pms page
  so that I can access different different modules.

  Scenario Outline: Check login feature for invalid username
    Given I launch the PMS application
    Then I click on LogIn with Google option
    When I provide "<email>"
    Then I should get "<message>"
    Examples:
      | email | message                        |
      |       | Enter an email or phone number |

  Scenario Outline: Checks login feature for invalid combination of passwords
    Given I launch the PMS application
    Then I click on LogIn with Google option
    When I provide "<email>" and "<pwd>"
    Then I should get "<message>"
    Examples:
      | email                          | pwd           | message                                                         |
      | archana.sharma@successive.tech |               | Enter a password                                                |
      | abhineet.kumar@successive.tech | abhineet1666  | Wrong password. Try again or click Forgot password to reset it. |


  Scenario: Verify the home page
    Given I launch the PMS application
    Then I click on LogIn with Google option
    When I provide "abhineet.kumar@successive.tech" and "abhineet@1666"
#    Then I should be on goal page and verity all the components on that page
#    And I verify the options in left panel




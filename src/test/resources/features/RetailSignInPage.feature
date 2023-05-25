@RetailSigIn/SignUpFeatures
Feature: Sign in/Sign Up Features

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @SignInRetail
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'jason5@gmail.com' and password 'Canada@1234'
    And User click on login button
    Then User should be logged in into Account

  @CreateAccountRetail
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name  | email            | password        | confirmPassword |
      | Mcall | mcall10@gmail.com | mcallMcall@1234 | mcallMcall@1234 |
    And User click on SignUp button
    And User profile page should be displayed

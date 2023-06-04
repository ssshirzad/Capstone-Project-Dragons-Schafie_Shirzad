@RetailSigIn/SignUpFeatures @Regression
Feature: SignInn/SignUp Page 

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @SignInRetail @Regression
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'Schafie.Shirzad@tekschool.us' and password 'UnitedStates@123'
    And User click on login button
    Then User should be logged in into Account

  @CreateAccountRetail @Regression 
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name  | email            | password        | confirmPassword |
      | Mcall | BashirHaidar@gmail.com | mcallMcall@1234 | mcallMcall@1234 |
    And User click on SignUp button
    And User profile page should be displayed

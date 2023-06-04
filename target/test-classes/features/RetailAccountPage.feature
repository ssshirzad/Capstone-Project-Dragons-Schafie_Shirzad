@RetailAccountFeatures @Regression
Feature: Retail Account Page 

  #Note: For this feature you have to have an account and be logged in into account. Repeated steps are under Background Keyword
  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'Schafie.Shirzad@tekschool.us' and password 'UnitedStates@123'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option

  @UpdateProfile  @Regression
  Scenario: Verify User can update Profile Information
    And User update Name 'Gul Baboo' and Phone '540-389-5190'
    And User click on Update button
    Then User profile information should be updated
    And A message should be displayed name update 'Personal Information Updated Successfully'

  @AddPaymentMethod  @Regression
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 9876545559876543 | Gul Rahman |              11 |           2025 |          321 |
    And User click on Add your card button
    Then A message should be displayed add payment 'Payment Method added successfully'

  @EditDebitCard  @Regression
  Scenario: Verify User can edit Debit or Credit card
    And User click on saved card image
    And User click on Edit option of card section
    And User edit information with below data
      | CardNumber       | NameOnCard | ExpirationMonth | ExpirationYear | SecurityCode |
      | 1245800890098765 | Gul RahimKhan  |              10 |           2028 |          893 |
    And User click on Update Your Card button
    Then A message should be displayed update payment 'Payment Method updated Successfully'

  @RemoveDebitCard  @Regression
  Scenario: Verify User can remove Debit or Credit card
    And User click on saved card image
    And User click on remove option of card section
    Then Payment details should be removed

  @AddAddress  @Regression
  Scenario: Verify User can add an Address
    And User click on Add address option
    And User fill address form with below information
      | Country       | FullName   | PhoneNumber  | StreetAddress | Apt | City    | State    | ZipCode |
      | United States | Spider Mann | 540 540 5440 | Winter Rd     | 321 | Henrico | Virginia |   52334 |
    And User click Add Your Address button
    Then A message should be displayed add address 'Address Added Successfully'

  @EditAddress  @Regression
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And User fill new address form with below information
      | Country       | FullName | PhoneNumber  | StreetAddress | Apt | City     | State   | ZipCode |
      | United States | Super Man | 450 444 4500 | Sang Drive  | 123 | Richmond | Vermont |   59930 |
    And User click update Your Address button
    Then A message should be displayed update address 'Address Updated Successfully'

  @RemoveAddress  @Regression
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed

  @ChangePassword  @Regression
  Scenario: Verify user can update password
    And User enter bellow information
      | previousPassword | newPassword      | confirmPassword  |
      | UnitedStates@123  | UnitedStates@123 | UnitedStates@123 |
    And User click on change password button
    Then A message should be displayed password change 'password changed successfully'

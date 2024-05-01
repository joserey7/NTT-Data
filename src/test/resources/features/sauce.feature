Feature: NTT Data - E2E Test for SauceDemo Application

  Background:
    Given The user navigates to "https://www.saucedemo.com/"
    And The user is on the login page
    When The user enters the username "standard_user"
    And The user enters the password "secret_sauce"
    And The user clicks on the login button
    Then The user should be navigated to the products page

  Scenario: Selects a product and pays for it
    Given The user is on the products page
    When The user clicks on the Add to cart button on the first product
    And The user should see the remove button
    And The user clicks on the shopping cart icon
    And The user should be navigated to the cart page
    And The user clicks on the checkout button
    And fills the personal information
    And clicks on the continue button
    And clicks on the finish button
    Then The user should see the thank you message "Thank you for your order!"

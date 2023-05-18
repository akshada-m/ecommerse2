Feature: to test add to cart functionality

  Scenario: to verify whether item getting added in cart
    Given we are on ecommerse application
    When we click on add to cart button
    Then user should be  navigate to summary page
    And user able to click on the Checkout button
    And user is able to add all required details in the Billing Address page
    And user is able to click on the Place Order button

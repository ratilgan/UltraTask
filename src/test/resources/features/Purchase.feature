@wip
Feature: Purchase flow for standard user

  Background: Login for standard user
    Given Standard user logs in

  Scenario: user adds and removes one item to the cart
    When user adds an item to the cart
    Then "Remove" text with red color should appear
    When user clicks "Remove" button
    Then "Add to cart" text should be visible again

  Scenario: user adds more than one items to the cart
    When user adds 5 item to the cart
    Then number of added items should be visible on the shopping cart badge






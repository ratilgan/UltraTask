@wip
Feature: Purchase flow for standard user

  Background: Login
    Given Standard user logs in

  Scenario: user adds/removes items to the cart
    When user adds an item to the cart randomly
    Then "Remove" text with red color should appear
    When user clicks "Remove"
    Then "Add to cart" text shoud be visible again


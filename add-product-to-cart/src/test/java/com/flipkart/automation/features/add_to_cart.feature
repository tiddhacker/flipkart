@UI
Feature: Add product to cart

  Scenario: Search for a product in flipkart and add to cart
    Given user navigates to flipkart homepage
    And login using username "sounakghosh62@gmail.com" and password "Pulsar150@"
    Then user search for a product "APPLE iPhone 12 (Black, 64 GB)"
    And then adds the product to cart
    Then verifies the product "APPLE iPhone 12 (Black, 64 GB)" is added to cart

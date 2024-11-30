Feature: Purchase a Product

  @Demo
  Scenario: Verify the integration of product checkout flow
    When user logged in with valid login details
    Then verify that it should redirect to product page
    And take a screenshot
    When user add "Sauce Labs Bolt T-Shirt" product to the cart
    Then verify that selected product is added to cart or not
    When user add "Sauce Labs Fleece Jacket" product to the cart
    Then verify that selected product is added to cart or not
@Cart @UI
Feature: Cart

  Scenario Outline: A user with valid account should be able to add product to the cart and verify it on the Shopping Cart page
    Given the user is on the Products page
    When the user searches for a "<Product Name>" product
    And the user presses the Add to Cart button
    Then the user should see a message and say Added!
    And the user presses the View Cart link
    Then the user should see that Shopping Cart page displays "<Product Name>", "<Price>", "<Quantity>" and "<Total>" are listed in the table

    Examples:
      | Product Name     | Price               | Quantity        | Total             |
      | Blue Top         | Rs. 500             | 1               | Rs. 500           |
      #| Men Tshirt       | Rs. 400             | 1               | Rs. 400           |
      #| Stylish Dress    | Rs. 1500            | 1               | Rs. 1500          |


  Scenario Outline: A same product is added to Cart with a different quantity then Shopping Cart page displays this product with the quantity and price updated.
    Given the user is on the Products page
     When the user searches for a "<Product Name>" product
     And the user presses the Add to Cart button
     Then the user should see a message and say Added!
     And the user presses the Continue Shopping button
     And the user goes to the Product Details page using the View Product link
     And the user adds the product to the cart with "<Add Quantity>" Quantity
     And the user presses the View Cart link
     Then the user should see that Shopping Cart page displays "<Product Name>", "<Price>", "<Expected Quantity>" and "<Total>" are listed in the table

    Examples:
      | Product Name          | Add Quantity     | Price      | Expected Quantity   | Total          |
      | Blue Top              | 4                | Rs. 500    |      5              | Rs. 2500       |
      #| Soft Stretch Jeans    | 8                | Rs. 799    |      9              | Rs. 7191       |


  Scenario Outline: A user with valid account should be able to remove a product from the cart information table.
    Given the user is on the Products page
    When the user searches for a "<Product Name>" product
    And the user presses the Add to Cart button
    And the user presses the View Cart link
    Then the user should delete "<Product Name>" product when he presses the cross icon of the product

    Examples:
      | Product Name     |
      | Blue Top         |
      #| Winter Top       |


  Scenario: A user with valid account should be able to verify that the products selected previously are the same in Checkout page
    Given the user is on the Products page
    When the user adds some products to the Cart
       | Product Name        |
       | Blue Top            |
       | Stylish Dress       |
       | Winter Top          |
    And the user goes to the Cart page using the Cart link
    Then the user should see that the products added to the Cart are the same previously selected
    And the user presses on Proceed To Checkout button
    Then the user should see that the products displayed in the Review Your Order section are the same as in Cart
    And the user should see that the Total Amount is computed correctly


  Scenario Outline: Quantity field of the Product Detail page should not accept numbers less to one for add to cart
    Given the user is on the Products page
    When the user searches for a "<Product Name>" product
    And the user goes to the Product Details page using the View Product link
    And the user adds the product to the cart with "<Number Value>" Quantity
    And the user presses the View Cart link
    Then the product added "<Product Name>" should not be listed in shopping cart table

    Examples:
      | Product Name      | Number Value     |
      | Blue Top          | 0                |
      | Winter Top        | -5               |






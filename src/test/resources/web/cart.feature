@Cart @UI
Feature: Cart

  Scenario Outline: A user with valid account should be able a add product to the cart and verify it on the Shopping Cart page
    Given I navigate to Products page
     When I enter a valid "<Product Name>" into Search Product search
     Then I should click on Add to Cart button
      And the product is added successfully
      And I click in View Cart link of the pop up displayed
      And the "<Product Name>", "<Price>", "<Quantity>" and "<Total>" are listed in the table

    Examples:
      | Product Name     | Price               | Quantity        | Total             |
      | Blue Top         | Rs. 500             | 1               | Rs. 500           |
      | Men Tshirt       | Rs. 400             | 1               | Rs. 400           |
      | Stylish Dress    | Rs. 1500            | 1               | Rs. 1500          |


  Scenario Outline: A same product is added to Cart with a different quantity then Shopping Cart page displays this product with the quantity and price updated.
    Given I navigate to Products page
     When I enter a valid "<Product Name>" into Search Product search
     Then I should click on Add to Cart button
      And I click on Continue Shopping button of the popup displayed
      And I should click on View Product link of the same product
      And I add to cart with Quantity "<Add Quantity>"
      And I click in View Cart link of the pop up displayed
     Then the "<Product Name>", "<Price>", "<Expected Quantity>" and "<Total>" are listed in the table

    Examples:
      | Product Name          | Add Quantity     | Price      | Expected Quantity   | Total          |
      | Blue Top              | 4                | Rs. 500    |      5              | Rs. 2500       |
      | Soft Stretch Jeans    | 8                | Rs. 799    |      9              | Rs. 7191       |

  Scenario Outline: A user with valid account should be able to remove a product from the cart information table.
    Given I navigate to Products page
     When I enter a valid "<Product Name>" into Search Product search
     Then I should click on Add to Cart button
      And I click in View Cart link of the pop up displayed
      And I click on the cross icon of the product "<Product Name>" and it is deleted

    Examples:
      | Product Name     |
      | Blue Top         |
      | Winter Top       |


  Scenario: A user with valid account should be able to verify that the products selected previously are the same in Checkout page
    Given I navigate to Products page
     When I add some products to the Cart
       | Product Name        |
       | Blue Top            |
       | Stylish Dress       |
       | Winter Top          |
     Then I click on Cart link
      And the products added to the Cart are the same previously selected
      And I click on Proceed To Checkout button
      And the products displayed in the Review Your Order are the same as in Cart
      And the Total Amount is correctly computed

  Scenario Outline: Quantity field of the Product detail page should not accept numbers less to one for add to cart
    Given I navigate to Products page
     When I enter a valid "Winter Top" into Search Product search
     Then I should click on View Product link of the same product
      And I add to cart with Quantity "<Number Value>"
      And I click in View Cart link of the pop up displayed
      And the product added "Winter Top" should not be listed in shopping cart table

    Examples:
      | Number Value     |
      | 0                |
      | -5               |






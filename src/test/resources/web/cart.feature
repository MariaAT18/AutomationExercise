@Cart @UI
Feature: Cart

  Scenario Outline: A user with valid account should be able to add product to the cart and verify it on the Shopping Cart page
    Given The user is in the Products page
     When The user writes "<Product Name>" in the Search Product Box
     Then The user press the Add to Cart button
      And The user sees a message and say Added!
      And The user press the View Cart link
      And The user sees that "<Product Name>", "<Price>", "<Quantity>" and "<Total>" are listed in the table

    Examples:
      | Product Name     | Price               | Quantity        | Total             |
      | Blue Top         | Rs. 500             | 1               | Rs. 500           |
      #| Men Tshirt       | Rs. 400             | 1               | Rs. 400           |
      #| Stylish Dress    | Rs. 1500            | 1               | Rs. 1500          |


  Scenario Outline: A same product is added to Cart with a different quantity then Shopping Cart page displays this product with the quantity and price updated.
    Given The user is in the Products page
     When The user writes "<Product Name>" in the Search Product Box
     Then The user press the Add to Cart button
      And The user press the Continue Shopping button
      And The user press on View Product link
      And The user adds to cart with Quantity "<Add Quantity>"
      And The user press the View Cart link
      And The user sees that "<Product Name>", "<Price>", "<Expected Quantity>" and "<Total>" are listed in the table

    Examples:
      | Product Name          | Add Quantity     | Price      | Expected Quantity   | Total          |
      | Blue Top              | 4                | Rs. 500    |      5              | Rs. 2500       |
      #| Soft Stretch Jeans    | 8                | Rs. 799    |      9              | Rs. 7191       |

  Scenario Outline: A user with valid account should be able to remove a product from the cart information table.
    Given The user is in the Products page
     When The user writes "<Product Name>" in the Search Product Box
     Then The user press the Add to Cart button
      And The user press the View Cart link
      And I click on the cross icon of the product "<Product Name>" and it is deleted

    Examples:
      | Product Name     |
      | Blue Top         |
      #| Winter Top       |


  Scenario: A user with valid account should be able to verify that the products selected previously are the same in Checkout page
    Given The user is in the Products page
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
    Given The user is in the Products page
     When The user writes "Winter Top" in the Search Product Box
     Then The user press on View Product link
      And The user adds to cart with Quantity "<Number Value>"
      And The user press the View Cart link
      And the product added "Winter Top" should not be listed in shopping cart table

    Examples:
      | Number Value     |
      | 0                |
      | -5               |






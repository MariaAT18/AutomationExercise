@Products @UI
Feature: Product

  Scenario Outline: A user with valid account should be able a search products by category and subcategory
    Given I navigate to Products page
     When I select a "<Category>" and "<Subcategory>"
     Then I should see "<ProductCount>" products for "<ProductTitle>"

    Examples:
      | Category         | Subcategory      |  ProductTitle                   |  ProductCount  |
      | Women            | Dress            |  WOMEN - DRESS PRODUCTS         |   3            |
      | Men              | Jeans            |  MEN - JEANS PRODUCTS           |   3            |
      | Kids             | Tops & Shirts    |  KIDS - TOPS & SHIRTS PRODUCTS  |   7            |

  Scenario Outline: A user with valid account should be able a search products by brand
    Given I navigate to Products page
     When I select the "<Brand Name>" and take note of the quantity
     Then I should see "<Product Count>" products for "<Product Title>"
      And the noted quantity is equal to "<Product Count>"

    Examples:
      | Brand Name     |  Product Count  | Product Title             |
      | Polo           |  6              | BRAND - POLO PRODUCTS     |
      | Babyhug        |  4              | BRAND - BABYHUG PRODUCTS  |
      | Madame         |  5              | BRAND - MADAME PRODUCTS   |


  Scenario Outline: A user with valid account should be able a find products in Search Product search
    Given I navigate to Products page
     When I enter a valid "<Criteria Search>" into Search Product search
     Then I should see "<Product Count>" products for "SEARCHED PRODUCTS"
      And I should see the product list match with the criteria searched

    Examples:
      | Criteria Search     | Product Count   |
      | pink                | 6               |
      #| tshirts             | 6               |
      | saree               | 3               |
      #| dress               | 9               |

  Scenario Outline: A user with valid account should be able to see the product detail page
    Given I navigate to Products page
     When I enter a valid "<Product Name>" into Search Product search
     Then I should click on View Product link of the same product
      And the following data should be displayed "<Product Name>", "<Category>", "<Price>", "<Availability>", "<Condition>", and "<Brand>" in products detail page

    Examples:
      | Product Name                   | Category        | Price    | Availability | Condition  | Brand        |
      | Blue Cotton Indie Mickey Dress  | Kids > Dress    | 1530     | In Stock     | New        | Biba         |
      | Rust Red Linen Saree            | Women > Saree   | 3500     | In Stock     | New        | Biba         |
      | Sleeveless Dress                | Women > Dress   | 1000     | In Stock     | New        | Madame       |

  Scenario Outline: A user with valid account should be able to add to cart a product
    Given I navigate to Products page
     When I enter a valid "<Product Name>" into Search Product search
     Then I should click on Add to Cart button
      And the product is added successfully
      And I click on Continue Shopping button of the popup displayed

    Examples:
      | Product Name                   |
      | Blue Cotton Indie Mickey Dress  |




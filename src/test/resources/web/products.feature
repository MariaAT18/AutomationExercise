@Products @UI
Feature: Product

  Scenario Outline: A user with valid account should be able a search products by category and subcategory
    Given the user is on the Products page
    When the user chooses a "<Category>" and "<Subcategory>"
    Then the user should see "<ProductCount>" products for "<ProductTitle>"

    Examples:
      | Category         | Subcategory      |  ProductTitle                   |  ProductCount  |
      | Women            | Dress            |  WOMEN - DRESS PRODUCTS         |   3            |
      #| Men              | Jeans            |  MEN - JEANS PRODUCTS           |   3            |
      #| Kids             | Tops & Shirts    |  KIDS - TOPS & SHIRTS PRODUCTS  |   7            |

  Scenario Outline: A user with valid account should be able a search products by brand
    Given the user is on the Products page
    When the user chooses a "<Brand Name>" and take note of the quantity
    Then the user should see "<Product Count>" products for "<Product Title>"
    And the user should verify that the noted quantity is equal to "<Product Count>"

    Examples:
      | Brand Name     |  Product Count  | Product Title             |
      | Polo           |  6              | BRAND - POLO PRODUCTS     |
      #| Babyhug        |  4              | BRAND - BABYHUG PRODUCTS  |
      #| Madame         |  5              | BRAND - MADAME PRODUCTS   |

  Scenario Outline: A user with valid account should be able a find products in Search Product search
    Given the user is on the Products page
    When the user searches for a "<Word Search>" product
    Then the user should see "<Product Count>" products for "SEARCHED PRODUCTS"
    And the user should see that the product list match with the word searched

    Examples:
      | Word Search     | Product Count   |
      | pink                | 6               |
      #| tshirts             | 6               |
      #| saree               | 3               |
      #| dress               | 9               |

  Scenario Outline: A user with valid account should be able to see the product detail page
    Given the user is on the Products page
    When the user searches for a "<Product Name>" product
    And the user goes to the Product Details page using the View Product link
    Then the user should see the following information in Product Detail page "<Product Name>", "<Category>", "<Price>", "<Availability>", "<Condition>", and "<Brand>"

    Examples:
      | Product Name                   | Category        | Price    | Availability | Condition  | Brand        |
      | Blue Cotton Indie Mickey Dress  | Kids > Dress    | 1530     | In Stock     | New        | Biba         |
      #| Rust Red Linen Saree            | Women > Saree   | 3500     | In Stock     | New        | Biba         |
      #| Sleeveless Dress                | Women > Dress   | 1000     | In Stock     | New        | Madame       |

  Scenario Outline: A user with valid account should be able to add to cart a product
    Given the user is on the Products page
    When the user searches for a "<Product Name>" product
    And the user presses the Add to Cart button
    Then the user should see a message and say Added!
    And the user presses the Continue Shopping button

    Examples:
      | Product Name                    |
      | Blue Cotton Indie Mickey Dress  |




@Products @UI
Feature: Product

  Scenario Outline: A user with valid account should be able a search products by category and subcategory
    Given The user is in the Products page
     When The user chooses a "<Category>" and "<Subcategory>"
     Then The user sees "<ProductCount>" products for "<ProductTitle>"

    Examples:
      | Category         | Subcategory      |  ProductTitle                   |  ProductCount  |
      | Women            | Dress            |  WOMEN - DRESS PRODUCTS         |   3            |
      #| Men              | Jeans            |  MEN - JEANS PRODUCTS           |   3            |
      #| Kids             | Tops & Shirts    |  KIDS - TOPS & SHIRTS PRODUCTS  |   7            |

  Scenario Outline: A user with valid account should be able a search products by brand
    Given The user is in the Products page
     When The user chooses a "<Brand Name>" and take note of the quantity
     Then The user sees "<Product Count>" products for "<Product Title>"
      And The user verifies that the noted quantity is equal to "<Product Count>"

    Examples:
      | Brand Name     |  Product Count  | Product Title             |
      | Polo           |  6              | BRAND - POLO PRODUCTS     |
      #| Babyhug        |  4              | BRAND - BABYHUG PRODUCTS  |
      #| Madame         |  5              | BRAND - MADAME PRODUCTS   |

  Scenario Outline: A user with valid account should be able a find products in Search Product search
    Given The user is in the Products page
     When The user writes "<Word Search>" in the Search Product Box
     Then The user sees "<Product Count>" products for "SEARCHED PRODUCTS"
      And The user sees the product list match with the word searched

    Examples:
      | Word Search     | Product Count   |
      | pink                | 6               |
      #| tshirts             | 6               |
      #| saree               | 3               |
      #| dress               | 9               |

  Scenario Outline: A user with valid account should be able to see the product detail page
    Given The user is in the Products page
     When The user writes "<Product Name>" in the Search Product Box
     Then The user press on View Product link
      And The user reviews the following data as "<Product Name>", "<Category>", "<Price>", "<Availability>", "<Condition>", and "<Brand>" in products detail page

    Examples:
      | Product Name                   | Category        | Price    | Availability | Condition  | Brand        |
      | Blue Cotton Indie Mickey Dress  | Kids > Dress    | 1530     | In Stock     | New        | Biba         |
      #| Rust Red Linen Saree            | Women > Saree   | 3500     | In Stock     | New        | Biba         |
      #| Sleeveless Dress                | Women > Dress   | 1000     | In Stock     | New        | Madame       |

  Scenario Outline: A user with valid account should be able to add to cart a product
    Given The user is in the Products page
     When The user writes "<Product Name>" in the Search Product Box
     Then The user press the Add to Cart button
      And The user sees a message and say Added!
      And The user press the Continue Shopping button

    Examples:
      | Product Name                   |
      | Blue Cotton Indie Mickey Dress  |




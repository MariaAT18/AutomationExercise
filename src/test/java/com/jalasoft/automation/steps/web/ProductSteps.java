package com.jalasoft.automation.steps.web;

import controller.UIController;
import entities.CartItem;
import entities.CheckoutItem;
import entities.ProductItem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ui.web.components.CheckoutTableSection;
import ui.web.components.ProductCartPopUp;
import ui.web.components.ProductSection;
import ui.web.components.TableShoppingSection;
import ui.web.pages.*;

import java.util.List;
import java.util.Map;

public class ProductSteps {
    private final UIController controller;
    private ProductPage productPage;
    private ProductSection productSection;
    private String criteriaSearchVerify;
    private ViewProductPage viewProductPage;
    private CheckoutPage checkoutPage;
    private CheckoutTableSection checkoutTableSection;
    private long expectedTotalAmount = 0;

    public ProductSteps(UIController controller) {
        this.controller = controller;
    }

    @Given("^the user is on the Products page$")
    public void navigateToProductPage() {
        HomePage homePage = controller.getHomePage();
        productPage = homePage.getTopBarMenu().clickProductsLink();
    }

    @Given("^the user chooses a \"(.*?)\" and \"(.*?)\"$")
    public void navigateToProductPageByCategory(String category, String subCategory) {
        productPage.getCategorySection().clickOnCategory(category);
        productSection = productPage.getCategorySection().clickOnSubCategory(category, subCategory);
    }

    @Given("^the user chooses a \"(.*?)\" and take note of the quantity$")
    public void navigateToProductPageByBrand(String brand) {
        productSection = productPage.getBrandSection().clickOnBrand(brand);
    }
    @Given("^the user searches for a \"(.*?)\" product$")
    public void enterAValidCriteriaIntoSearchProductSearch(String criteriaSearch) {
        criteriaSearchVerify = criteriaSearch;
        productPage.getSearchProductSection().writeCriteriaToSearch(criteriaSearch);
        productSection = productPage.getSearchProductSection().clickOnSubmitSearchButton();
    }

    @Given("^the user presses the View Cart link$")
    public void clickOnViewCartLink() {
        ProductCartPopUp productCartPopUp = controller.getProductCartPopUp();
        CartPage cartPage = productCartPopUp.clickOnViewCart();
        controller.setProductCartPopUp(null);
        controller.setCartPage(cartPage);
    }

    @Then("^the user should see \"(.*)\" products for \"(.*?)\"$")
    public void shouldSeeListProducts(String productCount, String productTitle) {
        Assert.assertEquals(productSection.getProductCount(), Integer.parseInt(productCount), "wrong product count");
        Assert.assertEquals(productSection.getTitleDisplaysSearchedProducts(), productTitle, "wrong page title");
    }

    @Given("^the user goes to the Product Details page using the View Product link$")
    public void clickOnViewProductLinkOfTheProductSelected() {
        Assert.assertFalse(productSection.getProductItems().isEmpty(), "product list must not be empty");
        ProductItem productItem = productSection.getProductItems().get(0);
        viewProductPage = productItem.clickOnViewProductLink();
        controller.setViewProductPage(viewProductPage);
    }

    @Given("^the user presses the Add to Cart button$")
    public void clickOnAddToCartButton() {
        Assert.assertFalse(productSection.getProductItems().isEmpty(), "product list must not be empty");
        ProductItem productItem = productSection.getProductItems().get(0);
        ProductCartPopUp productCartPopUp = productItem.clickOnAddToCartButton();
        controller.setProductCartPopUp(productCartPopUp);
    }

    @Then("^the user goes to the Cart page using the Cart link$")
    public void shouldClickOnCartLink() {
        // CartPage cartPage = controller.getHomePage().getTopBarMenuAuthenticated().clickCartLink();
        CartPage cartPage = controller.getHomePage().getTopBarMenu().clickCartLink();
        controller.setCartPage(cartPage);
    }

    @And("^the user presses on Proceed To Checkout button$")
    public void shouldClickOnProceedToCheckoutButton() {
        checkoutPage = controller.getCartPage().clickProceedToCheckoutButton();
    }

    @Given("^the user presses the Continue Shopping button$")
    public void clickOnContinueShopping() {
        ProductCartPopUp productCartPopUp = controller.getProductCartPopUp();
        Assert.assertNotNull(productCartPopUp, "cart popup was not initialized");
        productCartPopUp.clickOnContinueShopping();
        controller.setProductCartPopUp(null);
    }

    @When("^the user adds some products to the Cart$")
    public void shouldAddSomeProductsToTheCart(DataTable productsTable) {
        List<Map<String, Object>> products = productsTable.asMaps(String.class, Object.class);
        controller.setProducts(products);
        for (Map<String, Object> product : products) {
            productPage.getSearchProductSection().writeCriteriaToSearch(product.get("Product Name").toString());
            productSection = productPage.getSearchProductSection().clickOnSubmitSearchButton();

            Assert.assertFalse(productSection.getProductItems().isEmpty(), "product list must not be empty");
            ProductItem productItem = productSection.getProductItems().get(0);
            ProductCartPopUp productCartPopUp = productItem.clickOnAddToCartButton();
            productCartPopUp.clickOnContinueShopping();
        }
    }


    @Then("^the user should verify that the noted quantity is equal to \"(.*?)\"$")
    public void shouldTheNotedQuantityBeEqualToBrandNameCount(String brandQuantityItems) {
        Assert.assertEquals(productSection.getProductCount(), Integer.parseInt(brandQuantityItems), "wrong quantity count");
    }

    @Then("^the user should see the following information in Product Detail page \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", and \"(.*?)\"$")
    public void productDataShouldBeDisplayed(String productName, String category, String price, String availability, String condition, String brand) {
        Assert.assertEquals(viewProductPage.getTitle(), productName, "wrong product name");
        Assert.assertEquals(viewProductPage.getCategory(), category, "wrong category name");
        Assert.assertEquals(viewProductPage.getPrice(), price, "wrong price name");
        Assert.assertEquals(viewProductPage.getAvailability(), availability, "wrong availability name");
        Assert.assertEquals(viewProductPage.getCondition(), condition, "wrong condition name");
        Assert.assertEquals(viewProductPage.getBrand(), brand, "wrong brand name");
    }

    @Then("^the user should see that the product list match with the word searched$")
    public void shouldTheUserSeeTheProductListMatchWithTheCriteriaSearched() {
        List<ProductItem> productItemList = productSection.getProductItems();
        for (ProductItem item : productItemList) {
            Assert.assertTrue(item.getName().toLowerCase().contains(criteriaSearchVerify));
        }
    }

    @Then("^the user should see a message and say Added!$")
    public void productAddedSuccessfully() {
        ProductCartPopUp productCartPopUp = controller.getProductCartPopUp();
        Assert.assertEquals(productCartPopUp.getTitlePopup(), "Added!", "wrong popup title");
        Assert.assertEquals(productCartPopUp.getMessage(), "Your product has been added to cart.", "wrong popup message");
    }

    @And("^the user should see that the products added to the Cart are the same previously selected$")
    public void shouldProductsListedInCartBeTheSameAdded() {
        TableShoppingSection tableShoppingSection = controller.getCartPage().getTableShoppingSection();

        for (Map<String, Object> product : controller.getProducts()) {
            String expectedProductName = product.get("Product Name").toString();
            CartItem cartItem = tableShoppingSection.findItem(expectedProductName);
            Assert.assertNotNull(cartItem, expectedProductName + " not found in cart");
        }
    }



    @Then("^the user should see that the products displayed in the Review Your Order section are the same as in Cart$")
    public void shouldProductsInReviewYourOrderAreTheSameAsInCart() {
        checkoutTableSection = checkoutPage.getCheckoutTableSection();

        for (Map<String, Object> product : controller.getProducts()) {
            String expectedProductName = product.get("Product Name").toString();
            CheckoutItem checkoutItem = checkoutTableSection.findItem(expectedProductName);
            Assert.assertNotNull(checkoutItem, expectedProductName + " not found in checkout");
            String itemProductTotal = checkoutItem.getTotal().replace("Rs.", "").trim();
            expectedTotalAmount = expectedTotalAmount + Long.parseLong(itemProductTotal);
        }
    }

    @And("^the user should see that the Total Amount is computed correctly$")
    public void shouldTheTotalAmountBeComputedCorrectly() {
        Long actualTotalAmount = Long.parseLong(checkoutTableSection.getTotalAmount().replace("Rs.", "").trim());
        Assert.assertEquals(actualTotalAmount, expectedTotalAmount);
    }
}

package com.jalasoft.automation.steps.web;

import controller.UIController;
import entities.CartItem;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.web.components.ProductCartPopUp;
import ui.web.pages.CartPage;
import ui.web.pages.ProductPage;

public class CartSteps {
    private final UIController controller;
    private CartPage cartPage;
    private ProductPage productPage;

    public CartSteps(UIController controller) {
        this.controller = controller;
    }
    @And("^the user adds the product to the cart with \"(.*?)\" Quantity$")
    public void iAddToCartWithQuantity(String quantity) {
        ProductCartPopUp productCartPopUp = controller.getViewProductPage().addToCartWithQuantity(quantity);
        controller.setProductCartPopUp(productCartPopUp);
    }

    @Then("^the user should see that Shopping Cart page displays \"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\" are listed in the table$")
    public void shouldSeeListProducts(String productName, String price, String quantity, String total) {
        cartPage = controller.getCartPage();
        CartItem cartItem = cartPage.getTableShoppingSection().findItem(productName);

        Assert.assertNotNull(cartItem, "cart item " + productName + " is not listed");
        Assert.assertEquals(cartItem.getDescription(), productName, "wrong product name");
        Assert.assertEquals(cartItem.getPrice(), price, "wrong product price");
        Assert.assertEquals(cartItem.getQuantity(), quantity, "wrong product quantity");
        Assert.assertEquals(cartItem.getTotal(), total, "wrong total");
    }

    @Then("^the user should delete \"(.*?)\" product when he presses the cross icon of the product$")
    public void clickCrossIconOfTheProductToDelete(String productName) {
        CartItem cartItem = controller.getCartPage().getTableShoppingSection().findItem(productName);
        Assert.assertNotNull(cartItem);
        cartItem.getDeleteItem().click();
    }

    @Then("^the product added \"(.*?)\" should not be listed in shopping cart table$")
    public void productAddedShouldNotBeInShoppingCartTable(String productName) {
        CartItem cartItem = controller.getCartPage().getTableShoppingSection().findItem(productName);
        Assert.assertNull(cartItem, productName+" should not be listed in the table");
    }

    @Then("^the user should see a \"(.*?)\" message$")
    public void shouldTheUserSeeAMessageIfThereNotAreProducts(String message) {
        Assert.assertEquals(controller.getCartPage().getCartIsEmptyTextMessage(), message, "message displayed is incorrect");
    }


    @And("^the user goes to the Products page using the here link$")
    public void shouldTheUserGoesToProductsPageFromHereLink() {
        productPage = controller.getCartPage().getHereLink();
    }

    @And("^the user should see the \"(.*?)\" title$")
    public void shouldTheUserIsProductsPge(String productsTitle) {
        Assert.assertEquals(productPage.getAllProductsTitle().toLowerCase(), productsTitle.toLowerCase());
    }
}

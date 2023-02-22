package com.jalasoft.automation.steps.web;

import controller.UIController;
import entities.CartItem;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.web.components.ProductCartPopUp;
import ui.web.pages.CartPage;

public class CartSteps {
    private final UIController controller;
    private CartPage cartPage;

    @Then("^I add to cart with Quantity \"(.*?)\"$")
    public void iAddToCartWithQuantity(String quantity) {
        ProductCartPopUp productCartPopUp = controller.getViewProductPage().addToCartWithQuantity(quantity);
        controller.setProductCartPopUp(productCartPopUp);
    }

    public CartSteps(UIController controller) {
        this.controller = controller;
    }
    @Then("^the \"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\" are listed in the table$")
    public void shouldSeeListProducts(String productName, String price, String quantity, String total) {
        cartPage = controller.getCartPage();
        CartItem cartItem = cartPage.getTableShoppingSection().findItem(productName);

        Assert.assertNotNull(cartItem, "cart item " + productName + " is not listed");
        Assert.assertEquals(cartItem.getDescription(), productName, "wrong product name");
        Assert.assertEquals(cartItem.getPrice(), price, "wrong product price");
        Assert.assertEquals(cartItem.getQuantity(), quantity, "wrong product quantity");
        Assert.assertEquals(cartItem.getTotal(), total, "wrong total");
    }

    @And("^I click on the cross icon of the product \"(.*?)\" and it is deleted$")
    public void clickCrossIconOfTheProductToDelete(String productName) {
        CartItem cartItem = controller.getCartPage().getTableShoppingSection().findItem(productName);
        Assert.assertNotNull(cartItem);
        cartItem.getDeleteItem().click();
    }

    @And("^the product added \"(.*?)\" should not be listed in shopping cart table$")
    public void productAddedShouldNotBeInShoppingCartTable(String productName) {
        CartItem cartItem = controller.getCartPage().getTableShoppingSection().findItem(productName);
        Assert.assertNull(cartItem, productName+" should not be listed in the table");
    }
}

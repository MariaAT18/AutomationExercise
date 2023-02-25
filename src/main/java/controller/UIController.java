package controller;

import ui.web.components.ProductCartPopUp;
import ui.web.pages.CartPage;
import ui.web.pages.HomePage;
import ui.web.pages.ViewProductPage;

import java.util.List;
import java.util.Map;

public class UIController {
    private HomePage homePage;
    private CartPage cartPage;
    private ProductCartPopUp productCartPopUp;
    private ViewProductPage viewProductPage;
    private List<Map<String, Object>> products;
    private String userName;
    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public void setCartPage(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public void setProductCartPopUp(ProductCartPopUp productCartPopUp) {
        this.productCartPopUp = productCartPopUp;
    }

    public ProductCartPopUp getProductCartPopUp() {
        return productCartPopUp;
    }

    public ViewProductPage getViewProductPage() {
        return viewProductPage;
    }

    public void setViewProductPage(ViewProductPage viewProductPage) {
        this.viewProductPage = viewProductPage;
    }

    public List<Map<String, Object>> getProducts() {
        return products;
    }

    public void setProducts(List<Map<String, Object>> products) {
        this.products = products;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}

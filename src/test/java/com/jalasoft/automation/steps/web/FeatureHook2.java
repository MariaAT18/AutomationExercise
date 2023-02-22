package com.jalasoft.automation.steps.web;

import controller.UIController;
import entities.CartItem;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import ui.PageTransporter;
import ui.methods.CommonMethods;
import ui.web.pages.CartPage;
import ui.web.pages.HomePage;
import ui.web.pages.LandingPage;
import ui.web.pages.LoginPage;

public class FeatureHook2 {
    private UIController controller;
    private static final PageTransporter pageTransporter = PageTransporter.getInstance();

    public FeatureHook2(UIController controller) {
        this.controller = controller;
    }

    @Before("@Products or @Cart")
    public void doLogin() {
        LandingPage landingPage = pageTransporter.navigateToLandingPage();
        LoginPage loginPage = landingPage.getTopHeader().clickLoginLink();
        HomePage homePage = loginPage.loginWithProfileUser("user");
        controller.setHomePage(homePage);
    }

    @After(value = "@ExecuteLogout or @Cart or @Products", order = 1)
    public void afterLogin() {
        CommonMethods.logout();
    }

    @After(value = "@Cart",order = 100)
    public void afterCart() {
        LandingPage landingPage = pageTransporter.navigateToLandingPage();
        CartPage cartPage = landingPage.getTopHeader().clickCartLink();
        for (CartItem cartItem : cartPage.getTableShoppingSection().getCartItems()) {
            cartItem.getDeleteItem().click();
        }
    }
}
